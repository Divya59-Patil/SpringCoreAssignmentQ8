package com.seleniumexpress.beanlifecycle.annotation;

import java.sql.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDAO {
	String driver;
	String url;
	String uname;
	String pass;
	
	//my connection obj
	Connection con;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		System.out.println("Setting driver.....");
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		System.out.println("Setting url.....");
		this.url = url;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		System.out.println("Setting uname.....");
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		System.out.println("Setting pass.....");
		this.pass = pass;
	}
	
   // @PostConstruct
	public void init()throws ClassNotFoundException, SQLException {
		System.out.println("Student connection call inside the init method");
		createStudentDbConnection();
	}
	
	public void createStudentDbConnection() throws ClassNotFoundException, SQLException {
		System.out.println("CreateStudentDbConnection method..");
		Class.forName(driver);
		con = DriverManager.getConnection(url, uname, pass);
	}

	public void selectAllRow() throws ClassNotFoundException, SQLException {
		System.out.println("Retriving all student data");
		
		//call create connection
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from student");
		while (rs.next()) {
			int student_id = rs.getInt(1);
			String Student_name = rs.getString(2);

			System.out.println(student_id + " " + Student_name);
		}
		
	}

	public void deleteRow(int student_id) throws Exception {
		//call create connection
		Statement st = con.createStatement();
		st.executeUpdate("delete from student where id = " + student_id);
		System.out.println("Record deleted with the id " + student_id);
		
	}
	
	@PreDestroy
	public void closeConnection() throws SQLException {
		//cleaning up unused reference
		con.close();
	}
	
	public void destroy() throws SQLException{
		System.out.println("Connection close inside destroy");
		closeConnection();
	}

}
