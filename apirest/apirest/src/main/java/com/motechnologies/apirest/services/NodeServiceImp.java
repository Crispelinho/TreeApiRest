package com.motechnologies.apirest.services;

import java.util.List;

import com.motechnologies.apirest.models.Node;
import com.motechnologies.apirest.repositorys.NodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImp implements NodeService {
    
    @Autowired
    NodeRepository nodeRepository;

    @Override
	public List<Node> findAll() {
		List<Node> nodes = nodeRepository.findAll();
		return nodes;
	}
}