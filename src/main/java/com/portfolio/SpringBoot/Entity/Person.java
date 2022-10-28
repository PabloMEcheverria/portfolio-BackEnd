package com.portfolio.SpringBoot.Entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Does not meet length requirements.")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Does not meet length requirements.")
    private String lastName;
    
    
      
    @NotNull
    @Size(min = 1, max = 140, message = "Does not meet length requirements.")
    private String address;
    
    @NotNull
    private Date birthDate;
    
    @NotNull
    @Size(min = 1, max = 25, message = "Does not meet length requirements.")
    private String phoneNumber;
    
    @NotNull
    @Size(min = 1, max = 100, message = "Does not meet length requirements.")
    private String email;
    
    @NotNull
    @Size(min = 1, max = 300, message = "Does not meet length requirements.")
    private String aboutMe;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Does not meet length requirements.")
    private String nationality;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Does not meet length requirements.")
    private String workPosition;
    
    @NotNull
    @Size(min = 1, max = 140, message = "Does not meet length requirements.")
    private String geographicLocation;
    
    @NotNull
    @Size(min = 1, max = 400, message = "Does not meet length requirements.")
    private String urlHeader;
    
    @NotNull
    @Size(min = 1, max = 400, message = "Does not meet length requirements.")
    private String urlAvatar;
}
