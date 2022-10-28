/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Service;

import com.portfolio.SpringBoot.Entity.HardAndSoftSkills;
import com.portfolio.SpringBoot.Repository.IHardAndSoftSkillsRepository;
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
public class HardAndSoftSkillsService {
    @Autowired
    IHardAndSoftSkillsRepository skillsRepo;
    
     public List<HardAndSoftSkills> list() {
        return skillsRepo.findAll();
    }
    
    public Optional<HardAndSoftSkills> getOne(int id) {
        return skillsRepo.findById(id);
    }
    
    public Optional<HardAndSoftSkills> findByTitle(String title) {
        return skillsRepo.findByTitle(title);
    }
    
    public void save(HardAndSoftSkills skills) {
        skillsRepo.save(skills);
    }
    
    public void delete(int id) {
        skillsRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return skillsRepo.existsById(id);
    }
    
    public boolean existsByTitle(String title) {
        return skillsRepo.existsByTitle(title);
    }
}
