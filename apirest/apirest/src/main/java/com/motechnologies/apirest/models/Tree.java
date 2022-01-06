package com.motechnologies.apirest.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TREES")
public class Tree {
	@Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id; 
    
	@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tree",fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Node> nodes;
    
    public Tree() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "Tree [id=" + id + ", nodes=" + nodes + "]";
	}
}
