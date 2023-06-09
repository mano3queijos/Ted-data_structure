//**//
//
//
//**//
//****&&&&&&&&&&&&&&&&&&&&&&&*********************%*%*%****//https://github.com/mano3queijos
//**//
//
//
//**//
package br.com.ucsal.data_structure.emanuelAp;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	public class Node {
		public Node parent;
		public Node left;
		public Node right;
		public Integer value;

		public Node(Integer value) {
			this.value = value;
			left = null;
			right = null;
			parent = null;
		}
	}

	public Node root;

	public Tree() {
		root = null;
	}

	// method to insert an element on the tree
	public String insert(Integer value) {
		Node localNode = root;
		Node node = new Node(value);

		if (isNull(root)) {
			root = node;
			return "Value added to the root";
		}

		while (!isNull(localNode)) {
			node.parent = localNode;
			if (value == localNode.value) {
				return "The value already exists in the tree, not inserted";
			} else if (value < localNode.value) {
				localNode = localNode.left;
				if (isNull(localNode)) {
					return insertNodeLeft(value, node.parent);
				}
			} else {
				localNode = localNode.right;
				if (isNull(localNode)) {
					node.parent.right = node;
					return insertNodeRight(value, node.parent);
				}
			}
		}
		return "Value was not inserted";
	}

// method to check if the node is null
	public boolean isNull(Node node) {
		return node == null;
	}

	// method to insert an element right
	public String insertNodeRight(Integer newNode, Node parent) {
		Node node = new Node(newNode);
		parent.right = node;
		node.parent = parent;
		return "Node added to the right";

	}

// method to insert an element left
	public String insertNodeLeft(Integer newNode, Node parent) {
		Node node = new Node(newNode);
		parent.left = node;
		node.parent = parent;
		return "Node added to the left";

	}

	// method to remove an element right
	public String removeRight(Node parent) {
		if (isNull(parent.right)) {
			return "the referred node is null";
		}
		Integer value = parent.right.value;
		parent.right = null;
		return "value removed" + value;
	}

// method to remove an element left
	public String removeLeft(Node parent) {
		if (isNull(parent.left)) {
			return "the referred node is null";
		}
		Integer value = parent.left.value;
		parent.left = null;
		return "value removed:" + value;
	}

	// method to show the size of the tree
	public Integer size() {
		return size(root);
	}

	private Integer size(Node node) {
		if (isNull(node)) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

// method for Check if node is leaf
	public String isLeaf(Node node) {

		if (isNull(node))
			return "the node is null";

		return (isNull(node.left)) && (isNull(node.right)) ? "node " + node.value + " is a leaf"
				: "node " + node.value + " isn't a leaf";

	}

	// methods to get elements on the left of the tree

	public void getElementsLeft() {
		getElementsLeft(root.left);

	}

	private void getElementsLeft(Node node) {
		printTree(node, "");

	}

	// methods to get elements on the right of the tree

	public void getElementsRight() {
		getElementsRight(root.right);

	}

	private void getElementsRight(Node node) {

		printTree(node, "");

	}

	// function to return the search in preOrder

	public List<Integer> preOrder() {
		List<Integer> result = new ArrayList<>();
		preOrder(root, result);
		return result;
	}

	// method to search in preOrder
	private void preOrder(Node node, List<Integer> result) {
		if (isNull(node)) {
			return;
		}
		result.add(node.value);
		preOrder(node.left, result);
		preOrder(node.right, result);
	}
	// function to return the search in order

	public List<Integer> inOrder() {
		List<Integer> result = new ArrayList<>();
		inOrder(root, result);
		return result;
	}

	// method to search in order
	private void inOrder(Node node, List<Integer> result) {
		if (isNull(node)) {
			return;
		}
		inOrder(node.left, result);
		result.add(node.value);
		inOrder(node.right, result);
	} // function to to return the search in pos-Order

	public List<Integer> posOrder() {
		List<Integer> result = new ArrayList<>();
		posOrder(root, result);
		return result;
	}

	// method to search in pos-order
	private void posOrder(Node node, List<Integer> result) {
		if (isNull(node)) {
			return;
		}
		posOrder(node.left, result);
		posOrder(node.right, result);
		result.add(node.value);

	}

// methods for print the tree
	public void printTree() {
		printTree(root, "  ");
	}

	private void printTree(Node node, String indent) {
		if (isNull(node)) {
			return;
		}

		System.out.println(indent + node.value);

		if (!isNull(node.right)) {
			System.out.println(indent + " │");
			System.out.println(indent + " ├─");
			printTree(node.right, indent + " │ ");
		}

		if (!isNull(node.left)) {
			System.out.println(indent + " │");
			System.out.println(indent + " └─");
			printTree(node.left, indent + "   ");
		}
	}

}
