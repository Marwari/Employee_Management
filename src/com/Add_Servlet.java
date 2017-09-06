package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDao;


public class Add_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		String desig=request.getParameter("desig");
		String dept=request.getParameter("dept");
		String bsalary=request.getParameter("bsalary");
		String qual=request.getParameter("qual");
		String add1=request.getParameter("add1");
		String add2=request.getParameter("add2");
		String city=request.getParameter("city");
		String pin=request.getParameter("pin");
		String phone=request.getParameter("phone");
		EmployeeDao edao=new EmployeeDao();
		Employee e=new Employee();
		e.setFname(fname);
		e.setLname(lname);
		e.setDob(dob);
		e.setDesig(desig);
		e.setDept(dept);
		e.setBsalary(bsalary);
		e.setQual(qual);
		e.setAdd1(add1);
		e.setAdd2(add2);
		e.setCity(city);
		e.setPin(pin);
		e.setPhone(phone);
	
		String result=edao.addEmployee(e);
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Success</h1><hr>");
		pw.println("</body>");
		pw.println("<footer>"+result+"<footer></html>");
		
		}
		
	

}
