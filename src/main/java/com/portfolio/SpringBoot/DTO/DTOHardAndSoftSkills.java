/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pablo Echeverria
 */
@Getter @Setter
public class DTOHardAndSoftSkills {
    @NotBlank
    private String title;
    @NotBlank
    private String type;
    
    private String description;
    @NotBlank
    private String percentage;
    @NotBlank
    private String ariaValuenow;

    public DTOHardAndSoftSkills() {
    }

    public DTOHardAndSoftSkills(String title, String type, String description, String percentage, String ariaValuenow) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.percentage = percentage;
        this.ariaValuenow = ariaValuenow;
    }
}
