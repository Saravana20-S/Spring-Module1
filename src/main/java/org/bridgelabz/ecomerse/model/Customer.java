package org.bridgelabz.ecomerse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    int id;

    String name;

    String email;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    List<Order> orders=new ArrayList<>();

}
