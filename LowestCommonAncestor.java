package src.Tree;

class LowestCommonAncestor_node {
	int key;
	LowestCommonAncestor_node left, right;

	public LowestCommonAncestor_node(int item) {
		key = item;
		left = right = null;
	}

}

public class LowestCommonAncestor {
	LowestCommonAncestor_node root;

	LowestCommonAncestor() {
		root = null;
	}

	public LowestCommonAncestor(int key) {
		root = new LowestCommonAncestor_node(key);
	}

	void inorder(LowestCommonAncestor_node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
//		System.out.println("Order ==> " + node.key);
		inorder(node.right);

	}

	// Method with return type of Node which can be printed using node.key
	LowestCommonAncestor_node leastCommonAncestor(LowestCommonAncestor_node node, int n1, int n2) {
//		System.out.println("===> " + node.key);
		if (node == null) {
			return null;
		}

		if (node.key > n1 && node.key > n2) {
			return leastCommonAncestor(node.left, n1, n2);
		}

		if (node.key < n1 && node.key < n2) {
			return leastCommonAncestor(node.right, n1, n2);
		}

		return node;
	}

	LowestCommonAncestor_node leastCommonAncestor_iterative_approch(LowestCommonAncestor_node node, int n1, int n2) {
		while (node != null) {
			
	        // If both n1 and n2 are smaller 
	        // than root, then LCA lies in left 
			if (node.key > n1 && node.key > n2)
				node = node.left;
			
	        // If both n1 and n2 are greater 
	        // than root, then LCA lies in right
			else if (node.key < n1 && node.key < n2)
				node = node.right;

			else
				break;
		}
		return node;

	}

	public static void main(String args[]) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new LowestCommonAncestor_node(20);
		tree.root.left = new LowestCommonAncestor_node(8);
		tree.root.left.left = new LowestCommonAncestor_node(4);
		tree.root.left.right = new LowestCommonAncestor_node(12);
		tree.root.left.right.right = new LowestCommonAncestor_node(14);
		tree.root.left.right.left = new LowestCommonAncestor_node(10);
		tree.root.right = new LowestCommonAncestor_node(22);

		tree.inorder(tree.root);

		LowestCommonAncestor_node val = tree.leastCommonAncestor(tree.root, 10, 14);
		System.out.println("Least common ancestor is " + val.key);

		LowestCommonAncestor_node val_1 = tree.leastCommonAncestor_iterative_approch(tree.root, 10, 14);
		System.out.println("Least common ancestor is " + val_1.key);

	}

}
