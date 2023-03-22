package ru.vbutkov.productstar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ContactDto {

    private long id;
    @JsonProperty
    private final String name;
    @JsonProperty
    private final String lastName;
    @JsonProperty
    private final List<String> phoneNumber;
    @JsonProperty
    private final List<String> email;

    public ContactDto(long id, String name, String lastName, List<String> phoneNumber, List<String> email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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
}
