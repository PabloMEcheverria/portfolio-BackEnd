package com.portfolio.SpringBoot.Entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String roleName;
    private String description;
    
    private String companyName;
    private String isTheCurrentJob;
    private Date startDate;
    private Date finishDate;
    private String imgUrl;

    public Experience() {
    }

    public Experience(String roleName, String description, String companyName, String isTheCurrentJob, Date startDate, Date finishDate, String imgUrl) {
        this.roleName = roleName;
        this.description = description;
        this.companyName = companyName;
        this.isTheCurrentJob = isTheCurrentJob;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.imgUrl = imgUrl;
    }    
}
