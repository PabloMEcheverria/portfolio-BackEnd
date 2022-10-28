/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.SpringBoot.Entity;

import java.sql.Date;
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
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String educationalInstitution;
    private String urlImage;
    private String career;
    private String score;
    private Date startDate;
    private Date finishDate;

    public Education() {
    }

    public Education(String educationalInstitution, String title, String urlImage, String career, String score, Date startDate, Date finishDate) {
        this.title = title;
        this.educationalInstitution = educationalInstitution;
        this.urlImage = urlImage;
        this.career = career;
        this.score = score;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
