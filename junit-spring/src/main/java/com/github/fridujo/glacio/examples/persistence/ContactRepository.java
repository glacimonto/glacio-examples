package com.github.fridujo.glacio.examples.persistence;

import java.util.Collection;

public interface ContactRepository {

    String insert(ContactInfo contactInfo) throws ContactAlreadyExistingException;

    void update(ContactInfo contactInfo) throws ContactNotFoundException;

    void delete(String id) throws ContactNotFoundException;

    Collection<ContactInfo> findAll();

    Collection<ContactInfo> findByName(String nameRegex);
}
