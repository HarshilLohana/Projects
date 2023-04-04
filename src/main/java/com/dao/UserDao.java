package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.PassBean;
import com.bean.UserBean;
import com.constants.Role;
import com.util.DBConnection;
public class UserDao {
	
	public void addUser(UserBean userBean) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into users (enrollmentNum,firstName,email,Password,role,approve) values (?,?,?,?,?,?)");
			pstmt.setLong(1,userBean.getEnrollmentNum());
			pstmt.setString(2, userBean.getFirstName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4,userBean.getPassword());
			pstmt.setInt(5,userBean.getRole());
			pstmt.setBoolean(6,userBean.getApprove());
			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<UserBean> getAllStudents(){
		ArrayList<UserBean> students = new ArrayList<UserBean>();
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where role = ?");
			pstmt.setInt(1,Role.STUDENT.role);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setEnrollmentNum(rs.getInt("enrollmentNum"));
				user.setApprove(rs.getBoolean("approve"));
				students.add(user);
			}
			System.out.println(students.size());
			return students;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
		
	public void changeStudentStatus(Integer enrollmentNum, Boolean currentStatus) {
		try {
			System.out.println(enrollmentNum + " " + currentStatus);
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set approve = ? where enrollmentNum = ? ");
			pstmt.setBoolean(1, !currentStatus);
			pstmt.setLong(2, enrollmentNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public UserBean authenticate(String email,String password){
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ? and approve = 1");
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				UserBean user = new UserBean();
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setEnrollmentNum(rs.getInt("enrollmentNum"));
				user.setApprove(rs.getBoolean("approve"));
				user.setRole(rs.getInt("role"));
				return user;
			}
			else {
				return null;
			}		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public UserBean getMyData(int enrollmentNum) {
		UserBean userBean = new UserBean();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where enrollmentNum = ?");
			pstmt.setLong(1, enrollmentNum);

			ResultSet rs = pstmt.executeQuery();// select --> read

			while(rs.next()) {
		
				userBean.setEnrollmentNum( rs.getInt("enrollmentNum"));
				userBean.setFirstName(rs.getString("firstName"));
				userBean.setEmail(rs.getString("email"));
				userBean.setApprove(rs.getBoolean("approve"));
				
			}

			return userBean;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
	}
	
	public void insertMyOtp(UserBean userBean){
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set otp = ? where email = ? ");
			pstmt.setString(1,userBean.getOtp());
			pstmt.setString(2, userBean.getEmail());
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void removeUser(int enrollmentNum){
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from users where enrollmentNum = ? ");
			pstmt.setLong(1,enrollmentNum);
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
