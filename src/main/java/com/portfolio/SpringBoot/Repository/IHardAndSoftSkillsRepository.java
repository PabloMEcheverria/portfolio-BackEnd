/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.SpringBoot.Repository;

import com.portfolio.SpringBoot.Entity.HardAndSoftSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pablo Echeverria
 */
@Repository
public interface IHardAndSoftSkillsRepository extends JpaRepository<HardAndSoftSkills, Integer> {
    public Optional<HardAndSoftSkills> findByTitle(String title);
    public boolean existsByTitle(String title);
}
