package com.motechnologies.apirest.controllers;

import java.util.List;

import com.motechnologies.apirest.models.Node;
import com.motechnologies.apirest.services.NodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController {

    @Autowired
    NodeService nodeService;

    @GetMapping("node")
    public List<Node> getAllNode() {
        System.out.println("Entro getAllNode");
		return this.nodeService.findAll();
    }
}
