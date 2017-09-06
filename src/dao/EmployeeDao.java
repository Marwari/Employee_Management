package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Employee;
import config.MyConnection;

public class EmployeeDao {
	Connection con=MyConnection.getConnection();
	public String addEmployee(Employee e)
	{
		try {
			PreparedStatement ps=
					con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getJoin());
			ps.setString(4, e.getDesig());
			ps.setString(5, e.getDept());
			ps.setString(6, e.getBsalary());
			int a=ps.executeUpdate();
			ResultSet rs= ps.executeQuery("Select MAX(EmpNo) from employee");
			rs.next();
			int empno=rs.getInt(1);
			PreparedStatement ps2=
					con.prepareStatement("insert into employee_personal_info(?,?,?,?,?,?,?,?)");
					ps2.setInt(1, empno);
					ps2.setString(2, e.getDob());
					ps2.setString(3, e.getQual());
					ps2.setString(4, e.getAdd1());
					ps2.setString(5, e.getAdd2());
					ps2.setString(6, e.getCity());
					ps2.setString(7, e.getPin());
					ps2.setString(8, e.getPhone());
					int b= ps.executeUpdate();
					if(a>0 && b>0)
						return "Employee Added";
					else
						return "Employee not added";
									
			
					
			
		} catch(SQLException e1){
			e1.printStackTrace();
		}
		return "Error";
	}

}
