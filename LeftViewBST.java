package src.Tree;

class LeftViewBST_node {
	int key;
	LeftViewBST_node left, right;
	
	LeftViewBST_node(int item){
		key = item;
		left = right = null;
	}
}


/* Print entire left view of tree - Only left not root & right */
public class LeftViewBST {
	LeftViewBST_node root;
	
	LeftViewBST()
	{
		root = null;
	}
	
	public LeftViewBST(int item)
	{
		root = new LeftViewBST_node(item);
	}
	
	// Please note: recursive function will return one step be behind - thats why level value is not getting updated after getting root as null.
	// The problem can also be solved using simple recursive traversal. 
	// We can keep track of the level of a node by passing a parameter to all recursive calls. 
	// The idea is to keep track of the maximum level also. 
	// Whenever we see a node whose level is more than maximum level so far, 
	//we print the node because this is the first node in its level 
	int max_level = 0;
	void leftsidetree(LeftViewBST_node root, int level) {
		
		
		if (root == null)
		{
			return;
		}
		// Enable below line to understand the logic
//		System.out.println(" level ==> " + level + "   Max level " + max_level + "=== Node value ==="+ root.key);
		if(max_level < level)
		{
			System.out.println("Node is =====> " + root.key);
			max_level = level;
		}
		
		leftsidetree(root.left, level +1);
		leftsidetree(root.right, level +1);	
		
		return;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeftViewBST tree = new LeftViewBST();
		tree.root = new LeftViewBST_node(20);
		tree.root.left = new LeftViewBST_node(8);
		tree.root.left.left = new LeftViewBST_node(4);
		tree.root.left.right = new LeftViewBST_node(12);
		tree.root.left.right.right = new LeftViewBST_node(14);
		tree.root.left.right.left = new LeftViewBST_node(10);
		tree.root.right = new LeftViewBST_node(22);
		
		tree.leftsidetree(tree.root, 1);

	}

}
