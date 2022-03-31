package it.unibo.paw.dao;

public interface CoursesStudentsMappingDAO {
	public void create(CoursesStudentsMappingDTO course);

	public CoursesStudentsMappingDTO read(int code);

	public boolean update(CoursesStudentsMappingDTO course);

	public boolean delete(int code);
	
	public boolean createTable();

	public boolean dropTable();

}
