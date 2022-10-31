package com.residentcomplaintmanagement.resident.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.security.Timestamp;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username",nullable = false)
    private String name;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "active",nullable = false)
    private int active;
    @Column(name = "create_at",nullable = true)
    private Timestamp createdAt;
    @Column(name = "updated_at",nullable = true)
    private Timestamp updatedAt;

}
