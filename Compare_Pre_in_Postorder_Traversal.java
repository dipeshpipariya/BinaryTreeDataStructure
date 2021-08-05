package src.Tree;

class Compare_Pre_in_Postorder_Traversal {

	// Function to check if traversals are
	// of the same tree
	static boolean checktree(int preorder[], int s, int inorder[], int s1, int postorder[], int s2, int len) {

		// if the array lengths are 0,
		// then all of them are obviously equal
		if (len == 0)
			return true;

		// if array lengths are 1,
		// then check if all of them are equal
		if (len == 1)
			return ((preorder[s] == inorder[s1]) && (inorder[s1] == postorder[s2]));

		// search for first element of preorder
		// in inorder array
		int idx = -1;
		for (int i = s1; i < len; ++i)
			if (inorder[i] == preorder[s]) {
				idx = i;
				break;
			}

		if (idx == -1)
			return false;

		// check for the left subtree
		boolean ret1 = checktree(preorder, s + 1, inorder, s1, postorder, s2, idx);

		// check for the right subtree
		boolean ret2 = checktree(preorder, s + idx + 1, inorder, s1 + idx + 1, postorder, s2 + idx, len - idx - 1);

		// return 1 only if both of them are
		// correct else 0
		return (ret1 && ret2);
	}

	// Driver Code
	public static void main(String args[]) {
		// Traversal Arrays
		int inorder[] = { 4, 2, 5, 1, 3 };
		int preorder[] = { 1, 2, 4, 5, 3 };
		int postorder[] = { 4, 5, 2, 3, 1 };
		int len1 = inorder.length;
		int len2 = preorder.length;
		int len3 = postorder.length;

		// Check if all the array lengths are equal
		if ((len1 == len2) && (len2 == len3)) {

			boolean res = checktree(preorder, 0, inorder, 0, postorder, 0, len1);

			System.out.print(((res) ? "Yes" : "No"));
		} else
			System.out.print("No\n");
	}
}