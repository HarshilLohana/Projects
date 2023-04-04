package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.PassBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class HodDao {
	
	public ArrayList<PassBean> getAllRequest() {
		ArrayList<PassBean> pastRequest = new ArrayList<PassBean>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass order by passId desc");

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				PassBean pass = new PassBean();
				
				pass.setEnrollmentNum( rs.getInt("enrollmentNum"));
				pass.setApprove(rs.getInt("approve"));
				pass.setOutTime(rs.getString("outtime"));
				pass.setPassDate(rs.getString("passDate"));
				pass.setPassId(rs.getInt("passId"));
				pass.setReason(rs.getString("reason"));
				pass.setVerify(rs.getInt("verify"));
				
				pastRequest.add(pass);
			}
			
			return pastRequest;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pastRequest;
	}
	
	public ArrayList<PassBean> getAllRequestByStatus(int statusId) {
		ArrayList<PassBean> pastRequest = new ArrayList<PassBean>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass where approve = ? order by passId desc ");
			pstmt.setInt(1, statusId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				PassBean pass = new PassBean();
				
				pass.setEnrollmentNum( rs.getInt("enrollmentNum"));
				pass.setOutTime(rs.getString("outtime"));
				pass.setPassDate(rs.getString("passDate"));
				pass.setPassId(rs.getInt("passId"));
				pass.setReason(rs.getString("reason"));
				pass.setApprove(rs.getInt("approve"));
				pass.setVerify(rs.getInt("verify"));
				
				pastRequest.add(pass);
			}
			
			return pastRequest;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pastRequest;
	}
	
	
	public void changePassStatus(int passId, int currentStatus) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update pass set approve = ? where passId = ? ");
			pstmt.setInt(1, currentStatus);
			pstmt.setInt(2, passId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PassBean> getAllRequest(long enrollmentNum){
		ArrayList<PassBean> pastRequest =  new ArrayList<PassBean>();
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass order by passId desc");
			pstmt.setLong(1,enrollmentNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PassBean pb = new PassBean();
				pb.setPassId(rs.getInt("passId"));
				pb.setEnrollmentNum(rs.getInt("enrollmentNum"));
				pb.setReason(rs.getString("reason"));
				pb.setApprove(rs.getInt("approve"));
				pb.setOutTime(rs.getString("outTime"));
				pb.setPassDate(rs.getString("passDate"));
				pb.setVerify(rs.getInt("verify"));
				pastRequest.add(pb);
			}
			return pastRequest;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
