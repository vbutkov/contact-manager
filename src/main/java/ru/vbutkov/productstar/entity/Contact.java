package ru.vbutkov.productstar.entity;

import java.util.List;
import java.util.Objects;

public class Contact {

    private static long generator = 1;
    private long idContact;
    private String name;
    private String lastName;
    private List<String> phoneNumber;
    private List<String> email;

    public Contact(String name, String lastName, List<String> phoneNumber, List<String> email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.idContact = generator++;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public void setGenerator(long generator) {
        this.generator = generator;
    }

    public long getGenerator() {
        return generator;
    }

    public long getIdContact() {
        return idContact;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "generator=" + generator +
                ", idContact=" + idContact +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return idContact == contact.idContact && Objects.equals(name, contact.name) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContact, name, lastName, phoneNumber, email);
    }
}
