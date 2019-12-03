package com.uniajc.diplomado.services.account.security;

import com.uniajc.diplomado.services.account.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.security
 * Shaft
 *  *
 * the name of the current project
 */

public class SecurityUser implements UserDetails
{

    private Long id;
    private String nombre;
    private String nombreUser;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public SecurityUser(Long id, String nombre, String nombreUser, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUser = nombreUser;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static SecurityUser build (User User){
        List<GrantedAuthority> authorities =
                User.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNames ().name())).collect(Collectors.toList());
        return new SecurityUser(User.getId(), User.getNameUSer (), User.getLogin (), User.getEmail(), User.getPassword(), authorities);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
