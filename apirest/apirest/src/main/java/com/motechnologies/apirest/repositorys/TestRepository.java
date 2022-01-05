package com.motechnologies.apirest.repositorys;

import com.motechnologies.apirest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<User,Integer>{
    
}
