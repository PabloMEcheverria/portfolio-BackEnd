package com.portfolio.SpringBoot.Security.Controller;

import com.portfolio.SpringBoot.Security.Entity.Role;
import com.portfolio.SpringBoot.Security.Entity.User;
import com.portfolio.SpringBoot.Security.Enums.RoleName;
import com.portfolio.SpringBoot.Security.Jwt.JwtProvider;
import com.portfolio.SpringBoot.Security.Service.RoleService;
import com.portfolio.SpringBoot.Security.Service.UserService;
import com.portfolio.SpringBoot.Security.Dto.JwtDto;
import com.portfolio.SpringBoot.Security.Dto.LoginUser;
import com.portfolio.SpringBoot.Security.Dto.NewUser;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/new")
    public ResponseEntity<?> New(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("The fields are incorrect or the email is invalid."), HttpStatus.BAD_REQUEST);
        }
        
        if(userService.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity(new Message("That username already exists."), HttpStatus.BAD_REQUEST);
        }
        
        if(userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new Message("That email already exists."), HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(newUser.getName(), newUser.getUserName(), 
                newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.USER).get());
        
        if(newUser.getRoles().contains("admin")) {
            roles.add(roleService.getByRoleName(RoleName.ADMIN).get());
        }
        
        user.setRoles(roles);
        userService.save(user);
        
        return new ResponseEntity(new Message("Saved user."), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Invalid fields"), HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
