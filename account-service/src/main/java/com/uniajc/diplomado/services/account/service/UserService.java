package com.uniajc.diplomado.services.account.service;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.service
 * Shaft
 *  *
 * the name of the current project
 */

import com.uniajc.diplomado.services.account.entity.User;
import com.uniajc.diplomado.services.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService
{

    @Autowired
    UserRepository UserRepository;

    public Optional<User> getByNameUser (String nu){
        return UserRepository.findByNameUSer (nu);
    }
    public Optional<User> getByLogin (String nu){
        return UserRepository.findByLogin (nu);
    }

    public boolean existsByLogin( String nu){
        return UserRepository.existsByLogin (nu);
    }

    public  boolean existsByEmail(String email){
        return UserRepository.existsByEmail (email);
    }

    public void storage (User user){
        UserRepository.save (user);
    }
}
