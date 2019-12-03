package com.uniajc.diplomado.services.document.entity;

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
import java.util.Date;

@Entity
@Table (name = "Document")
public class Document
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nameDocument;

    @NotNull
    private String description;


    private String author;

    private Date creationdate;

    private Long ownerID;

    public Document () {
    }

    public Document (String nameDocument, String description) {
        this.nameDocument = nameDocument;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameCompany) {
        this.nameDocument = nameDocument;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public Date getCreationdate ()
    {
        return creationdate;
    }

    public void setCreationdate (Date creationdate)
    {
        this.creationdate = creationdate;
    }

    public Long getOwnerID ()
    {
        return ownerID;
    }

    public void setOwnerID (Long ownerID)
    {
        this.ownerID = ownerID;
    }
}
