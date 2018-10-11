package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Profile;
import com.revature.util.ConnectionUtil;

public class ProfileDaoImpl implements ProfileDao {

	private static Logger log = Logger.getRootLogger();
	
//	@Override
//	public List<Profile> getDepartments() {
//		List<Profile> departments = new ArrayList<>();
//		
//		String sql = "SELECT * FROM DEPARTMENT";
//		
//		try (Connection con = ConnectionUtil.getConnection();
//				Statement s = con.createStatement();
//				ResultSet rs = s.executeQuery(sql)){
//			
//			while (rs.next()) {
//				int deptId = rs.getInt("DEPT_ID");
//				String name = rs.getString("DEPT_NAME");
//				float budget = rs.getFloat("MONTHLY_BUDGET");
//				departments.add(new Profile(deptId, name, budget));
//			}
//			
//			
//		} catch (SQLException|IOException e) {
//			log.error(e.getMessage());
//		} 
//		
//		return departments;
//	}
	
	@Override
	public List<Profile> getProfiles() {
		Profile p = null;
		List<Profile> profileList = new ArrayList<>();
		String sql = "SELECT * FROM PROFILE";

		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)
				){

			while (rs.next()) {
				int id = rs.getInt("ID");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				int zipcode = rs.getInt("ZIPCODE");
				long phone = rs.getLong("PHONE");
				String hireDate = rs.getString("HIREDATE");
				String birthDate = rs.getString("BIRTHDATE");
				String email = rs.getString("EMAIL");
				p = new Profile(id, fname, lname, street, city, state, zipcode, phone, hireDate, birthDate, email);
				
				profileList.add(p);
			}
		} catch (IOException|SQLException e) {
			log.error(e.getMessage());
		}

		return profileList;
	}

	@Override
	public Profile getProfileById(int id) {
		Profile p = null;
		String sql = "SELECT * FROM PROFILE WHERE ID = ?";

		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){

			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				int zipcode = rs.getInt("ZIPCODE");
				long phone = rs.getLong("PHONE");
				String hireDate = rs.getString("HIREDATE");
				String birthDate = rs.getString("BIRTHDATE");
				String email = rs.getString("EMAIL");
				p = new Profile(id, fname, lname, street, city, state, zipcode, phone, hireDate, birthDate, email);
			}
		} catch (IOException|SQLException e) {
			log.error(e.getMessage());
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
			}
		}

		return p;
	}

	public Profile getProfileById(int id, Connection con) {
		Profile p = null;
		String sql = "SELECT * FROM PROFILE WHERE ID = ?";

		ResultSet rs = null;

		try (PreparedStatement ps = con.prepareStatement(sql);){

			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				int zipcode = rs.getInt("ZIPCODE");
				int phone = rs.getInt("PHONE");
				String hireDate = rs.getString("HIREDATE");
				String birthDate = rs.getString("BIRTHDATE");
				String email = rs.getString("EMAIL");
				p = new Profile(id, fname, lname, street, city, state, zipcode, phone, hireDate, birthDate, email);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
			}
		}

		return p;
	}

//	@Override
//	public int createDepartment(Profile department) {
//		int departmentsCreated = 0;
//		String sql = "INSERT INTO DEPARTMENT (DEPT_NAME, MONTHLY_BUDGET) VALUES (?,?)";
//		
//		try (Connection con = ConnectionUtil.getConnection();
//				PreparedStatement ps = con.prepareStatement(sql)){
//			
//			ps.setString(1, department.getName());
//			ps.setFloat(2, department.getMonthlyBudget());
//			departmentsCreated = ps.executeUpdate();
//			
//		} catch (SQLException|IOException e) {
//			log.error(e.getMessage());
//		} 
//		return departmentsCreated;
//	}
//
	@Override
	public int updateProfile(Profile profile) {
		int profilesUpdated = 0;
		
		String sql = "UPDATE PROFILE "
				+ "SET FNAME = ?,"
				+ "LNAME = ?,"
				+ "STREET = ?,"
				+ "CITY = ?,"
				+ "STATE = ?,"
				+ "ZIPCODE = ?,"
				+ "PHONE = ?,"
				+ "HIREDATE = ?,"
				+ "BIRTHDATE = ?,"
				+ "EMAIL = ?"
				+ "WHERE ID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			con.setAutoCommit(false);
			
			ps.setString(1, profile.getFname());
			ps.setString(2, profile.getLname());
			ps.setString(3, profile.getStreet());
			ps.setString(4, profile.getCity());
			ps.setString(5, profile.getState());
			ps.setInt(6, profile.getZipcode());
			ps.setLong(7, profile.getPhone());
			ps.setString(8, profile.getHireDate());
			ps.setString(9, profile.getBirthDate());
			ps.setString(10, profile.getEmail());
			ps.setInt(11, profile.getId());
			

			profilesUpdated = ps.executeUpdate();
			con.commit();
			
		} catch (SQLException|IOException e) {
			log.error(e.getMessage());
		} 
		
		return profilesUpdated;
	}
//
//	@Override
//	public int deleteDepartmentById(int id) {
//		int rowsDeleted = 0;
//		
//		String sql = "DELETE FROM DEPARTMENT WHERE DEPT_ID = ?";
//		
//		try (Connection con = ConnectionUtil.getConnection();
//				PreparedStatement ps = con.prepareStatement(sql)){
//			
//			ps.setInt(1, id);
//			rowsDeleted = ps.executeUpdate();
//			
//		} catch (SQLException|IOException e) {
//			log.error(e.getMessage());
//		}
//		
//		return rowsDeleted;
//	}
//
//	@Override
//	public void increaseBudget(int deptId, float increaseAmount) {
//		
//		String sql = "{call INCREASE_BUDGET(?,?)}";
//		
//		try( Connection con = ConnectionUtil.getConnection();
//				CallableStatement cs = con.prepareCall(sql)){
//			
//			cs.setInt(1, deptId);
//			cs.setFloat(2, increaseAmount);
//			cs.execute();
//			log.info("raise given");
//		} catch (SQLException|IOException e) {
//			log.error(e.getMessage());
//		} 
//	}

}
