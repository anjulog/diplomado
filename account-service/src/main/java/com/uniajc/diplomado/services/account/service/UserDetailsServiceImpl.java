package com.uniajc.diplomado.services.account.service;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.service
 * Shaft
 *  *
 * the name of the current project
 */
import com.uniajc.diplomado.services.account.entity.User;
import com.uniajc.diplomado.services.account.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User usuario = userService.getByLogin (login).get ();
        return SecurityUser.build (usuario);
    }

}
