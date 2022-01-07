package com.motechnologies.apirest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motechnologies.apirest.models.Node;
import com.motechnologies.apirest.models.Tree;
import com.motechnologies.apirest.repositorys.NodeRepository;
import com.motechnologies.apirest.repositorys.TreeRepository;

@Service
public class TreeServiceImp implements TreeService {

    @Autowired
	private TreeRepository treeRepository;

	@Autowired
	private NodeRepository nodeRepository;
	
	public TreeServiceImp(TreeRepository treeRepository) {
		this.treeRepository = treeRepository;
	}
	
	private Tree tree = new Tree();
 
	public Tree createTree(Tree tree) {

		Node root = tree.getNodes().get(0);
		this.tree.setNodes(new ArrayList<Node>());
		this.tree.getNodes().add(root);

		int cont = 0;
		for (Node node : tree.getNodes()) {
			if (cont != 0)
				insertNode(node);
			cont++;
		}

		walktree(root);
		System.out.println("*************************************");
		System.out.println("*************************************");
		System.out.println("*************************************");
		//walktree(this.tree.getNodes().get(0));
		return tree;

	}


    
	public void insertNode(Node node) {
		System.out.println("----------------------------");
		Node aux = this.tree.getNodes().get(0);
		System.out.println("aux:" + aux.getKey());
		System.out.println("node:" + node.getKey());
		int cont = 0;
		while (aux != null) {
			node.setParent(aux);
			System.out.println("parent:" + node.getParent().getKey());
			if (node.getKey() >= aux.getKey()) {
				aux = aux.getRightNode();
				System.out.println("Derecha");
			} else {
				aux = aux.getLeftNode();
				System.out.println("Izquierda");
			}
			if (cont != 0)
				this.tree.getNodes().add(cont, aux);
			System.out.println(cont + ":" + aux);
		}

		if (node.getKey() < node.getParent().getKey()) {
			node.getParent().setLeftNode(node);
			node.getParent().setLeftKey(node.getKey());
		} else
			node.getParent().setRightNode(node);
			node.getParent().setRightKey(node.getKey());
		System.out.println("----------------------------");
	}

     
    
	public void walktree(Node n) {
		System.out.println("----------WALKTREE-------------");
		System.out.println("Recorriendo:" + n);
		if (n != null) {
			walktree(n.getLeftNode());
			System.out.println("node:" + n.getKey());
			if (n.getParent() != null)
				System.out.println("nodeParent: " + n.getParent().getKey());
			walktree(n.getRightNode());
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++-");
	}

     
	@Override
	public Tree save(Tree tree) {
		if (tree != null) {
			Tree tree1 = createTree(tree);
			System.out.println("tree:" + tree1.getId());
			System.out.println("tree: node:"+ tree1.getNodes().get(1).getKey()+" parent:"+ tree1.getNodes().get(1).getParent().getKey());
			treeRepository.save(tree1);
			for (Node node : tree1.getNodes()) {
				//node.setTree(tree1);
				//nodeRepository.save(node);
				System.out.println("Node"+node.getKey());
				if(node.getParent()!=null)
					System.out.println("Parent:"+node.getParent().getKey());
			}
			return tree;
		}
		return new Tree();
	}

 	@Override
	public Optional<Tree> findById(Integer id) {

		Optional<Tree> tree = treeRepository.findById(id);
		return tree;
	} 

	@Override
	public List<Tree> findAll() {
		List<Tree> tree = treeRepository.findAll();
		return tree;
	}



	@Override
	public Node searchLowestCommonAncestor(Integer idTree, Integer nodeKey1, Integer nodeKey2) {
		System.out.println("idTree:"+idTree);
		Optional<Tree> optionalTree = this.treeRepository.findById(idTree);
		if (optionalTree.isPresent()) {
			Tree tree = optionalTree.get();
			this.tree = tree;
			System.out.println("tree:"+tree.getId());
			Node root = tree.getNodes().get(0);
			Node p = searchNodeInTreeById(nodeKey1);
			Node q = searchNodeInTreeById(nodeKey2);
			
			return lowestCommonAncestor(root, p, q);
		}	
		return new Node();
	}

	public Node lowestCommonAncestor(Node root, Node p, Node q){
		System.out.println("-----------------------------------------");
		System.out.println(root+":"+p+":"+q);
		if(root != null) 
		{
			System.out.println(root.getKey()+":"+p.getKey()+":"+q.getKey());
			if(root.getKey()==p.getKey() || root.getKey()==q.getKey()){
				return root;
			  }
	  
			  Node leftTree=lowestCommonAncestor(searchNodeInTreeById(root.getLeftKey()),p,q);
			  Node rightTree=lowestCommonAncestor(searchNodeInTreeById(root.getRightKey()),p,q);
	  
			  if(leftTree!=null && rightTree!=null){
				  return root;
			  }
	  
			  if(leftTree !=null){
				  return leftTree;
			  }
	  
			  if(rightTree !=null){
				  return rightTree;
			  }
		}
		
		  return null;
	}

	public Node searchNodeInTreeById(Integer nodeKey){
		for (Node node : this.tree.getNodes()) {
			if(node.getKey() == nodeKey) return node;
		}
		return null;
	}

}
