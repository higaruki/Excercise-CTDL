package Task1;

import java.util.ArrayList;
import java.util.List;

public class Course {
	String id;
	String title;
	String type;
	List<Student> student = new ArrayList<>();
	String lecturer;

	public Course(String id, String title, String type, List<Student> student, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.student = student;
		this.lecturer = lecturer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	@Override
	public String toString() {
		return "id : " + id + ", title : " + title + ", type : " + type + ", student : " +"..." + ", lecturer : "
				+ lecturer + " ----";
	}

}
