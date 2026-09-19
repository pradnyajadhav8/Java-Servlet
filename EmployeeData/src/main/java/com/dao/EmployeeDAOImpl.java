package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.utility.DBUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int addEmployee(Employee employee) {
		String str = "insert into employee (id,name,salary)values(?,?,?)";

		int res = 0;

		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(str);) {

			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());

			res = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}

	@Override
	public int deleteEmployee(int id) {
		String str = "delete from  employee where id=?";

		int res = 0;
		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(str);) {

			ps.setInt(1, id);
			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String str = "update employee set name=?,salary=? where id=?";

		int res = 0;
		try (Connection con = DBUtility.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(str);) {

			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setInt(3, employee.getId());

			res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Employee> allEmployee() {
		List<Employee> list=new ArrayList<Employee>();
		String str="select * from employee";
		Employee emp=null;
		
		try(Connection con=DBUtility.getInstance().getConnection(); PreparedStatement ps=con.prepareStatement(str);){
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				list.add(emp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

