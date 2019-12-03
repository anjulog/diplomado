package com.uniajc.diplomado.services.account.repository;

import com.uniajc.diplomado.services.account.entity.Rol;
import com.uniajc.diplomado.services.account.enums.RolNames;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.repository
 * Shaft
 *  *
 * the name of the current project
 */
public interface RolRepository extends JpaRepository<Rol, Long>
{
    Optional<Rol> findByRolNames (RolNames rolNames);
}
