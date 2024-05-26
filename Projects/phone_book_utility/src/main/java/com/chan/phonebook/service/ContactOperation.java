package com.chan.phonebook.service;

import com.chan.phonebook.entity.ContactDetail;
import com.chan.phonebook.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactOperation {

    private final ContactRepo contactRepo;

    public String addContact(ContactDetail contact) {

        Optional<ContactDetail> contactExist = contactRepo.findByNameIgnoreCaseAndPhoneNumberAndAddressIgnoreCase(
                contact.getName(), contact.getPhoneNumber(), contact.getAddress());
        if (contactExist.isPresent()) {
            return String.format("%s already exists!", contactExist.get());
        }
        ContactDetail savedContact = contactRepo.save(contact);
        return String.format("Contact '%s' has been saved/updated successfully!", savedContact.getName());
    }

    public String deleteContact(long id) {

        Optional<ContactDetail> deleteContact = contactRepo.findById(id);
        contactRepo.deleteById(id);
        return String.format("Contact '%s' has been deleted successfully!",
                deleteContact.orElse(new ContactDetail()).getName());
    }

    public ContactDetail editContact(long id) {

        return contactRepo.findById(id).orElse(new ContactDetail());
    }

    public List<ContactDetail> getAllContact() {

        return contactRepo.findAllByOrderByNameAsc();
    }

    public List<ContactDetail> searchContact(String textInput) {

        if (textInput.matches(".*\\d.*")) {
            log.info("Searching for contact with given phone number {}", textInput);
            return contactRepo.findByPhoneNumberOrderByNameAsc(Long.parseLong(textInput));
        }
        log.info("Searching for contact with given name {}", textInput);
        return contactRepo.findByNameStartingWithIgnoreCaseOrderByNameAsc(textInput);
    }
}
