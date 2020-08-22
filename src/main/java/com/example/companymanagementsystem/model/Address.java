package com.example.companymanagementsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
public class Address {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "ZIP_CODE")
    private String zipCode;
}
