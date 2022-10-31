/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.SpringBoot.Repository;

import com.portfolio.SpringBoot.Entity.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pablo Echeverria
 */
@Repository
public interface IProyectRepository extends JpaRepository<Proyect, Integer>{
    public Optional<Proyect> findByTitle(String title);
    public boolean existsByTitle(String title);
}
