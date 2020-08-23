package com.example.companymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
public class Department implements Serializable {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Company company;

    @OneToMany(mappedBy = "department" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
    @JsonManagedReference
    private Set<Office> offices = new HashSet<>();

}
