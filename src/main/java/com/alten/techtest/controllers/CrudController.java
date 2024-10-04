package com.alten.techtest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alten.techtest.entities.Product;
import com.alten.techtest.services.ProductService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path="/products")
public class CrudController {
    
    @Autowired
    private ProductService productService;

    public CrudController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(path= "/get")
    public List<Product> getAllItems() {
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println("tout est retourné "+ dtf.format(currentDate));
        return productService.getAllProducts();
    }

    @GetMapping(path="/get/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createItem(@RequestBody Product product) {
        this.productService.createItem(product);
    }

    @ResponseStatus(value = HttpStatus.PARTIAL_CONTENT)
    @PatchMapping(path= "/update/{id}")
    @Transactional
    public void update(@RequestBody Product product, @PathVariable Long id ) {
        product.setId(id);
        this.productService.update(product, id);
        System.out.println("its mis a jour");
    }
    

    // @ResponseStatus(value = HttpStatus.PARTIAL_CONTENT)
    // @PatchMapping(path= "/{id}")
    // public void update(@RequestBody Product product, @PathVariable Long id) {
    //     this.productService.update(product);
    // }

    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable long id) {
        try {
            this.productService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}