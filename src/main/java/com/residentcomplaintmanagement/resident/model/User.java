package com.residentcomplaintmanagement.resident.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.security.Timestamp;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
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



}
