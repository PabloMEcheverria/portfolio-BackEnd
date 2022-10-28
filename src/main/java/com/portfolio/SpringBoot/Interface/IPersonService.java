package com.portfolio.SpringBoot.Interface;

import com.portfolio.SpringBoot.Entity.Person;
import java.util.List;

public interface IPersonService {
    
    public List<Person> getPerson();
    
    public void savePerson(Person person);
    
    public void deletePerson(Long id);
    
    public Person findPerson(Long id);
    
    public boolean existsById(Long id);
}
