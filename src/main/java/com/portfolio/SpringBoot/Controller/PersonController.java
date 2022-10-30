package com.portfolio.SpringBoot.Controller;

import com.portfolio.SpringBoot.DTO.DTOPerson;
import com.portfolio.SpringBoot.Entity.Person;
import com.portfolio.SpringBoot.Interface.IPersonService;
import com.portfolio.SpringBoot.Security.Controller.Message;
import java.sql.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontendportfolio-cfa02.web.app")
public class PersonController {
    
    @Autowired
    IPersonService IPersoServi;
    
    @GetMapping("/person/get")
    public List<Person> getPerson() {
        return IPersoServi.getPerson();
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/person/create")
    public String createPerson(@RequestBody Person person) {
        IPersoServi.savePerson(person);
        return "A new person has been successfully created.";
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        IPersoServi.deletePerson(id);
        return "A person has been successfully deleted.";
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/person/edit/{id}")
    public Person editPerson (@PathVariable Long id,
                              @RequestParam("name") String newName,
                              @RequestParam("lastName") String newLastName,
                              
                              @RequestParam("address") String newAddress,
                              @RequestParam("birthDate") Date newBirthDate,
                              @RequestParam("phoneNumber") String newPhoneNumber,
                              @RequestParam("email") String newEmail,
                              @RequestParam("aboutMe") String newAboutMe,
                              @RequestParam("nationality") String newNationality,
                              @RequestParam("workPosition") String newWorkPosition,
                              @RequestParam("geographicLocation") String newGeographicLocation,
                              @RequestParam("urlHeader") String newUrlHeader,
                              @RequestParam("urlAvatar") String newUrlAvatar) {
        Person person = IPersoServi.findPerson(id);
        
        person.setName(newName);
        person.setLastName(newLastName);
        
        person.setAddress(newAddress);
        person.setBirthDate(newBirthDate);
        person.setPhoneNumber(newPhoneNumber);
        person.setEmail(newEmail);
        person.setAboutMe(newAboutMe);
        person.setNationality(newNationality);
        person.setWorkPosition(newWorkPosition);
        person.setGeographicLocation(newGeographicLocation);
        person.setUrlHeader(newUrlHeader);
        person.setUrlAvatar(newUrlAvatar);
        
        
        IPersoServi.savePerson(person);
        return person;
    }
    
    @PutMapping("/person/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DTOPerson dtoPerson){
        if(!IPersoServi.existsById(id)) {
            return new ResponseEntity(new Message("The id doesn't exist."), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPerson.getName())) {
            return new ResponseEntity(new Message("The role name is required."), HttpStatus.BAD_REQUEST);
        }
        
        Person person = IPersoServi.findPerson(id);
        person.setName(dtoPerson.getName());
        person.setLastName(dtoPerson.getLastName());
        person.setAddress(dtoPerson.getAddress());
        person.setBirthDate(dtoPerson.getBirthDate());
        person.setPhoneNumber(dtoPerson.getPhoneNumber());
        person.setEmail(dtoPerson.getEmail());
        person.setAboutMe(dtoPerson.getAboutMe());
        person.setNationality(dtoPerson.getNationality());
        person.setWorkPosition(dtoPerson.getWorkPosition());
        person.setGeographicLocation(dtoPerson.getGeographicLocation());
        person.setUrlHeader(dtoPerson.getUrlHeader());
        person.setUrlAvatar(dtoPerson.getUrlAvatar());
        
        IPersoServi.savePerson(person);
        
        return new ResponseEntity(new Message("Updated person."), HttpStatus.OK);
    }
    
    @GetMapping("/person/get/profile")
    public Person getPersonProfile() {
        return IPersoServi.findPerson((long)1); //Since this app was thought to have only one person (with id = 1), this function gets that particular person.
    }
}
