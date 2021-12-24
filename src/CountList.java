
public class CountList {
	private CountListNode head = null;

	public boolean IsSameNameExists(CountListNode node) {
		if (head == null) {
			return false;
		}
		CountListNode current = head;

		while (true) {
			if (current.getName().equals(node.getName())) {
				current.setCount(current.getCount() + 1);
				return true;
			}
			if (current.getNext() != null) {
				current = current.getNext();
			} else {
				break;
			}
		}
		return false;
	}

	public void AddNode(CountListNode node) {
		if (head == null) {
			head = node;
		} else {
			CountListNode current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			node.setPrev(current);
			current.setNext(node);
		}
	}

	@Override
	public String toString() {
		CountListNode current = head;
		if (current == null) {
			return "";
		}
		while (true) {
			System.out.println(current.toString());
			if (current.getNext() != null) {
				current = current.getNext();
			} else {
				break;
			}
		}
		return "";
	}

	public void onlyNames() {
		CountListNode current = head;
		if (current == null) {
			return;
		}
		while (true) {
			System.out.println(current.onlyName());
			if (current.getNext() != null) {
				current = current.getNext();
			} else {
				break;
			}
		}
	}
}