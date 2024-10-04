package com.alten.techtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alten.techtest.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>  {
    
}
