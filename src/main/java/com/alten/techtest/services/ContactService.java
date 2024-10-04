package com.alten.techtest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.techtest.entities.Contact;
import com.alten.techtest.repositories.ContactRepository;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

     public void createContact(Contact contact) {
            this.contactRepository.save(contact);
            System.out.println("Contact created");
        }
    
}
