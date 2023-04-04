package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.bean.PassBean;
import com.util.DBConnection;

public class SecurityDao {

	
	public ArrayList<PassBean> getAllRequestByStatus() {
		ArrayList<PassBean> pastRequest = new ArrayList<PassBean>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass where passdate=date_format(curdate(),'%d-%b-%Y') and approve=1 and verify=0 order by passId desc ");
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

	public void verifyRequest(int passId) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update pass set verify = 1 where passId = ? ");
			pstmt.setInt(1, passId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
