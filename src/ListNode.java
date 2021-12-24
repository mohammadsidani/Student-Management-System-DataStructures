
public class ListNode<T extends Comparable<T>> implements Comparable<T> {
	// Field
	T student = null;
	ListNode<T> next = null;
	ListNode<T> prev = null;

	// Constructor
	public ListNode(T student, ListNode<T> next, ListNode<T> prev) {
		this.student = student;
		this.next = next;
		this.prev = prev;
	}

	public ListNode(T student) // Constructor which takes only student reference
	{
		this.student = student;
	}

	// Getters and Setters
	public T getStudent() {
		return student;
	}

	public void setStudent(T student) {
		this.student = student;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	public ListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(ListNode<T> prev) {
		this.prev = prev;
	}

	// Returns smallest ID
	@Override
	public int compareTo(T o) {
		return this.student.compareTo(o);
	}

	@Override
	public String toString() {
		return student.toString();
	}
}
