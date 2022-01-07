package com.motechnologies.apirest.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "NODES")

public class Node {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "key")
    private Integer key;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent", referencedColumnName="ID",nullable = true)
    private Node parent;
	@Transient
	@JsonIgnore
    // @OneToOne(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "leftNode", referencedColumnName="ID", nullable = true)
    private Node leftNode;
	@Transient
	@JsonIgnore
    // @OneToOne(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "rightNode", referencedColumnName="ID", nullable = true)
    private Node rightNode;
    @Column(name = "isRoot", nullable = true)
    private Boolean isRoot;
	@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tree_id", nullable = true)
    private Tree tree;
    @Column(name = "content")
    private String content;

    @Column(name = "leftKey")
    private Integer leftKey;

	@Column(name = "rightKey")
    private Integer rightKey;	

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public Boolean getIsRoot() {
		return isRoot;
	}
	public void setIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
	}
	public Tree getTree() {
		return tree;
	}
	public void setTree(Tree tree) {
		this.tree = tree;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getLeftKey() {
		return leftKey;
	}

	public void setLeftKey(Integer leftKey) {
		this.leftKey = leftKey;
	}

	public Integer getRightKey() {
		return rightKey;
	}

	public void setRightKey(Integer rightKey) {
		this.rightKey = rightKey;
	}
	
}
