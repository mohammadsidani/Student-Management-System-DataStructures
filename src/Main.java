
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> List = new List<>();
		BST<Student> Tree = new BST<>();
		HashTable<Student> Hash = new HashTable<>();

		while (true) {
			System.out.println("0. Exit program\n" + "1. Add student\n" + "2. Delete student\n" + "3. Find student\n"
					+ "4. List all students\n" + "5. List distinct names\n" + "6. List name counts\n" + "7. About\n");
			String select = sc.nextLine(); // Gets selected menu
			// Exit Program
			if (select.equals("0")) {
				System.out.println("Are you sure you want to exit?\n" + "Write 0 for confirmation ");
				String s = sc.nextLine();
				if (s.equals("0")) {
					System.out.println("Thank you for choosing us and have a nice day!");
					break;
				}
			}
			// Add Student
			else if (select.equals("1")) {
				System.out.println("Please enter student's ID");
				int ID = sc.nextInt();
				sc.nextLine();// empty char catch
				System.out.println("Please enter student's name");
				String name = sc.nextLine();
				System.out.println("Please enter student's surname");
				String surname = sc.nextLine();
				// Creates new student with given information
				Student newStudent = new Student(ID, name, surname);
				// List Addition
				System.out.println("List:");
				ListNode<Student> newListNode = new ListNode<Student>(newStudent, null, null);
				List.AddStudent(newListNode);
				// Tree Addition
				System.out.println("Tree:");
				TreeNode<Student> newTreeNode = new TreeNode<>(newStudent);
				Tree.insert(newTreeNode);
				// Hash Addition
				System.out.println("Hash:");
				Hash.AddStudent(newStudent);
				// Call add on all 3 sets
			}
			// Delete Student from its ID
			else if (select.equals("2")) {
				System.out.println("Please enter the student's ID :");
				int ID = sc.nextInt();
				sc.nextLine();// empty char catch
				// Create temp student wih same ID
				Student findStudent = new Student(ID, "", "");
				// List Deletion
				System.out.println("List:");
				ListNode<Student> newNode = new ListNode<Student>(findStudent, null, null);
				List.DeleteStudent(newNode);
				// Tree Deletion
				System.out.println("Tree:");
				TreeNode<Student> treeNode = new TreeNode<>(findStudent);
				Tree.deleteKey(treeNode);
				// Hash Deletion
				System.out.println("Hash:");
				Hash.DeleteStudent(findStudent);

			}
			// Finds given student from ID
			else if (select.equals("3")) {
				System.out.println("Please enter the student's ID :");
				int ID = sc.nextInt();
				sc.nextLine();// empty char catch

				Student findStudent = new Student(ID, "", "");

				System.out.println("List:");
				ListNode<Student> newNode = new ListNode<Student>(findStudent, null, null);
				List.FindStudent(newNode);

				System.out.println("Tree:");
				TreeNode<Student> newTreeNode = new TreeNode<>(findStudent);
				Tree.containsIterative(newTreeNode);

				System.out.println("Hash:");
				Hash.FindStudent(findStudent);
			}
			// List all students
			else if (select.equals("4")) {
				// iterate
				System.out.println("Which data structure you want to operate?");
				System.out.println("1.List");
				System.out.println("2.Binary Search Tree");
				System.out.println("3.Hash");
				String selection = sc.nextLine();
				if (selection.equals("1")) {
					System.out.println(List.toString());
				} else if (selection.equals("2")) {
					Tree.traverseInOrder();
				} else if (selection.equals("3")) {
					Hash.ListAll();
				} else {
					// Return to menu
				}
			}
			// Shows all distinct names
			else if (select.equals("5")) {
				CountList nameList = new CountList();
				if (List.getHeadNode() == null) {
					System.out.println("There are no student in database");
				} else {
					ListNode<Student> current = List.getHeadNode();
					while (true) {
						CountListNode newNode = new CountListNode(current.getStudent().getName());
						if (nameList.IsSameNameExists(newNode)) {
							// Increases names count in IsSameNameExists
						} else {
							nameList.AddNode(newNode);
						}
						if (current.getNext() == null) {
							break;
						} else
							current = current.getNext();
					}
					nameList.onlyNames();
				}
			}
			// Shows how many of each name
			else if (select.equals("6")) {
				CountList nameList = new CountList();
				// list how many same names
				if (List.getHeadNode() == null) {
					System.out.println("There are no student in database");
				} else {
					ListNode<Student> current = List.getHeadNode();
					while (true) {
						CountListNode newNode = new CountListNode(current.getStudent().getName());
						if (nameList.IsSameNameExists(newNode)) {
							// Increases names count in IsSameNameExists
						} else {
							nameList.AddNode(newNode);
						}
						if (current.getNext() == null) {
							break;
						} else
							current = current.getNext();
					}
					nameList.toString();
				}
			}
			// Shows authors properties
			else if (select.equals("7")) {
				System.out.println("Student ID, Student Name\n");
			}
			// outside of 0-7 selections
			else {
				System.out.println("Wrong Selection!!");
			}
		}
	}
}