package com.danielclark.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Primary
public class StudentDAODBImpl implements StudentDAO {
//	private static final String FILE_NAME = "/WEB-INF/students.csv";
	private static String url = "jdbc:mysql://localhost:3306/studentdb";
	private String user = "studentdb";
	private String pass = "studentdb";

	@Autowired
	private WebApplicationContext wac;
	

	public StudentDAODBImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
	
	@Override
	public void addStudent(Student stud) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO student (first_name, last_name, grade) VALUES (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, stud.getFirstName());
			stmt.setString(2, stud.getLastName());
			stmt.setInt(3, stud.getGrade());
			

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newStudentId = keys.getInt(1);
					stud.setId(newStudentId);
				}
			} else {
				stud = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting student " + sqle);
		}
	}

	@Override
	public void removeStudent(int id) {
		Student stud = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM student WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			//Iterate through resultSet and find student obj by its id
			int updateCount = stmt.executeUpdate();
			System.out.println("Update Count = " + updateCount);

			conn.commit(); // COMMIT TRANSACTION
			conn.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error removing student " + sqle);
		}
	}

	@Override
	public List<Student> getAllStudents() {
		// add students to list from database
		List<Student> studentTempList = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "SELECT id, first_name, last_name, grade FROM student";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			//Iterate through resultSet and add to list
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student stud = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				studentTempList.add(stud);
			}

			conn.commit(); // COMMIT TRANSACTION
			conn.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error retrieving student list " + sqle);
		}
		return studentTempList;
	}


	
	public Student updateStudent(Student stud, String firstName, String lastName, int grade) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE student SET first_name=?, last_name=?, grade=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setInt(3, grade);
			stmt.setInt(4, stud.getId());
			

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newStudentId = keys.getInt(1);
					stud.setId(newStudentId);
				}
			} else {
				stud = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error updating student " + sqle);
		}
		return stud;
	}

	@Override
	public Student getStudentById(int id) {
		Student stud = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "SELECT id, first_name, last_name, grade FROM student WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			//Iterate through resultSet and find student obj by its id
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				stud = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}

			conn.commit(); // COMMIT TRANSACTION
			conn.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error retrieving student by id " + sqle);
		}
		return stud;
	}
	//Exists to satisfy interface. THis method implemented by DAOImpl
	@Override
	public Student updateStudent(Student stud, int id, String firstName, String lastName, int grade) {
		// TODO Auto-generated method stub
		return null;
	}
}