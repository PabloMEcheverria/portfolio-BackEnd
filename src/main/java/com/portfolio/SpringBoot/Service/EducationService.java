/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Service;

import com.portfolio.SpringBoot.Entity.Education;
import com.portfolio.SpringBoot.Repository.IEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pablo Echeverria
 */
@Service
@Transactional
public class EducationService {
    @Autowired
    IEducationRepository IEduRepo;
    
    public List<Education> list() {
        return IEduRepo.findAll();
    }
    
    public Optional<Education> getOne(int id) {
        return IEduRepo.findById(id);
    }
    
    public Optional<Education> findByTitle(String title) {
        return IEduRepo.findByTitle(title);
    }
    
    public void save(Education education) {
        IEduRepo.save(education);
    }
    
    public void delete(int id) {
        IEduRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return IEduRepo.existsById(id);
    }
    
    public boolean existsByTitle(String title) {
        return IEduRepo.existsByTitle(title);
    }
}
