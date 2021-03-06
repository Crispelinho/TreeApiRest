package com.motechnologies.apirest.controllers;

import java.util.List;
import java.util.Optional;

import com.motechnologies.apirest.models.Node;
import com.motechnologies.apirest.models.Tree;
import com.motechnologies.apirest.services.TreeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreeController {
    @Autowired
    private TreeService treeService;
	
    public TreeController(TreeService treeService) {
		this.treeService = treeService;
	}

	@PostMapping("tree/")
    public Tree postTree(@RequestBody Tree tree) {
        
		return this.treeService.save(tree);
    }
	
	@GetMapping("tree/{id}")
    public Optional<Tree> getTree(@PathVariable Integer id) {
        System.out.println("Entró al get");
		return this.treeService.findById(id);
    }

    @GetMapping("tree")
    public List<Tree> getAllTree() {
        System.out.println("Entro getAllTree");
		return this.treeService.findAll();
    }

    @PostMapping("tree/lowestCommonAncestor/")
    public Node lowestCommonAncestor(@RequestParam(value = "id") Integer id, @RequestParam(value = "key1") Integer key1, @RequestParam(value = "key2") Integer key2 ) {
        System.out.println("Entro LowestCommonAncestor");
        Node node = this.treeService.searchLowestCommonAncestor(id,key1,key2);
        if (node!=null) System.out.println(node.getKey());
		    return node;
    }

    
}
