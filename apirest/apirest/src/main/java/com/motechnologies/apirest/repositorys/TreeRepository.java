package com.motechnologies.apirest.repositorys;

import com.motechnologies.apirest.models.Tree;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree,Integer>{
    // public List<Tree> findAllTrees();
	
	public Optional<Tree> findById(Integer id);
	
	// public Tree saveTree(Tree tree);

}
