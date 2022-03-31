package it.unibo.paw.dao;

import java.util.List;

public interface CourseDAO {
	public void create(CourseDTO course);

	public CourseDTO read(int code);

	public boolean update(CourseDTO course);

	public boolean delete(int code);
	
	public boolean createTable();

	public boolean dropTable();
	
	public List <CourseDTO> findCoursesByStudentID(int courseID);

}
