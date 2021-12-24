
public class Student implements Comparable<Student> {
	// Field
	private int studentID = 0;
	private String name = "";
	private String surname = "";

	public Student(int studentID, String name, String surname) // Constructor
	{
		this.studentID = studentID;
		this.name = name;
		this.surname = surname;
	}

	// Getters
	public int getStudentID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	// Setters
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	// returns smallest ID (Since ID is key there is no equal chance)
	@Override
	public int compareTo(Student student) {
		if (this.studentID < student.getStudentID()) {
			return 1;
		} else if (this.studentID > student.getStudentID()) {
			return 2;
		} else {
			return 0;
		}
	}

	// Turns Student information to string
	@Override
	public String toString() {
		return "studentID=" + studentID + ", name='" + name + '\'' + ", surname='" + surname + '\'';
	}
}
