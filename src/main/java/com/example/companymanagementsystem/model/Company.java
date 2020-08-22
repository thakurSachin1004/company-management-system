package com.example.companymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPANY", uniqueConstraints = {@UniqueConstraint(columnNames = "Name")})
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval = true)
    @JsonManagedReference
    private Set<Car> cars = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval = true)
    @JsonManagedReference
    private Set<Department> departments = new HashSet<>();

}
