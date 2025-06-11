package com.nature.Nature.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private int stock;
    private String imageUrl;
    private String description;
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
}
