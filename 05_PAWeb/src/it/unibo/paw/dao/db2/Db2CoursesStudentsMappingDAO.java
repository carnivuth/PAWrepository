package it.unibo.paw.dao.db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unibo.paw.dao.CoursesStudentsMappingDAO;
import it.unibo.paw.dao.CoursesStudentsMappingDTO;

public class Db2CoursesStudentsMappingDAO implements CoursesStudentsMappingDAO{
	

	public static final String TABLE="coursesstudentmapping";
	public static final String ID_COURSE="idcourse";
	public static final String ID_STUDENT="idstudent";
	
	//stringhe per la creazione di tabelle
		private static final String CREATE= "CREATE " +
				"TABLE " + TABLE + " ( " +
				ID_COURSE + " INT NOT NULL , " +
				ID_STUDENT + " INT NOT NULL"
						+ "constraint pk PRIMARY KEY( "+ID_COURSE+" , "+ID_STUDENT+" )" +
				") ";
		
		private static final String DROP = "DROP " +
				"TABLE " + TABLE + " ";	
		
	//stringhe per la manipolazione delle tuple
		
		//inserimento tupla
		private static final String INSERT = "INSERT " +
				"INTO " + TABLE + " ( " +
				ID_COURSE + ", " + ID_STUDENT +  " " +
				") " +
				"VALUES (?,?) ";

		// lettura per id studente
		private static final String READ_BY_ID_STUDENT = "SELECT * " +
				"FROM " + TABLE + " " +
				"WHERE " + ID_STUDENT + " = ? ";
		
		// lettura per id corso
		private static final String READ_BY_ID_COURSE = "SELECT * " +
				"FROM " + TABLE + " " +
				"WHERE " + ID_COURSE + " = ? ";


		

		// DELETE FROM table WHERE idcolumn = ?;
		private static final String DELETE = "DELETE " +
				"FROM " + TABLE + " " +
				"WHERE " + ID_STUDENT + " = ? "
						+ "AND "+ ID_COURSE + " = ? ";

		
	@Override
	public void create(CoursesStudentsMappingDTO map) {
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(INSERT);
			 statement.setInt(1, map.getCourseId());
			 statement.setInt(1, map.getStudentId());
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
	public List<CoursesStudentsMappingDTO>read_by_id_student(int code) {
		List<CoursesStudentsMappingDTO> result=null;
		ResultSet  r=null;
		CoursesStudentsMappingDTO element=null;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(READ_BY_ID_STUDENT);
			 statement.setInt(1, code);
			 if(statement.execute()) {
				
				r=statement.getResultSet();
				if(r!=null) {
					
					result=new ArrayList<CoursesStudentsMappingDTO>();
					element=new CoursesStudentsMappingDTO();
					element.setCourseId(r.getInt(ID_COURSE));
					element.setStudentId(r.getInt(ID_STUDENT));
					result.add(element);
				}
				while(r.next()) {
					element=new CoursesStudentsMappingDTO();
					element.setCourseId(r.getInt(ID_COURSE));
					element.setStudentId(r.getInt(ID_STUDENT));
					result.add(element);
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
	public List<CoursesStudentsMappingDTO> read_by_id_course(int code) {
		List<CoursesStudentsMappingDTO> result=null;
		ResultSet  r=null;
		CoursesStudentsMappingDTO element=null;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(READ_BY_ID_COURSE);
			 statement.setInt(1, code);
			 if(statement.execute()) {
				
				r=statement.getResultSet();
				if(r!=null) {
					
					result=new ArrayList<CoursesStudentsMappingDTO>();
					element=new CoursesStudentsMappingDTO();
					element.setCourseId(r.getInt(ID_COURSE));
					element.setStudentId(r.getInt(ID_STUDENT));
					result.add(element);
					
				}
				while(r.next()) {
					element=new CoursesStudentsMappingDTO();
					element.setCourseId(r.getInt(ID_COURSE));
					element.setStudentId(r.getInt(ID_STUDENT));
					result.add(element);
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

}
