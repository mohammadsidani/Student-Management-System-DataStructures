
public class HashTable<T extends Comparable<T>> {
	private List<T>[] theList = new List[11];

	// Constructor
	public HashTable() {
		// Creates all lists in arrays
		theList[0] = new List();
		theList[1] = new List();
		theList[2] = new List();
		theList[3] = new List();
		theList[4] = new List();
		theList[5] = new List();
		theList[6] = new List();
		theList[7] = new List();
		theList[8] = new List();
		theList[9] = new List();
		theList[10] = new List();
	}

	public int HashFunction(int key) {
		return key % 10;
	}

	public void AddStudent(Student student) {
		int key = student.getStudentID();
		int index = HashFunction(key);
		ListNode<T> node = new ListNode<T>((T) student);
		theList[index].AddStudent(node);
	}

	// 11 array positions (0-10)
	public void DeleteStudent(Student student) {
		int key = student.getStudentID();
		int index = HashFunction(key);
		ListNode<T> node = new ListNode<T>((T) student);
		theList[index].DeleteStudent(node);
	}

	public void FindStudent(Student student) {
		int key = student.getStudentID();
		int index = HashFunction(key);
		ListNode<T> node = new ListNode<T>((T) student);
		theList[index].FindStudent(node);
	}

	public void ListAll() {
		String errorMessage = "";
		String note = "There is no student in database!There is no student in database!There is no student in database!There is no student in database!There is no student in database!There is no student in database!There is no student in database!There is no student in database!There is no student in database!There is no student in database!There is no student in database!";
		for (int i = 0; i < 11; i++) {
			if (theList[i].toString().equals("There is no student in database!")) {
				errorMessage = errorMessage + "There is no student in database!";
			} else {
				System.out.println(theList[i].toString());
			}
		}
		if (errorMessage.equals(note)) {
			System.out.println("There is no student in database!");
		}
	}
}
