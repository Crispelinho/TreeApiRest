package com.motechnologies.apirest.repositorys;

import com.motechnologies.apirest.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node,Integer>{
    
}
