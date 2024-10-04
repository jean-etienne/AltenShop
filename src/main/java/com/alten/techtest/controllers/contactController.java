package com.alten.techtest.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alten.techtest.entities.Contact;
import com.alten.techtest.services.ContactService;


@RestController
@RequestMapping(path="/contact")
public class contactController {

    @Autowired
    private ContactService contactService;

    public contactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createContact(@RequestBody Contact contact) {
        this.contactService.createContact(contact);
        System.out.println("all is created");
    }




    
}
