package com.chan.phonebook.web;

import com.chan.phonebook.entity.ContactDetail;
import com.chan.phonebook.service.ContactOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ContactController {

    private final ContactOperation contactOperation;

    @PostMapping("/")
    public String enterContact(@ModelAttribute ContactDetail contactDetail, RedirectAttributes redirectAttributes) {

        String message = contactOperation.addContact(contactDetail);
        log.debug(message);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        String message = contactOperation.deleteContact(id);
        log.debug(message);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model) {

        ContactDetail editedContact = contactOperation.editContact(id);
        model.addAttribute("contactDetail", editedContact);
        return "edit";
    }

    @GetMapping("/")
    public String getAllContacts(Model model) {

        List<ContactDetail> allContact = contactOperation.getAllContact();
        model.addAttribute("contactDetails", allContact);
        model.addAttribute("contactDetail", new ContactDetail());
        return "index";
    }

    @GetMapping("/search")
    public String searchContact(@RequestParam String textInput, Model model) {

        List<ContactDetail> searchResult = contactOperation.searchContact(textInput);
        log.debug("Total search result for the given name: {}", searchResult.size());
        model.addAttribute("contactDetails", searchResult);
        model.addAttribute("contactDetail", new ContactDetail());
        model.addAttribute("message", String.format(" %s contact(s) matched for '%s'",
                searchResult.size(), textInput));
        return "index";
    }

}
