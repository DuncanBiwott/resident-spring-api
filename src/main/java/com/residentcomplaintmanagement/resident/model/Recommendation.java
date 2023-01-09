package com.residentcomplaintmanagement.resident.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "recommendation")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "description")
    private String description;

    @Column(name = "user")
    private String user;

    @Column(name = "image")
    private String image;




}
