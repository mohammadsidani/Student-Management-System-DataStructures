
public class TreeNode<T extends Comparable<T>> implements Comparable<T> {
	// Field
	T studentRef = null;
	TreeNode<T> left = null;
	TreeNode<T> right = null;

	// Constructors
	public TreeNode(T studentRef, TreeNode<T> left, TreeNode<T> right) {
		this.studentRef = studentRef;
		this.left = left;
		this.right = right;
	}

	public TreeNode(T studentRef) {
		this.studentRef = studentRef;
	}

	@Override
	public int compareTo(T o) {
		return this.studentRef.compareTo(o);
	}

	@Override
	public String toString() {
		return studentRef.toString();
	}
}
