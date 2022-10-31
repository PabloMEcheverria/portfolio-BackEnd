/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Service;

import com.portfolio.SpringBoot.Entity.Proyect;
import com.portfolio.SpringBoot.Repository.IProyectRepository;
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
public class ProyectService {
    @Autowired
    IProyectRepository IProRepo;
    
    public List<Proyect> list() {
        return IProRepo.findAll();
    }
    
    public Optional<Proyect> getOne(int id) {
        return IProRepo.findById(id);
    }
    
    public Optional<Proyect> findByTitle(String title) {
        return IProRepo.findByTitle(title);
    }
    
    public void save(Proyect proyect) {
        IProRepo.save(proyect);
    }
    
    public void delete(int id) {
        IProRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return IProRepo.existsById(id);
    }
    
    public boolean existsByTitle(String title) {
        return IProRepo.existsByTitle(title);
    }
}
