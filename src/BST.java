
public class BST<T extends Comparable<T>> {
	private TreeNode<T> root = null;

	// Finds if given node is exist
	public void containsIterative(TreeNode<T> node) {
		boolean studentFound = containsIterative(root, node, 0);

		if (studentFound) {
			System.out.println("Student found" + "\n");
		} else {
			// if any operations happen when student not found
		}
	}

	// Traverses tree iterative and finds if given node exists in tree prints how
	// many hops it did
	private boolean containsIterative(TreeNode<T> current, TreeNode<T> node, int hopCount) {
		if (isEmpty()) {
			System.out.println("Student not found!");
			System.out.println("Hops = 0" + "\n");
			return false;
		} else {
			// Traverse until root reaches to dead end
			while (current != null) {
				// pass right subtree as new tree
				if (node.compareTo(current.studentRef) == 2) {
					hopCount++;
					current = current.right;
				}
				// pass left subtree as new tree
				else if (node.compareTo(current.studentRef) == 1) {
					current = current.left;
					hopCount++;
				} else if (node.compareTo(current.studentRef) == 0) {
					System.out.println(current.toString());
					System.out.println("Hops = " + hopCount);
					return true;
				}
			}
			System.out.println("Student not found!");
			System.out.println("Hops = " + hopCount + "\n");
			return false;
		}
	}

	// Traverse for listing all names (inorder for user)
	public void traverseInOrder() {
		String names = "";
		traverseInOrder(root, names);
	}

	// Traverses inorder in tree prints names to screen
	private String traverseInOrder(TreeNode<T> root, String names) {
		if (root != null) {
			traverseInOrder(root.left, names);
			if (!root.toString().equals("")) {
				System.out.println(root.toString());
			}
			traverseInOrder(root.right, names);
		}

		return names;
	}

	// Returns if root is null
	public boolean isEmpty() {
		return root == null;
	}

	// Inserts given node
	public void insert(TreeNode<T> node) {
		if (isEmpty()) {
			root = node;
			System.out.println("Addition complete");
		} else {
			insert(root, node);
		}
	}

	// Inserts recursive
	private void insert(TreeNode<T> root, TreeNode<T> newNode) {
		if (newNode.compareTo(root.studentRef) == 1) {
			if (root.left == null) {
				root.left = newNode;
				System.out.println("Addition complete");
			} else {
				insert(root.left, newNode);
			}
		} else if (newNode.compareTo(root.studentRef) == 2) {
			if (root.right == null) {
				root.right = newNode;
				System.out.println("Addition complete");
			} else {
				insert(root.right, newNode);
			}
		} else if (newNode.compareTo(root.studentRef) == 0) {
			System.out.println("Please enter another ID number, there is already a student exists with same ID!");
		}
	}

	// Deletes given node
	public void deleteKey(TreeNode<T> node) {
		if (root == null) {
			System.out.println("Student not found!");
		} else {
			root = deleteRec(root, node);
		}
	}

	// Deletes recursive
	private TreeNode<T> deleteRec(TreeNode<T> current, TreeNode<T> node) {
		if (current == null) {
			System.out.println("Student not found!");
			return current;
		}
		if (node.compareTo(current.studentRef) == 1) {
			current.left = deleteRec(current.left, node);
		} else if (node.compareTo(current.studentRef) == 2) {
			current.right = deleteRec(current.right, node);
		}
		// If key is same as roots key
		// This is the node to be deleted
		else {
			System.out.println("Student deleted!");
			// node with only one child or no child
			if (current.left == null)
				return current.right;
			else if (current.right == null)
				return current.left;
			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			current = minValue(current.right);
			// Delete the inorder successor
			current.right = deleteRec(current.right, current);
		}
		return current;
	}

	// Finds minimum value in the tree
	private TreeNode<T> minValue(TreeNode<T> current) {
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

}