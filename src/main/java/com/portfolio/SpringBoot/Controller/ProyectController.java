/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Controller;

import com.portfolio.SpringBoot.DTO.DTOProyect;
import com.portfolio.SpringBoot.Entity.Proyect;
import com.portfolio.SpringBoot.Security.Controller.Message;
import com.portfolio.SpringBoot.Service.ProyectService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pablo Echeverria
 */
@RestController
@RequestMapping("/proyect")
@CrossOrigin(origins = "https://frontendportfolio-cfa02.web.app")
public class ProyectController {
    @Autowired
    ProyectService proyectService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyect>> list() {
        List<Proyect> list = proyectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyect> getById(@PathVariable("id") int id) {
        if(!proyectService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        
        Proyect proyect = proyectService.getOne(id).get();
        return new ResponseEntity(proyect, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!proyectService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.NOT_FOUND);
        }
        proyectService.delete(id);
        return new ResponseEntity(new Message("The proyect has been deleted."), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOProyect dtoProyect) {
        if(StringUtils.isBlank(dtoProyect.getTitle())) {
            return new ResponseEntity(new Message("The title is required."), HttpStatus.BAD_REQUEST);
        }
        if(proyectService.existsByTitle(dtoProyect.getTitle())) {
            return new ResponseEntity(new Message("That title already exists."), HttpStatus.BAD_REQUEST);
        }
        Proyect proyect = new Proyect(dtoProyect.getTitle(),
                                      dtoProyect.getDescription(), 
                                      dtoProyect.getUrl());
        proyectService.save(proyect);
        return new ResponseEntity(new Message("Added proyect."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DTOProyect dtoProyect) {
        if(!proyectService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.NOT_FOUND);
        }
        if(proyectService.existsByTitle(dtoProyect.getTitle()) && proyectService.findByTitle(dtoProyect.getTitle()).get().getId() != id) {
            return new ResponseEntity(new Message("That title already exists."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProyect.getTitle())) {
            return new ResponseEntity(new Message("The title is required."), HttpStatus.BAD_REQUEST);
        }
        
        Proyect proyect = proyectService.getOne(id).get();
        proyect.setTitle(dtoProyect.getTitle());
        proyect.setDescription(dtoProyect.getDescription());
        proyect.setUrl(dtoProyect.getUrl());
        
        proyectService.save(proyect);
        return new ResponseEntity(new Message("Updated proyect."), HttpStatus.OK);
    }
}
