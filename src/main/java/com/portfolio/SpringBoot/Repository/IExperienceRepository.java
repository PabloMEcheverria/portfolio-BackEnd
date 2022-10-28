package com.portfolio.SpringBoot.Repository;

import com.portfolio.SpringBoot.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByRoleName(String roleName);
    public boolean existsByRoleName(String roleName);
}
