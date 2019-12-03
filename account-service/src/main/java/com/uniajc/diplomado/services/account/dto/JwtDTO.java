package com.uniajc.diplomado.services.account.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.dto
 * Shaft
 *  *
 * the name of the current project
 */
public class JwtDTO
{
    private String token;
    private String bearer = "Bearer";
    private String login;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String login, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.login = login;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
