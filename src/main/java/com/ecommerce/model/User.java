package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="users")
public class User {
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
}
