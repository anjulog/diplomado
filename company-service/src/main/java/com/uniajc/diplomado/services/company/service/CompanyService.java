package com.uniajc.diplomado.services.company.service;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.service
 * Shaft
 *  *
 * the name of the current project
 */

import com.uniajc.diplomado.services.company.entity.Company;
import com.uniajc.diplomado.services.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService
{
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAll (){
        List<Company> lista = companyRepository.findAll ();
        return lista;
    }

    public Optional<Company> getById (Long id){
        return companyRepository.findById (id);
    }

    public Optional<Company> getByName (String np){
        return companyRepository.findByNameCompany (np);
    }

    public void storage (Company Company){
        companyRepository.save (Company);
    }

    public void delete (Long id){
        companyRepository.deleteById (id);
    }

    public boolean existByName (String np){
        return companyRepository.existsByNameCompany (np);
    }

    public boolean existById (Long id){
        return companyRepository.existsById (id);
    }
}
