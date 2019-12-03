package com.uniajc.diplomado.services.account.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.entity
 * Shaft
 *  *
 * the name of the current project
 */

@Entity
@Data
public class User
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nameUSer;

    @NotNull
    @Column (unique = true)
    private String login;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @NotNull
    @ManyToMany
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "rolid"))
    private Set<Rol> roles = new HashSet<> ();

    public User() {
    }

    public User(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
        this.nameUSer = nombre;
        this.login = nombreUsuario;
        this.email = email;
        this.password = password;
    }


    public void setRoles (Set<Rol> roles)
    {
        this.roles = roles;
    }
}
