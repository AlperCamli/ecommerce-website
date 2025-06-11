package com.nature.Nature.Model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart cart;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String expectedOrderStatus;
    private String orderStatus;
    private Date deliveryDate;
    private Date shipmentDate;
    private Date orderDate;
}
