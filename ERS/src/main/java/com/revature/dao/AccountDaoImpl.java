package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	private static Logger log = Logger.getRootLogger();
	
	
//	@Override
//	public Account login(String username, String password) {
//		Account a = null;
//		
//		String sql = "SELECT * FROM ACCOUNT WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password+"'";
//		
//		try (Connection con = ConnectionUtil.getConnection();
//				Statement s = con.createStatement();
//				ResultSet rs = s.executeQuery(sql)){
//			
//			System.out.println(rs.next());
//
//			
//			if(rs.next()) {
//				int id = rs.getInt("ID");
//				System.out.println(id);
//				a = new Account(id, username, password);
//			}
//			
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//		}
//		
//		return a;
//	}

	@Override
	public Account login(String username, String password) {
		Account a = null;
		
		String sql = "SELECT * FROM ACCOUNT WHERE USERNAME = ? AND PASSWORD = ?";
		ResultSet rs = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
						
			con.setAutoCommit(false);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
						
						
			if(rs.next()) {
				int id = rs.getInt("ID");
				int role = rs.getInt("ROLE");
				a = new Account(id, username, password, role);
			}
			
		} catch (SQLException|IOException e) {
			log.error(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				} 
			}
		}
		
		return a;
	}
	
//	@Override
//	public Receipt getLocationById(int id, Connection con) {
//		Receipt l = null;
//		
//		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
//		ResultSet rs = null;
//		
//		try(PreparedStatement ps = con.prepareStatement(sql)){
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				String street = rs.getString("STREET");
//				String city = rs.getString("CITY");
//				String state = rs.getString("STATE");
//				int zipcode = rs.getInt("ZIPCODE");
//				l = new Receipt(id, street, city, state, zipcode);
//			}
//			
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return l;
//	}
//
//	
//	@Override
//	public int createLocation(Receipt location) {
//		return 0;
//	}
//
//	@Override
//	public int updateLocation(Receipt location) {
//		return 0;
//	}
//
//	@Override
//	public int deleteLocationById(int id) {
//		return 0;
//	}

}
