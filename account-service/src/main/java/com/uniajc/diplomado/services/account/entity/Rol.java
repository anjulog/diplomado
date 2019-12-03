package com.uniajc.diplomado.services.account.entity;

import com.uniajc.diplomado.services.account.enums.RolNames;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.entity
 * Shaft
 *  *
 * the name of the current project
 */

@Entity
public class Rol
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated (EnumType.STRING)
    @NotNull
    private RolNames rolNames;

    public Rol() {
    }

    public Rol(@NotNull RolNames RolNames) {
        this.rolNames = RolNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolNames getRolNames() {
        return rolNames;
    }

    public void setRolNames(RolNames RolNames) {
        this.rolNames = RolNames;
    }
}
