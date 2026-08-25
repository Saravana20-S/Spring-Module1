package org.bridgelabz.ecomerse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    private String username;

    private String email;
    private String password;
    private String role;

    // getters
}