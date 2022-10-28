package com.portfolio.SpringBoot.Service;

import com.portfolio.SpringBoot.Entity.Person;
import com.portfolio.SpringBoot.Interface.IPersonService;
import com.portfolio.SpringBoot.Repository.IPersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonService implements IPersonService {
    
    @Autowired
    IPersonRepository IPersoRepo;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person = IPersoRepo.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        IPersoRepo.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        IPersoRepo.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = IPersoRepo.findById(id).orElse(null);
        return person;
    }
    
    @Override
    public boolean existsById(Long id) {
        return IPersoRepo.existsById(id);
    }
}
