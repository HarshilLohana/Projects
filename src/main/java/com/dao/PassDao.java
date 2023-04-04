package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.PassBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class PassDao {

	public void addPassRequest(PassBean pass) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("insert into pass (enrollmentNum,reason,outtime,approve,passDate) values (?,?,?,?,?)");
			pstmt.setInt(1, pass.getEnrollmentNum());
			pstmt.setString(2, pass.getReason());
			pstmt.setString(3, pass.getOutTime());
			pstmt.setInt(4, pass.getApprove());
			pstmt.setString(5, pass.getPassDate());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<PassBean> getMyList(int enrollmentNum){
		ArrayList<PassBean> pastRequest =  new ArrayList<PassBean>();
		try {
			
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass where enrollmentNum = ? order by passId desc");
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
				pastRequest.add(pb);
			}
			return pastRequest;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setNewDetailsForPass(long enrollmentNum,long newEnrollmentNum) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set enrollmentNum=? where enrollmentNum = ? ");
			pstmt.setLong(1, newEnrollmentNum);
			pstmt.setLong(2, enrollmentNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}