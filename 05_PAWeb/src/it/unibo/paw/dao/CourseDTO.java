package it.unibo.paw.dao;

import java.util.ArrayList;
import java.util.List;

public class CourseDTO {
	private int id;
	private String courseName;
	private List<StudentDTO> students;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<StudentDTO> getStudents() {
		return students;
	}
	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}
	public CourseDTO() {
		this.students=new ArrayList<StudentDTO>();
	}

}
