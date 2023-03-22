package ru.vbutkov.productstar.dao;

import ru.vbutkov.productstar.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {

    Optional<Contact> findContact(long id);

    Contact getContact(long id);

    List<Contact> getContacts();

    void createContact(Contact contact);

}
