/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.DTO;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pablo Echeverria
 */
@Getter @Setter
public class DTOEducation {
    @NotBlank
    private String title;
    @NotBlank
    private String educationalInstitution;
    
    
    private String urlImage;
    @NotBlank
    private String career;
    
    
    private String score;
    @NotBlank
    private Date startDate;
    @NotBlank
    private Date finishDate;

    public DTOEducation() {
    }

    public DTOEducation(String educationalInstitution, String title, String urlImage, String career, String score, Date startDate, Date finishDate) {
        this.title = title;
        this.educationalInstitution = educationalInstitution;
        this.urlImage = urlImage;
        this.career = career;
        this.score = score;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
