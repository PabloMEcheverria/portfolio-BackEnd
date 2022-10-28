/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Controller;

import com.portfolio.SpringBoot.DTO.DTOEducation;
import com.portfolio.SpringBoot.Entity.Education;
import com.portfolio.SpringBoot.Security.Controller.Message;
import com.portfolio.SpringBoot.Service.EducationService;
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
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    @Autowired
    EducationService educationService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = educationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if(!educationService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!educationService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.NOT_FOUND);
        }
        educationService.delete(id);
        return new ResponseEntity(new Message("The education has been deleted."), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOEducation dtoEducation) {
        if(StringUtils.isBlank(dtoEducation.getTitle())) {
            return new ResponseEntity(new Message("The title is required."), HttpStatus.BAD_REQUEST);
        }
        if(educationService.existsByTitle(dtoEducation.getTitle())) {
            return new ResponseEntity(new Message("That title already exists."), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(dtoEducation.getTitle(),
                                            dtoEducation.getEducationalInstitution(), 
                                            dtoEducation.getUrlImage(), 
                                            dtoEducation.getCareer(), 
                                            dtoEducation.getScore(), 
                                            dtoEducation.getStartDate(), 
                                            dtoEducation.getFinishDate());
        educationService.save(education);
        return new ResponseEntity(new Message("Added education."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DTOEducation dtoEducation) {
        if(!educationService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.NOT_FOUND);
        }
        if(educationService.existsByTitle(dtoEducation.getTitle()) && educationService.findByTitle(dtoEducation.getTitle()).get().getId() != id) {
            return new ResponseEntity(new Message("That title already exists."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEducation.getTitle())) {
            return new ResponseEntity(new Message("The title is required."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = educationService.getOne(id).get();
        education.setTitle(dtoEducation.getTitle());
        education.setEducationalInstitution(dtoEducation.getEducationalInstitution());
        education.setUrlImage(dtoEducation.getUrlImage());
        education.setCareer(dtoEducation.getCareer());
        education.setScore(dtoEducation.getScore());
        education.setStartDate(dtoEducation.getStartDate());
        education.setFinishDate(dtoEducation.getFinishDate());
        
        educationService.save(education);
        return new ResponseEntity(new Message("Updated education."), HttpStatus.OK);
    }
}
