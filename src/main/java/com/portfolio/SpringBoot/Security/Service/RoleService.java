package com.portfolio.SpringBoot.Security.Service;

import com.portfolio.SpringBoot.Security.Entity.Role;
import com.portfolio.SpringBoot.Security.Enums.RoleName;
import com.portfolio.SpringBoot.Security.Repository.InterfaceRoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired
    InterfaceRoleRepository intRoleRepo;
    
    public Optional<Role> getByRoleName(RoleName roleName){
        return intRoleRepo.findByRoleName(roleName);
    }
    
    public void save(Role role) {
        intRoleRepo.save(role);
    }
}
