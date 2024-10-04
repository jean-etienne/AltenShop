package com.alten.techtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alten.techtest.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    
}
