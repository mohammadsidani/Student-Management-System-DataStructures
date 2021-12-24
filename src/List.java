
public class List<T extends Comparable<T>> {
	private ListNode<T> headNode = null;

	public ListNode<T> getHeadNode() {
		return headNode;
	}

	public void DeleteStudent(ListNode<T> node) {
		if (headNode == null) {
			System.out.println("Student not found!");
			return;
		} else {
			ListNode<T> currentNode = headNode;

			while (node.compareTo(currentNode.getStudent()) != 0) {
				// Null control
				if (currentNode.getNext() == null) {
					System.out.println("Student not found!");
					return; // early return
				}
				currentNode = currentNode.getNext();
			}

			if (node.compareTo(currentNode.getStudent()) == 0) {
				if (currentNode.getNext() != null && currentNode.getPrev() != null) {
					currentNode.prev.next = currentNode.next;
					currentNode.next.prev = currentNode.prev;
				} else if (currentNode.next == null && currentNode.prev != null) {
					currentNode.prev.next = null;
				} else if (currentNode.prev == null && currentNode.next != null) {
					currentNode.next.prev = null;
					headNode = currentNode.next;
				} else if (currentNode.prev == null && currentNode.next == null) {
					headNode = null;
				}
				System.out.println("Student deleted!");
			} else {
				System.out.println("Student not found!");
			}
		}
	}

	public void AddStudent(ListNode<T> node) {
		// Head node control
		if (headNode == null) {
			headNode = node;
			System.out.println("Addition complete");
		} else {
			ListNode<T> currentNode = headNode;

			// Iterate through list
			while (currentNode.next != null) {
				if (node.student.compareTo(currentNode.student) != 2) {
					break;
				}
				currentNode = currentNode.next;
			}
			// Same student exist control
			if (node.student.compareTo(currentNode.student) == 0) {
				System.out.println("Please enter another ID number, there is already a student exists with same ID!");
				return;
			}
			// Head addition
			if (currentNode == headNode) {
				// Second entry is smaller (headNode is new node)
				if (node.student.compareTo(currentNode.student) == 1) {
					node.next = currentNode;
					currentNode.prev = node;
					headNode = node;
					System.out.println("Addition complete");
					return;
				}
				// Second entry is bigger (headNode is same)
				else {
					currentNode.next = node;
					node.prev = currentNode;
					System.out.println("Addition complete");
					return;
				}
			}
			// End addition
			if (currentNode.next == null) {
				if (node.student.compareTo(currentNode.student) == 1) {
					node.next = currentNode;
					node.prev = currentNode.prev;
					currentNode.prev.next = node;
					currentNode.prev = node;
					System.out.println("Addition complete");
					return;
				} else {
					currentNode.next = node;
					node.prev = currentNode;
					System.out.println("Addition complete");
					return;
				}
			}
			// Middle addition
			else {
				if (node.student.compareTo(currentNode.student) == 1) {
					node.next = currentNode;
					node.prev = currentNode.prev;
					currentNode.prev.next = node;
					currentNode.prev = node;
					System.out.println("Addition complete");
					return;
				} else {
					node.next = currentNode.next;
					node.prev = currentNode;
					currentNode.next = node;
					node.next.prev = node;
					System.out.println("Addition complete");
					return;
				}
			}
		}
	}

	public void FindStudent(ListNode<T> node) {
		// HeadNode control
		if (headNode == null) {
			System.out.println("Student not found!");
			System.out.println("Hops = 0\n");
		} else {
			ListNode<T> currentNode = headNode;
			int hops = 0;
			// Student ID control loop
			while (node.compareTo(currentNode.student) != 0) {
				// Null control
				if (currentNode.next == null) {
					System.out.println("Student not found!");
					System.out.println("Hops= " + hops + "\n");
					return; // early return
				}
				currentNode = currentNode.next;
				hops++;
			}
			// Prints needed properties
			System.out.println(currentNode.toString());
			System.out.println("Student found");
			System.out.println("Hops= " + hops + "\n");
		}
	}

	@Override
	public String toString() {
		String all = "";
		ListNode<T> currentNode = headNode;
		if (headNode == null) {
			return "There is no student in database!";
		}
		while (currentNode != null) {
			all = all.concat(currentNode.toString()) + "\n";
			currentNode = currentNode.next;
		}
		return all;
	}
}
