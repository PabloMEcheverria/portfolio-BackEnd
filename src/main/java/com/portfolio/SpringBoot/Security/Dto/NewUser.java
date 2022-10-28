package com.portfolio.SpringBoot.Security.Dto;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewUser {
    private String name;
    private String userName;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();
}
