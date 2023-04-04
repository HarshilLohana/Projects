package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.PassBean;
import com.bean.UserBean;
import com.constants.Role;
import com.util.DBConnection;

public class StudentDao {

	public ArrayList<PassBean> getAllMyRequest(int enrollmentNum) {
		ArrayList<PassBean> pastRequest = new ArrayList<PassBean>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass where enrollmentNum = ? order by passId desc ");
			pstmt.setLong(1, enrollmentNum);

			ResultSet rs = pstmt.executeQuery();// select --> read

			while(rs.next()) {
				PassBean pass = new PassBean();
				
				pass.setEnrollmentNum( rs.getInt("enrollmentNum"));
				pass.setApprove(rs.getInt("approve"));
				pass.setOutTime(rs.getString("outtime"));
				pass.setPassDate(rs.getString("passDate"));
				pass.setPassId(rs.getInt("passId"));
				pass.setReason(rs.getString("reason"));
				
				pastRequest.add(pass);
			}
			
			return pastRequest;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pastRequest;
	}
	
	

	public ArrayList<PassBean> getAllMyRequestByStatus(int enrollmentNum,int statusId) {
		ArrayList<PassBean> pastRequest = new ArrayList<PassBean>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass where enrollmentNum = ? and approve = ? order by passId desc ");
			pstmt.setInt(1, enrollmentNum);
			pstmt.setInt(2, statusId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				PassBean pass = new PassBean();
				
				pass.setEnrollmentNum( rs.getInt("enrollmentNum"));
				pass.setApprove(rs.getInt("approve"));
				pass.setOutTime(rs.getString("outtime"));
				pass.setPassDate(rs.getString("passDate"));
				pass.setPassId(rs.getInt("passId"));
				pass.setReason(rs.getString("reason"));
				
				pastRequest.add(pass);
			}
			
			return pastRequest;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pastRequest;
	}

	public Boolean otpVerification(String otp,int enrollmentNum) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select otp from users where enrollmentNum = ?");
			pstmt.setInt(1,enrollmentNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(otp.equals(rs.getString("otp"))){
					return true;
				}else {
					return false;
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public void setNewPassword(String password,long enrollmentNum) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set password = ? where enrollmentNum = ? ");
			pstmt.setString(1, password);
			pstmt.setLong(2, enrollmentNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setNewPassword(long enrollmentNum,String password) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set password=? where enrollmentNum = ? ");
			pstmt.setString(1, password);
			pstmt.setLong(2, enrollmentNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setNewPhoneNumber(long enrollmentNum,int phoneNumber) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set phonenumber=? where enrollmentNum = ? ");
			pstmt.setInt(1, phoneNumber);
			pstmt.setLong(2, enrollmentNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
