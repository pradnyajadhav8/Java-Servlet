package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.Student;
import com.utility.DBUtility;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int addStudent(Student student) {
		String str="insert into student (name,marks) values(?,?)";
		
		try(Connection con=DBUtility.getInstace().getDBConnection();
				PreparedStatement ps=con.prepareStatement(str);){
			
			ps.setString(1, student.getName());
			ps.setDouble(2, student.getMarks());
			
			return ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
