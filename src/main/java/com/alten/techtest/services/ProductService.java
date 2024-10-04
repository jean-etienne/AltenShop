package com.alten.techtest.services;
import com.alten.techtest.entities.Product;
import com.alten.techtest.repositories.ProductRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    
    public Optional<Product> getProductById(long id) {
    return productRepository.findById(id);
    }

    public void createItem(Product product) {
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now();
        product.setCreatedAt(dtf.format(currentDate));
        product.setupdatedAt(dtf.format(currentDate));
        this.productRepository.save( product);
        System.out.println("product created");
        }

    public Product update( Product product, Long id) {
        String created_at = product.getCreatedAt();
        product.setCreatedAt(created_at);
        product.setupdatedAt(FormatCurrentDate());
        return productRepository.save(product);
    }

    public void delete(long id) {          
       Product productToDelete = this.productRepository.findById(id).orElseThrow(
        ()-> new RuntimeException());
        productRepository.delete(productToDelete);   
        System.out.println("L'element a bien ete supprime");
    }

    public String FormatCurrentDate(){
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        return dtf.format(date);
    }

}