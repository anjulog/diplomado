package com.uniajc.diplomado.services.account.dto;

import javax.validation.constraints.NotBlank;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.dto
 * Shaft
 *  *
 * the name of the current project
 */
public class LoginUser
{
    @NotBlank
    private String login;

    @NotBlank
    private String password;

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
}
