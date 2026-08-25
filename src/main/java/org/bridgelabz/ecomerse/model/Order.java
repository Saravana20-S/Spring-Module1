package org.bridgelabz.ecomerse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {
    @Id
    int id;
    String name;
    int value;
    String createdAt;
    String status;
    String paidBy;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
