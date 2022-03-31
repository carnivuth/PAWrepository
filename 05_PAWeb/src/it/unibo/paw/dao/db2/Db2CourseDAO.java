package it.unibo.paw.dao.db2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



import it.unibo.paw.dao.CourseDAO;
import it.unibo.paw.dao.CourseDTO;

public class Db2CourseDAO implements CourseDAO {
	
	public static final String TABLE="courses";
	public static final String ID="id";
	public static final String COURSE_NAME="coursename";
	
	private static final String INSERT = "INSERT " +
			"INTO " + TABLE + " ( " +
			ID + ", " + COURSE_NAME +  " " +
			") " +
			"VALUES (?,?) ";

	// SELECT * FROM table WHERE idcolumn = ?;
	private static final String READ_BY_ID = "SELECT * " +
			"FROM " + TABLE + " " +
			"WHERE " + ID + " = ? ";

	// SELECT * FROM table WHERE stringcolumn = ?;
	private static final String READ_ALL = "SELECT * " +
			"FROM " + TABLE + " ";

	

	// DELETE FROM table WHERE idcolumn = ?;
	private static final String DELETE = "DELETE " +
			"FROM " + TABLE + " " +
			"WHERE " + ID + " = ? ";

	// UPDATE table SET xxxcolumn = ?, ... WHERE idcolumn = ?;
	private static final String UPDATE = "UPDATE " + TABLE + " " +
			"SET " +
			COURSE_NAME + " = ?, " +
			"WHERE " + ID + " = ? ";

	
	//stringhe per la creazione di tabelle
	public static final String CREATE= "CREATE " +
			"TABLE " + TABLE + " ( " +
			ID + " INT NOT NULL PRIMARY KEY, " +
			COURSE_NAME + " VARCHAR(50)" +
			") ";
	
	private static final String DROP = "DROP " +
			"TABLE " + TABLE + " ";	
	
	private static final String FIND_COURSES_BY_STUDENT_ID="";
	
	
	@Override
	public void create(CourseDTO course) {
		
		
	}
	@Override
	public CourseDTO read(int code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean update(CourseDTO course) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(int code) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean createTable() {
		boolean result=false;
		Statement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.createStatement();
			if(statement.execute(CREATE)) {
				result=true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	@Override
	public boolean dropTable() {
		boolean result=false;
		Statement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.createStatement();
			if(statement.execute(DROP)) {
				result=true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	@Override
	public List<CourseDTO> findCoursesByStudentID(int courseID) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
