package Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	String name;
	String address;
	List<Course> courses = new ArrayList<>();

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		int index = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(index).getType().equals("TH")) {
				if (courses.get(i).getStudent().size() > courses.get(index).getStudent().size()
						&& courses.get(i).getType().equals("TH")) {
					index = i;
				}
			} else {
				index++;
			}
		}
		return courses.get(index);
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> m1 = new HashMap<>();
		for (int i = 0; i < courses.size(); i++) {
			for (Student s : courses.get(i).getStudent()) {
				List<Student> students = new ArrayList<>();
				if (!m1.containsKey(s.getYear())) {
					students.add(s);
					m1.put(s.getYear(), students);
				} else {
					students = m1.get(s.getYear());
					if (!students.contains(s)) {
						students.add(s);
					}
				}
			}
		}
		return m1;
	}

	public Set<Course> filterCourses(String type) {
		TreeSet<Course> t1 = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				return o2.getStudent().size() - o1.getStudent().size();
			}
		});
		for (Course arr : courses) {
			if (arr.getType().equals(type)) {
				t1.add(arr);
			}
		}
		return t1;
	}

}
