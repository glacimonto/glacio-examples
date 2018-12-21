package com.github.fridujo.glacio.examples;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.atomic.AtomicReference;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.github.fridujo.glacio.examples.persistence.ContactInfo;
import com.github.fridujo.glacio.examples.persistence.ContactRepository;

@SpringBootTest(classes = ApplicationBootstrap.class, properties = "spring.main.banner-mode=off")
@AutoConfigureMockMvc
class ApplicationIntegrationTest {

    private final MockMvc mockMvc;
    private final ContactRepository contactRepository;

    ApplicationIntegrationTest(@Autowired MockMvc mockMvc,
                               @Autowired ContactRepository contactRepository) {
        this.mockMvc = mockMvc;
        this.contactRepository = contactRepository;
    }

    @BeforeEach
    void setUp() {
        contactRepository.findAll().forEach(ci -> contactRepository.delete(ci.getId()));
    }

    @Test
    void inserting_contact_returns_its_id() throws Exception {
        ContactInfoDto contactToInsert = ContactInfoDto.from(
            new ContactInfo(null, "John", "Doe", "john.doe@contact.com"));
        AtomicReference<String> generatedId = new AtomicReference<>();
        mockMvc.perform(
            post("/api/contact")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJson(contactToInsert)))
            .andDo(mvcResult -> generatedId.set(mvcResult.getResponse().getContentAsString()))
            .andExpect(status().isCreated());

        mockMvc.perform(get("/api/contact/jo*"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(generatedId.get())));
    }

    private String toJson(Object object) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
