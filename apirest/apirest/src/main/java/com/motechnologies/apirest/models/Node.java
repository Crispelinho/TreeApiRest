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

@Entity
@Table(name = "NODES")
public class Node {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "key")
    private Integer key;
    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName="ID",nullable = true)
    private Node parent;
    @OneToOne(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "left", referencedColumnName="ID", nullable = true)
    private Node left;
    @OneToOne(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "right", referencedColumnName="ID", nullable = true)
    private Node right;
    @Column(name = "isRoot", nullable = true)
    private Boolean isRoot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tree_id")
    private Tree tree;
    @Column(name = "content")
    private String content;

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
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
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
}
