package com.portfolio.SpringBoot.Security.Service;

import com.portfolio.SpringBoot.Security.Entity.User;
import com.portfolio.SpringBoot.Security.Repository.InterfaceUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    InterfaceUserRepository interUserRepo;
    
    public Optional<User> getByUserName(String userName) {
        return interUserRepo.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName) {
        return interUserRepo.existsByUserName(userName);
    }
    
    public boolean existsByEmail(String email) {
        return interUserRepo.existsByEmail(email);
    }
    
    public void save(User user) {
        interUserRepo.save(user);
    }
}
