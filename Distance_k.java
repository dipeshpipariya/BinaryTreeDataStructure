package src.Tree;

import java.util.ArrayList;
import java.util.Arrays;

class Node2 {
	int key;
	Node2 left, right;

	public Node2(int item) {
		key = item;
		left = right = null;
	}
}

public class Distance_k {
	Node2 root1;
	Node2 root2;
	int i = 0;

	int tree[] = new int[7];

	public Distance_k() {
		root1 = null;
		root2 = null;
	}

	public int[] preOrder(Node2 node) {

		if (node == null) {
			//System.out.println("=================> " + i);
			//tree[] = -1;
			return tree;
		}

		// System.out.println(" " + node.key);
		if (node != null) {
			tree[i] = node.key;
			i++;
		}

		//System.out.println(" ===> " + Arrays.toString(tree));

		preOrder(node.left);
		preOrder(node.right);
		Arrays.sort(tree);

		// System.out.println(" ===> " + Arrays.toString(tree));
		i = 0;
		tree.clone();
		return tree;
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Distance_k dk = new Distance_k();
		dk.root1 = new Node2(3);
		dk.root1.left = new Node2(1);
		dk.root1.right = new Node2(5);
		dk.root1.right.left = new Node2(10);
		dk.root2 = new Node2(4);
		dk.root2.left = new Node2(2);
		dk.root2.right = new Node2(6);

		int a[] = dk.preOrder(dk.root2);
		System.out.println("===========> " + Arrays.toString(a));
		int b[] = dk.preOrder(dk.root1);
		System.out.println("===========> " + Arrays.toString(b));

	}

}
