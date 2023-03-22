package ru.vbutkov.productstar.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vbutkov.productstar.dao.ContactDao;
import ru.vbutkov.productstar.dto.ContactDto;
import ru.vbutkov.productstar.entity.Contact;
import ru.vbutkov.productstar.responce.AccountResponce;
import ru.vbutkov.productstar.responce.AccountResult;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactFacade {

    private final ContactDao contactDao;

    @Autowired
    public ContactFacade(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public List<ContactDto> getContacts() {
        return contactDao.getContacts().stream()
                .map(contact -> new ContactDto(
                        contact.getIdContact(),
                        contact.getName(),
                        contact.getLastName(),
                        contact.getPhoneNumber(),
                        contact.getEmail()))
                .collect(Collectors.toList());
    }

    public ContactDto getContact(long id) {
        var contact = contactDao.getContact(id);
        return new ContactDto(
                contact.getIdContact(),
                contact.getName(),
                contact.getLastName(),
                contact.getPhoneNumber(),
                contact.getEmail()
        );
    }

    public ContactDto createContact(ContactDto contactDto) {
        Contact contact = new Contact(
                contactDto.getName(),
                contactDto.getLastName(),
                contactDto.getPhoneNumber(),
                contactDto.getEmail()
        );
        contactDao.createContact(contact);
        contactDto.setId(contact.getIdContact());

        return contactDto;
    }

    public ContactDto update(long id, ContactDto contactDto) {
        var contact = contactDao.getContact(id);
        contact.setName(contactDto.getName());
        contact.setLastName(contactDto.getLastName());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        contact.setEmail(contactDto.getEmail());

        return contactDto;
    }

    public AccountResponce remove(long id) {
        var contact = contactDao.getContact(id);
        contactDao.getContacts().remove(contact);

        return new AccountResponce(AccountResult.SUCCESS);
    }
}
