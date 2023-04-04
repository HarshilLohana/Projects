package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.PassBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class AdminDao {
	
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> allUsers = new ArrayList<UserBean>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users order by enrollmentNum");

			ResultSet rs = pstmt.executeQuery();// select --> read

			while(rs.next()) {
				UserBean user = new UserBean();
				
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setEnrollmentNum(rs.getInt("enrollmentNum"));
				user.setApprove(rs.getBoolean("approve"));
				allUsers.add(user);
				
			}
			
			return allUsers;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allUsers;
	}
	
	public ArrayList<UserBean> getAllUsersByStatus(int status) {
		ArrayList<UserBean> allUsers = new ArrayList<UserBean>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where role = ? order by enrollmentNum");
			pstmt.setInt(1, status);
			ResultSet rs = pstmt.executeQuery();// select --> read

			while(rs.next()) {
				UserBean user = new UserBean();
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setEnrollmentNum(rs.getInt("enrollmentNum"));
				user.setApprove(rs.getBoolean("approve"));
				allUsers.add(user);
				
			}
			
			return allUsers;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allUsers;
	}
	
	
	public void changePassStatus(Integer enrollmentNum, int currentStatus) {
		try {
			System.out.println(enrollmentNum + " " + currentStatus);
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update pass set approve = ? where enrollmentNum = ? ");
			if(currentStatus==0) {
				pstmt.setInt(1, -1);
			}else {
				pstmt.setInt(1, 1);
			}
			
			pstmt.setInt(2, enrollmentNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
