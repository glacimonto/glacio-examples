package com.github.fridujo.glacio.examples.stepdefs;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.fridujo.glacio.examples.persistence.ContactRepository;
import com.github.fridujo.glacio.running.api.Given;

public class DatabaseSteps {

    private final ContactRepository contactRepository;

    public DatabaseSteps(@Autowired ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Given("database is empty")
    public void database_is_empty() {
        contactRepository.findAll().forEach(ci -> contactRepository.delete(ci.getId()));
    }
}
