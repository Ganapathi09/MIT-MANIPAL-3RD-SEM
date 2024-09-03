package opplab7;

class Student_Detail {
	  private String name;
	  private int id;
	  private String college_name;

	  public Student_Detail(String name, int id, String college_name) {
	    this.name = name;
	    this.id = id;
	    this.college_name = college_name;
	  }

	  public void display_details() {
	    System.out.println("Name: " + name);
	    System.out.println("ID: " + id);
	    System.out.println("College Name: " + college_name);
	  }
	}

	public class Main1 {
	  public static void main(String[] args) {
	    Student_Detail student_1 = new Student_Detail("John Doe", 1, "MIT");
	    Student_Detail student_2 = new Student_Detail("Jane Doe", 2, "MIT");

	    student_1.display_details();
	    student_2.display_details();
	  }
	}
