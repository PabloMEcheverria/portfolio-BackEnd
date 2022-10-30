package com.portfolio.SpringBoot.Controller;

import com.portfolio.SpringBoot.DTO.DTOExperience;
import com.portfolio.SpringBoot.Entity.Experience;
import com.portfolio.SpringBoot.Security.Controller.Message;
import com.portfolio.SpringBoot.Service.ExperienceService;
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

@RestController
@RequestMapping("/workexp")
@CrossOrigin(origins = "https://frontendportfolio-cfa02.web.app")
public class ExperienceController {
    @Autowired
    ExperienceService expService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id) {
        if(!expService.existById(id)) {
            return new ResponseEntity(new Message("That work experience doesn't exist"), HttpStatus.NOT_FOUND);
        }
        Experience exp = expService.getOne(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOExperience dtoExp) {
        if(StringUtils.isBlank(dtoExp.getRoleName())) {
            return new ResponseEntity(new Message("The role name is required."), HttpStatus.BAD_REQUEST);
        }
        if(expService.existByRoleName(dtoExp.getRoleName())) {
            return new ResponseEntity(new Message("That work experience already exists."), HttpStatus.BAD_REQUEST);
        }
        
        Experience exp = new Experience(dtoExp.getRoleName(), 
                                        dtoExp.getDescription(), 
                                        dtoExp.getCompanyName(), 
                                        dtoExp.getIsTheCurrentJob(), 
                                        dtoExp.getStartDate(), 
                                        dtoExp.getFinishDate(), 
                                        dtoExp.getImgUrl());
        expService.save(exp);
        
        return new ResponseEntity(new Message("Added experience."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DTOExperience dtoExp) {
        if(!expService.existById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        if(expService.existByRoleName(dtoExp.getRoleName()) && expService.getByRoleName(dtoExp.getRoleName()).get().getId() != id) {
            return new ResponseEntity(new Message("That work experience already exist."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExp.getRoleName())) {
            return new ResponseEntity(new Message("The role name is required."), HttpStatus.BAD_REQUEST);
        }
        
        Experience exp = expService.getOne(id).get();
        exp.setRoleName(dtoExp.getRoleName());
        exp.setDescription(dtoExp.getDescription());
        exp.setCompanyName(dtoExp.getCompanyName());
        exp.setIsTheCurrentJob(dtoExp.getIsTheCurrentJob());
        exp.setStartDate(dtoExp.getStartDate());
        exp.setFinishDate(dtoExp.getFinishDate());
        exp.setImgUrl(dtoExp.getImgUrl());
        
        expService.save(exp);
        
        return new ResponseEntity(new Message("Updated experience."), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!expService.existById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        expService.delete(id);
        return new ResponseEntity(new Message("The experience has been deleted."), HttpStatus.OK);
    }
}
