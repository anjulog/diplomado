package com.uniajc.diplomado.services.account.repository;

import com.uniajc.diplomado.services.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.repository
 * Shaft
 *  *
 * the name of the current project
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByNameUSer (String nu);
    Optional<User> findByLogin (String nu);
    boolean existsByLogin(String nu);
    boolean existsByEmail(String email);
}
