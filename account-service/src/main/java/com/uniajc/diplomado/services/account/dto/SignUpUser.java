package com.uniajc.diplomado.services.account.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.dto
 * Shaft
 *  *
 * the name of the current project
 */
public class SignUpUser
{
    @NotBlank
    private String nameUser;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    private Set<String> roles;

    public String getNameUser () {
        return nameUser;
    }

    public void setNameUser (String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
