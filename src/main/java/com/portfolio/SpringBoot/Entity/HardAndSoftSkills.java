/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pablo Echeverria
 */
@Getter @Setter
@Entity
public class HardAndSoftSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String title;
    private String type;
    private String description;
    private String percentage;
    private String ariaValuenow;

    public HardAndSoftSkills() {
    }

    public HardAndSoftSkills(String title, String type, String description, String percentage, String ariaValuenow) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.percentage = percentage;
        this.ariaValuenow = ariaValuenow;
    }
}
