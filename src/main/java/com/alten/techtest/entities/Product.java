package com.alten.techtest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="products")
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="image")
    private String image;

    @Column(name="category")
    private String category;

    @Column(name="price")
    private Integer price;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="internalreference")
    private String internalreference;

    @Column(name="shellid")
    private Integer shellid;

    @Column(name="inventorystatus")
    private String inventorystatus;

    @Column(name="rating")
    private Integer rating;

    @Column(name="created_at", updatable= false)
    private String createdAt;

    @Column(name="updated_at")
    private String updatedAt;
    
    public Product()
    {

    }

    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public String getCategory() {
        return this.category;
    }

    public Integer getPrice() {
        return this.price;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    public String getinternalreference() {
        return internalreference;
    }

    public Integer getshellid() {
        return this.shellid;
    }

    public String getinventorystatus() {
        return this.inventorystatus;
    }

    public Integer getRating() {
        return this.rating;
    }

    public String getCreatedAt(){
        return this.createdAt;
    }

    public String getUpdateAt(){
        return this.updatedAt;
    }

    public Long setId(Long id) {
        return this.id = id;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setinternalreference(String internalreference) {
        this.internalreference = internalreference;
    }

    public void setshellid(Integer shellid) {
        this.shellid = shellid;
    }

    public void setInventorystatus( String inventoystatus) {
        this.inventorystatus = inventoystatus;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setCreatedAt(String date) {
        this.createdAt = date;        
    }

    public void setupdatedAt(String date) {
        this.updatedAt = date;        
    }
    // name, description, image, category, price, quantity, internalReference, shellId, inventoryStatus, rating, createdAt, updateAt
// inventoryStuatus = new ArrayList<string>();
// inventoryStuatus.add("INSTOCK", "LOWSTOCK", "OUTOFSTOCK");

}