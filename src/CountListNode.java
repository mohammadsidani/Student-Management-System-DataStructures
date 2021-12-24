
public class CountListNode {
	private String name = "";
	private int count = 1;
	private CountListNode next = null;
	private CountListNode prev = null;

	// Constructors
	public CountListNode(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public CountListNode(String name, int count, CountListNode next) {
		this.name = name;
		this.count = count;
		this.next = next;
	}

	public CountListNode(String name) {
		this.name = name;
	}

	// Getter Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CountListNode getNext() {
		return next;
	}

	public void setNext(CountListNode next) {
		this.next = next;
	}

	public CountListNode getPrev() {
		return prev;
	}

	public void setPrev(CountListNode prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", count= " + count;
	}

	public String onlyName() {
		return "Name: " + name;
	}
}
