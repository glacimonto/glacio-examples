package com.github.fridujo.glacio.examples;

import com.github.fridujo.glacio.examples.persistence.ContactInfo;

public class ContactInfoDto {
    public String id;
    public String name;
    public String forename;
    public String email;

    public static ContactInfoDto from(ContactInfo contactInfo) {
        ContactInfoDto dto = new ContactInfoDto();
        dto.id = contactInfo.getId();
        dto.name = contactInfo.getName();
        dto.forename = contactInfo.getForename();
        dto.email = contactInfo.getEmail();
        return dto;
    }

    public ContactInfo persistable() {
        return new ContactInfo(id, name, forename, email);
    }
}
