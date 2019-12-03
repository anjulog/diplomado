package com.uniajc.diplomado.services.document.controller;

import com.uniajc.diplomado.services.document.dto.Message;
import com.uniajc.diplomado.services.document.entity.Document;
import com.uniajc.diplomado.services.document.service.DocumentService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.controller
 * Shaft
 *  *
 * the name of the current project
 */


@RestController
@CrossOrigin (origins = "*")
public class DocumentController
{
    private static final Logger LOGGER = LoggerFactory.getLogger (DocumentController.class);
    @Autowired
    DocumentService documentService;

    @GetMapping ("/")
    public List<Document> findAll () {
        LOGGER.info("Organization find");
        return documentService.getAll ();
    }
    @GetMapping ("/list")
    public ResponseEntity<List<Document>> getLista (){
        List<Document> lista = documentService.getAll ();
        return new ResponseEntity<List<Document>>(lista, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Document> getOne (@PathVariable Long id){
        if(!documentService.existById (id))
            return new ResponseEntity(new Message("no existe ese Document"), HttpStatus.NOT_FOUND);
        Document Document = documentService.getById (id).get ();
        return new ResponseEntity<Document>(Document, HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<?> create (@RequestBody Document Document){
        if( StringUtils.isBlank (Document.getNameDocument ()))
            return new ResponseEntity(new Message("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((String) Document.getDescription () == null || Document.getDescription ().isEmpty ())
            return new ResponseEntity(new Message("La description es obligatorio"), HttpStatus.BAD_REQUEST);
        if( documentService.existByName (Document.getNameDocument ()))
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        documentService.storage (Document);
        return new ResponseEntity(new Message("Document guardado"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@RequestBody Document document, @PathVariable("id") Long id){
        if(!documentService.existById (id))
            return new ResponseEntity(new Message ("no existe ese Document"), HttpStatus.NOT_FOUND);
        if( StringUtils.isBlank (document.getNameDocument ()))
            return new ResponseEntity(new Message("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((String) document.getDescription () == null || document.getDescription ().isEmpty ())
            return new ResponseEntity(new Message("La description es obligatorio"), HttpStatus.BAD_REQUEST);
        if( documentService.existByName (document.getNameDocument ()) &&
                documentService.getByName (document.getNameDocument ()).get ().getId () != id)
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Document prodUpdate = documentService.getById (id).get ();
        prodUpdate.setNameDocument (document.getNameDocument ());
        prodUpdate.setDescription (document.getDescription ());
        documentService.storage (prodUpdate);
        return new ResponseEntity(new Message("Document actualizado"), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!documentService.existById (id))
            return new ResponseEntity(new Message("no existe ese Document"), HttpStatus.NOT_FOUND);
        documentService.delete (id);
        return new ResponseEntity(new Message("Document eliminado"), HttpStatus.OK);
    }

}
