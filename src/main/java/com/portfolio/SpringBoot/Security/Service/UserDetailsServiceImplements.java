package com.portfolio.SpringBoot.Security.Service;

import com.portfolio.SpringBoot.Security.Entity.MainUser;
import com.portfolio.SpringBoot.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplements implements UserDetailsService{
    @Autowired
    UserService userServi;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userServi.getByUserName(userName).get();
        return MainUser.build(user);
    }
}
