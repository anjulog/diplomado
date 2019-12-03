package com.uniajc.diplomado.services.account.service;

import com.uniajc.diplomado.services.account.entity.Rol;
import com.uniajc.diplomado.services.account.enums.RolNames;
import com.uniajc.diplomado.services.account.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.service
 * Shaft
 *  *
 * the name of the current project
 */
@Service
@Transactional
public class RolService
{

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNames (RolNames rolNames){
        return rolRepository.findByRolNames (rolNames);
    }
}
