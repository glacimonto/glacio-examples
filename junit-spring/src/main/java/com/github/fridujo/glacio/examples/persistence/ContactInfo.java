package com.github.fridujo.glacio.examples.persistence;

import java.util.Objects;

public class ContactInfo {
    private final String id;
    private final String name;
    private final String forename;
    private final String email;

    public ContactInfo(String id, String name, String forename, String email) {
        this.id = id;
        this.name = name;
        this.forename = forename;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getForename() {
        return forename;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(forename, that.forename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, forename);
    }

    public ContactInfo withId(String id) {
        return new ContactInfo(id, name, forename, email);
    }
}
