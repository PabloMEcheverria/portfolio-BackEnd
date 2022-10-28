package com.portfolio.SpringBoot.Service;

import com.portfolio.SpringBoot.Entity.Experience;
import com.portfolio.SpringBoot.Repository.IExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {
    @Autowired
    IExperienceRepository iExpRepo;
    
    public List<Experience> list() {
        return iExpRepo.findAll();
    }
    
    public Optional<Experience> getOne(int id) {
        return iExpRepo.findById(id);
    }
    
    public Optional<Experience> getByRoleName(String roleName) {
        return iExpRepo.findByRoleName(roleName);
    }
    
    public void save(Experience experience) {
        iExpRepo.save(experience);
    }
    
    public void delete(int id) {
        iExpRepo.deleteById(id);
    }
    
    public boolean existById(int id) {
        return iExpRepo.existsById(id);
    }
    
    public boolean existByRoleName(String roleName) {
        return iExpRepo.existsByRoleName(roleName); 
    }
}
