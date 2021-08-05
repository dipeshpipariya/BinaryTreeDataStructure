package src.Tree;

import java.util.Stack;

class Node {
	int Key;
	Node left, right;

	public Node(int item) {
		Key = item;
		left = right = null;
	}
}

class BinaryTree {
	static Node root;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}

	void printPreorder(Node node) {
		if (node == null)
			return;

		System.out.print(node.Key + " ");

		printPreorder(node.left);
		

		printPreorder(node.right);

	}

	void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.Key + " ");
		printInorder(node.right);

	}

	int printPosteorder(Node node) {
		if (node == null)
			return 1;

		printPosteorder(node.left);

		printPosteorder(node.right);
		System.out.print(node.Key + " ");
		return 1;

	}

	void iterativePreorder(Node node) {

		// Base Case
		if (node == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item a) print it b)
		 * push its right child c) push its left child Note that right child is pushed
		 * first so that left is processed first
		 */
		while (nodeStack.empty() == false) {

			// Pop the top item from stack and print it
			Node mynode = nodeStack.peek();
			System.out.print(mynode.Key + " ");
			nodeStack.pop();

			// Push right and left children of the popped node to stack
			if (mynode.right != null) {
				nodeStack.push(mynode.right);
			}
			if (mynode.left != null) {
				nodeStack.push(mynode.left);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		BinaryTree.root = new Node(1);
		BinaryTree.root.left = new Node(2);
		BinaryTree.root.right = new Node(3);
		BinaryTree.root.left.left = new Node(4);
		BinaryTree.root.left.right = new Node(5);

		System.out.println("Preorder");
		tree.printPreorder(root);

		System.out.println("Postorder");
		tree.printPosteorder(root);

		System.out.println("Inorder");
		tree.printInorder(root);
	}
}