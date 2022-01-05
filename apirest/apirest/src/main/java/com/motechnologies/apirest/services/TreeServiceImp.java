package com.motechnologies.apirest.services;

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

		Node raiz = tree.getNodes().get(0);

		this.tree.getNodes().add(raiz);

		int cont = 0;
		for (Node node : tree.getNodes()) {
			if (cont != 0)
				insertNode(node);
			//nodeRepository.save(node);
			cont++;
		}

		recorrer(raiz);
		System.out.println("*************************************");
		System.out.println("*************************************");
		System.out.println("*************************************");
		// recorrer(this.tree.getNodes().get(0));

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
				aux = aux.getRight();
				System.out.println("Derecha");
			} else {
				aux = aux.getLeft();
				System.out.println("Izquierda");
			}
			if (cont != 0)
				this.tree.getNodes().add(cont, aux);
			System.out.println(cont + ":" + aux);
		}

		if (node.getKey() < node.getParent().getKey()) {
			node.getParent().setLeft(node);
		} else
			node.getParent().setRight(node);
		System.out.println("----------------------------");
	}

     
    
	public void recorrer(Node n) {
		System.out.println("----------RECORRER-------------");
		System.out.println("Recorriendo:" + n);
		if (n != null) {
			recorrer(n.getLeft());
			System.out.println("node:" + n.getKey());
			if (n.getParent() != null)
				System.out.println("nodeParent: " + n.getParent().getKey());
			recorrer(n.getRight());
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++-");
	}

     
	@Override
	public Tree save(Tree tree) {
		if (tree != null) {
			Tree tree1 = createTree(tree);
			System.out.println("tree:" + tree1);
			return treeRepository.save(tree1);
		}
		return new Tree();
	}

 	@Override

	public Optional<Tree> findById(Integer id) {

		Optional<Tree> tree = treeRepository.findById(id);
		return tree;
	} 

}
