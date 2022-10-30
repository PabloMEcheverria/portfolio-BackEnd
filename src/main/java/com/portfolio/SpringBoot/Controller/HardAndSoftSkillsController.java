/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Controller;

import com.portfolio.SpringBoot.DTO.DTOHardAndSoftSkills;
import com.portfolio.SpringBoot.Entity.HardAndSoftSkills;
import com.portfolio.SpringBoot.Security.Controller.Message;
import com.portfolio.SpringBoot.Service.HardAndSoftSkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "https://frontendportfolio-cfa02.web.app")
public class HardAndSoftSkillsController {
    @Autowired
    HardAndSoftSkillsService skillsService;
    
    @GetMapping("/list")
    public ResponseEntity<List<HardAndSoftSkills>> list() {
        List<HardAndSoftSkills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardAndSoftSkills> getById(@PathVariable("id") int id) {
        if(!skillsService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        
        HardAndSoftSkills education = skillsService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!skillsService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.NOT_FOUND);
        }
        skillsService.delete(id);
        return new ResponseEntity(new Message("The skill has been deleted."), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOHardAndSoftSkills dtoSkills) {
        if(StringUtils.isBlank(dtoSkills.getTitle())) {
            return new ResponseEntity(new Message("The title is required."), HttpStatus.BAD_REQUEST);
        }
        if(skillsService.existsByTitle(dtoSkills.getTitle())) {
            return new ResponseEntity(new Message("That title already exists."), HttpStatus.BAD_REQUEST);
        }
        HardAndSoftSkills skill = new HardAndSoftSkills(
                                            dtoSkills.getTitle(),
                                            dtoSkills.getType(), 
                                            dtoSkills.getDescription(), 
                                            dtoSkills.getPercentage(), 
                                            dtoSkills.getAriaValuenow());
        skillsService.save(skill);
        return new ResponseEntity(new Message("Added skill."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DTOHardAndSoftSkills dtoSkills) {
        if(!skillsService.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.NOT_FOUND);
        }
        if(skillsService.existsByTitle(dtoSkills.getTitle()) && skillsService.findByTitle(dtoSkills.getTitle()).get().getId() != id) {
            return new ResponseEntity(new Message("That title already exists."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkills.getTitle())) {
            return new ResponseEntity(new Message("The title is required."), HttpStatus.BAD_REQUEST);
        }
        
        HardAndSoftSkills skill = skillsService.getOne(id).get();
        skill.setTitle(dtoSkills.getTitle());
        skill.setType(dtoSkills.getType());
        skill.setDescription(dtoSkills.getDescription());
        skill.setPercentage(dtoSkills.getPercentage());
        skill.setAriaValuenow(dtoSkills.getAriaValuenow());
        
        skillsService.save(skill);
        return new ResponseEntity(new Message("Updated skill."), HttpStatus.OK);
    }
}
