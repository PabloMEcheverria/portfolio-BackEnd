package com.portfolio.SpringBoot.Security.Repository;

import com.portfolio.SpringBoot.Security.Entity.Role;
import com.portfolio.SpringBoot.Security.Enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
