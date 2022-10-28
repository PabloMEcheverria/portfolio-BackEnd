package com.portfolio.SpringBoot.DTO;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOExperience {
    @NotBlank
    private String roleName;
    @NotBlank
    private String description;
    
    @NotBlank
    private String companyName;
    @NotBlank
    private String isTheCurrentJob;
    @NotBlank
    private Date startDate;
    @NotBlank
    private Date finishDate;
    
    private String imgUrl;

    public DTOExperience() {
    }

    public DTOExperience(String roleName, String description, String companyName, String isTheCurrentJob, Date startDate, Date finishDate, String imgUrl) {
        this.roleName = roleName;
        this.description = description;
        this.companyName = companyName;
        this.isTheCurrentJob = isTheCurrentJob;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.imgUrl = imgUrl;
    }
}
