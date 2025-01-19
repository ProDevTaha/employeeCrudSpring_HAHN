package com.hahn.employees.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "role")
@Data
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
