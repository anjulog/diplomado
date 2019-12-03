package com.uniajc.diplomado.services.company.controller;

import com.uniajc.diplomado.services.company.dto.Message;
import com.uniajc.diplomado.services.company.entity.Company;
import com.uniajc.diplomado.services.company.service.CompanyService;
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
public class CompanyController
{
    private static final Logger LOGGER = LoggerFactory.getLogger (CompanyController.class);
    @Autowired
    CompanyService companyService;

    @GetMapping ("/")
    public List<Company> findAll() {
        LOGGER.info("Organization find");
        return companyService.getAll();
    }
    @GetMapping ("/list")
    public ResponseEntity<List<Company>> getLista (){
        List<Company> lista = companyService.getAll ();
        return new ResponseEntity<List<Company>>(lista, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Company> getOne (@PathVariable Long id){
        if(!companyService.existById (id))
            return new ResponseEntity(new Message("no existe ese Company"), HttpStatus.NOT_FOUND);
        Company Company = companyService.getById (id).get ();
        return new ResponseEntity<Company>(Company, HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<?> create(@RequestBody Company Company){
        if( StringUtils.isBlank (Company.getNameCompany ()))
            return new ResponseEntity(new Message("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((String)Company.getDescription () == null || Company.getDescription().isEmpty ())
            return new ResponseEntity(new Message("La description es obligatorio"), HttpStatus.BAD_REQUEST);
        if( companyService.existByName (Company.getNameCompany ()))
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        companyService.storage (Company);
        return new ResponseEntity(new Message("Company guardado"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@RequestBody Company Company, @PathVariable("id") Long id){
        if(!companyService.existById (id))
            return new ResponseEntity(new Message ("no existe ese Company"), HttpStatus.NOT_FOUND);
        if( StringUtils.isBlank (Company.getNameCompany ()))
            return new ResponseEntity(new Message("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((String)Company.getDescription() == null || Company.getDescription().isEmpty ())
            return new ResponseEntity(new Message("La description es obligatorio"), HttpStatus.BAD_REQUEST);
        if( companyService.existByName (Company.getNameCompany ()) &&
                companyService.getByName (Company.getNameCompany ()).get ().getId () != id)
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Company prodUpdate = companyService.getById (id).get ();
        prodUpdate.setNameCompany (Company.getNameCompany());
        prodUpdate.setDescription (Company.getDescription());
        companyService.storage (prodUpdate);
        return new ResponseEntity(new Message("Company actualizado"), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!companyService.existById (id))
            return new ResponseEntity(new Message("no existe ese Company"), HttpStatus.NOT_FOUND);
        companyService.delete (id);
        return new ResponseEntity(new Message("Company eliminado"), HttpStatus.OK);
    }

}
