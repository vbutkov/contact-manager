package ru.vbutkov.productstar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vbutkov.productstar.dto.ContactDto;
import ru.vbutkov.productstar.facade.ContactFacade;
import ru.vbutkov.productstar.responce.AccountResponce;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactFacade contactFacade;

    @Autowired
    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @GetMapping
    public List<ContactDto> getContacts() {
        return contactFacade.getContacts();
    }

    @GetMapping("/{id}")
    public ContactDto getContact(@PathVariable long id) {
        return contactFacade.getContact(id);
    }

    @PostMapping
    public ContactDto createContact(@RequestBody ContactDto contactDto) {
        return contactFacade.createContact(contactDto);
    }

    @PutMapping("/{id}/edit")
    public ContactDto updateContact(
            @PathVariable long id,
            @RequestBody ContactDto contactDto) {

        return contactFacade.update(id, contactDto);
    }

    @DeleteMapping("/{id}/delete")
    public AccountResponce removeContact(@PathVariable long id) {
        return contactFacade.remove(id);
    }


}
