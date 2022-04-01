package it.unibo.paw.dao;

import java.util.List;

public interface CoursesStudentsMappingDAO {
	public void create(CoursesStudentsMappingDTO course);

	public List<CoursesStudentsMappingDTO> read_by_id_student(int code);
	
	public List<CoursesStudentsMappingDTO> read_by_id_course(int code);

	public boolean delete(int code);
	
	public boolean createTable();

	public boolean dropTable();

}
