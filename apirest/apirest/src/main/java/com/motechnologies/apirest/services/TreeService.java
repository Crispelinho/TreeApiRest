package com.motechnologies.apirest.services;

import java.util.Optional;
import com.motechnologies.apirest.models.Tree;

public interface TreeService {
    public Tree save(Tree tree);

	public Optional<Tree> findById(Integer id);	   
}
