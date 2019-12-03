package com.uniajc.diplomado.services.document.repository;

import com.uniajc.diplomado.services.document.entity.Document;
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
public interface DocumentRepository extends JpaRepository<Document, Long>
{
    Optional<Document> findByNameDocument (String np);

    boolean existsByNameDocument (String np);
}
