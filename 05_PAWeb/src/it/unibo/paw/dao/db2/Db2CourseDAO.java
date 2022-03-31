package it.unibo.paw.dao.db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(INSERT);
			 statement.setInt(1, course.getId());
			 statement.setString(1, course.getCourseName());
			statement.execute();
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
		
		
	}
	@Override
	public CourseDTO read(int code) {
		
		CourseDTO result=null;
		ResultSet  r=null;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(READ_BY_ID);
			 statement.setInt(1, code);
			 if(statement.execute()) {
				
				r=statement.getResultSet();
				if(r!=null) {
					
					result=new CourseDTO();
					result.setCourseName(r.getString(2));
					result.setId(r.getInt(1));
				}
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
	public boolean update(CourseDTO course) {
		boolean result=false;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(UPDATE);
			 statement.setString(1, course.getCourseName());
			 statement.setInt(2,course.getId());
			if(statement.execute()) {
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
	public boolean delete(int code) {
		boolean result=false;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(DELETE);
			 statement.setInt(1, code);
			 
			if(statement.execute()) {
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
