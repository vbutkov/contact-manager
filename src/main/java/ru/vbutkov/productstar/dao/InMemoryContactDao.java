package ru.vbutkov.productstar.dao;

import org.springframework.stereotype.Repository;
import ru.vbutkov.productstar.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryContactDao implements ContactDao {

    private List<Contact> contacts;

    public InMemoryContactDao() {
        this.contacts = new ArrayList<>();
        initContacts();
    }

    private void initContacts() {
        this.contacts.add(new Contact("Владимир", "Бутков", List.of("+79490569812", "+7670569812"), List.of("test@mail.ru", "test@yandex.ru")));
        this.contacts.add(new Contact("Мария", "Цымбалюк", List.of("+79411569745", "+76711569745"), List.of("test@mail.ru", "test@yandex.ru")));
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public void createContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public Optional<Contact> findContact(long id) {
        return contacts.stream()
                .filter(contact -> contact.getIdContact() == id)
                .findFirst();
    }

    @Override
    public Contact getContact(long id) {
        return findContact(id)
                .orElseThrow(() -> new IllegalArgumentException("Contact not found" + id));

    }
}
