package com.uniajc.diplomado.services.company.repository;

import com.uniajc.diplomado.services.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.repository
 * Shaft
 *  *
 * the name of the current project
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>
{
    Optional<Company> findByNameCompany (String np);

    boolean existsByNameCompany (String np);
}
