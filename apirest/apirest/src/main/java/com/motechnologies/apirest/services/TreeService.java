package com.motechnologies.apirest.services;

import java.util.Optional;
import java.util.List;

import com.motechnologies.apirest.models.Tree;

public interface TreeService {
    public Tree save(Tree tree);

	public Optional<Tree> findById(Integer id);	  
    
    public List<Tree> findAll();

    public void LowestCommonAncestor(Integer id, Integer key1, Integer key2);

}
