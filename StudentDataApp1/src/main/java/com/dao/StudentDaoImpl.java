package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.utility.DBUtility;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int addStudent(Student addstudent) {

		String sql = "insert into student (name,marks,gender) values (?,?,?)";
		Connection con = DBUtility.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, addstudent.getName());
			ps.setDouble(2, addstudent.getMarks());
			ps.setString(3, addstudent.getGender());

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}

		return 0;
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> list = new ArrayList<>();
		String sql = "select * from student";
		Connection con = DBUtility.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getDouble("marks"));
				student.setGender(rs.getString("gender"));
				list.add(student);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
		return list;
	}

	@Override
	public int deleteStudent(int id) {
		String sql = "DELETE FROM STUDENT WHERE id=?";
		Connection con = DBUtility.getDBConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
