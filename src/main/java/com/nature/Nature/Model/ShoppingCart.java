package com.nature.Nature.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String cartStatus;

    @OneToMany(mappedBy = "cart")
    private List<Contains> contains;
}
