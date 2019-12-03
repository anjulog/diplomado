package com.uniajc.diplomado.services.document.service;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.service
 * Shaft
 *  *
 * the name of the current project
 */

import com.uniajc.diplomado.services.document.entity.Document;
import com.uniajc.diplomado.services.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DocumentService
{
    @Autowired
    DocumentRepository documentRepository;

    public List<Document> getAll (){
        List<Document> lista = documentRepository.findAll ();
        return lista;
    }

    public Optional<Document> getById (Long id){
        return documentRepository.findById (id);
    }

    public Optional<Document> getByName (String np){
        return documentRepository.findByNameDocument (np);
    }

    public void storage (Document Document){
        documentRepository.save (Document);
    }

    public void delete (Long id){
        documentRepository.deleteById (id);
    }

    public boolean existByName (String np){
        return documentRepository.existsByNameDocument (    np);
    }

    public boolean existById (Long id){
        return documentRepository.existsById (id);
    }
}
