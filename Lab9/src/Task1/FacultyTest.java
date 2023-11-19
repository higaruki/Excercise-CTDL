package Task1;

import java.util.ArrayList;
import java.util.List;

public class FacultyTest {
	public static void main(String[] args) {
		Student s1 = new Student("001", "student A", 2020);
		Student s2 = new Student("002", "student B", 2020);
		Student s3 = new Student("003", "student C", 2020);
		Student s4 = new Student("004", "student D", 2020);
		Student s5 = new Student("005", "student E", 2021);
		Student s6 = new Student("006", "student F", 2021);
		Student s7 = new Student("007", "student G", 2021);
		Student s8 = new Student("008", "student H", 2021);
		Student s9 = new Student("009", "student I", 2022);
		Student s10 = new Student("010", "student J", 2022);
		Student s11 = new Student("011", "student K", 2022);
		Student s12 = new Student("012", "student L", 2022);
		Student s13 = new Student("013", "student M", 2022);
		Student s14 = new Student("014", "student N", 2022);
		Student s15 = new Student("015", "student O", 2022);
		Student s16 = new Student("016", "student P", 2022);
		Student s17 = new Student("017", "student Q", 2022);
		Student s18 = new Student("018", "student R", 2022);
		List<Student> students1 = new ArrayList<>();// 7
		students1.add(s1);
		students1.add(s2);
		students1.add(s3);
		students1.add(s4);
		students1.add(s5);
		students1.add(s6);
		students1.add(s11);
		List<Student> students2 = new ArrayList<>();// 4
		students2.add(s5);
		students2.add(s6);
		students2.add(s7);
		students2.add(s8);
		List<Student> students3 = new ArrayList<>();// 3
		students3.add(s9);
		students3.add(s10);
		students3.add(s12);
		List<Student> students4 = new ArrayList<>();// 9
		students4.add(s13);
		students4.add(s14);
		students4.add(s15);
		students4.add(s16);
		students4.add(s17);
		students4.add(s18);
		students4.add(s11);
		students4.add(s6);
		students4.add(s7);
		List<Student> students5 = new ArrayList<>();// 10
		students5.add(s1);
		students5.add(s5);
		students5.add(s6);
		students5.add(s11);
		students5.add(s9);
		students5.add(s10);
		students5.add(s12);
		students5.add(s17);
		students5.add(s18);
		students5.add(s11);
		List<Student> students6 = new ArrayList<>();// 13
		students6.add(s1);
		students6.add(s2);
		students6.add(s3);
		students6.add(s4);
		students6.add(s5);
		students6.add(s6);
		students6.add(s11);
		students6.add(s9);
		students6.add(s10);
		students6.add(s12);
		students6.add(s17);
		students6.add(s18);
		students6.add(s11);
		Course c1 = new Course("001", "LTNC", "TH", students1, "Nguyen Thi Phuong Tram");
		Course c2 = new Course("002", "CTMT", "LT", students2, "Vo Tan Linh");
		Course c3 = new Course("003", "GTMN", "TH", students3, "Le Phi Hung");
		Course c4 = new Course("004", "GTMN", "TH", students4, "Le Phi Hung");
		Course c5 = new Course("005", "NMCNTT", "LT", students5, "Vo Tan Toan");
		Course c6 = new Course("006", "LTCB", "TH", students6, "Nguyen Duc Cong Song");
		List<Course> courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		courses.add(c5);
		courses.add(c6);
		Faculty f1 = new Faculty("KHOA CNTT", "111", courses);
		System.out.println("Course Thực Hành Có Nhiều Sinh Viên Nhất : ");
		System.out.println(f1.getMaxPracticalCourse());
		System.out.println("-----------------------------------------------");
		System.out.println("Thống Kê Danh Sách Sinh Viên Theo Năm Vào Học : ");
		System.out.println(f1.groupStudentsByYear());
		System.out.println("-----------------------------------------------");
		System.out.println("Tìm Các Course Theo Loại Cho Trước : ");
		System.out.println(f1.filterCourses("TH"));
	}
}
