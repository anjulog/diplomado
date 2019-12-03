package com.uniajc.diplomado.services.company.entity;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.entity
 * Shaft
 *  *
 * the name of the current project
 */

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Company")
public class Company {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nameCompany;

    @NotNull
    private String description;

    public Company() {
    }

    public Company(String nameCompany, String description) {
        this.nameCompany = nameCompany;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
