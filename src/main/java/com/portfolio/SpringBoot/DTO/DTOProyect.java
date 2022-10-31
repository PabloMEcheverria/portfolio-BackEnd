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
public class DTOProyect {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String url;

    public DTOProyect() {
    }

    public DTOProyect(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }
}
