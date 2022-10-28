package com.portfolio.SpringBoot.DTO;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOPerson {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    
    @NotBlank
    private String address;
    @NotBlank
    private Date birthDate;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @NotBlank
    private String aboutMe;
    @NotBlank
    private String nationality;
    @NotBlank
    private String workPosition;
    @NotBlank
    private String geographicLocation;
    @NotBlank
    private String urlHeader;
    @NotBlank
    private String urlAvatar;

    public DTOPerson() {
    }

    public DTOPerson(String name, String lastName, String address, Date birthDate, String phoneNumber, String email, String aboutMe, String nationality, String workPosition, String geographicLocation, String urlHeader, String urlAvatar) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.aboutMe = aboutMe;
        this.nationality = nationality;
        this.workPosition = workPosition;
        this.geographicLocation = geographicLocation;
        this.urlHeader = urlHeader;
        this.urlAvatar = urlAvatar;
    }
}
