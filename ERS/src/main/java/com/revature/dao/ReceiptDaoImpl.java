package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Profile;
import com.revature.model.Account;
import com.revature.model.Receipt;
import com.revature.util.ConnectionUtil;

public class ReceiptDaoImpl implements ReceiptDao {

	private static Logger log = Logger.getRootLogger();
	
	@Override
	public List<Receipt> getReceiptsById(int id) {
		List<Receipt> receiptList = new ArrayList<>();
		
		String sql = "SELECT * FROM RECEIPT WHERE ID = ?";
		ResultSet rs = null;

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){

			ps.setInt(1, id);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				Receipt r = new Receipt();
				
				r.setId(id);
				
				int rid = rs.getInt("RID");
				r.setRid(rid);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String details = rs.getString("DETAILS");
				r.setDetails(details);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);

				String purchaseDate = rs.getString("PURCHASEDATE");
				r.setPurchaseDate(purchaseDate);
				
				String statusDate = rs.getString("STATUSDATE");
				r.setStatusDate(statusDate);
				
				String resolvedBy = rs.getString("RESOLVEDBY");
				r.setResolvedBy(resolvedBy);
				
				String outcome = rs.getString("OUTCOME");
				r.setOutcome(outcome);
				
				receiptList.add(r);
			}
			
		} catch (IOException|SQLException e) {
			log.error(e.getMessage());
		} 
		
		return receiptList;
	}

	@Override
	public List<Receipt> getReceipts() {
		
		List<Receipt> receiptList = new ArrayList<>();
		String sql = "SELECT * FROM RECEIPT";
		
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)
				){
			
			
			
			while(rs.next()) {
				
				Receipt r = new Receipt();
				
				int id = rs.getInt("ID");
				r.setId(id);
				
				int rid = rs.getInt("RID");
				r.setRid(rid);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String details = rs.getString("DETAILS");
				r.setDetails(details);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);

				String purchaseDate = rs.getString("PURCHASEDATE");
				r.setPurchaseDate(purchaseDate);
				
				String statusDate = rs.getString("STATUSDATE");
				r.setStatusDate(statusDate);
				
				String resolvedBy = rs.getString("RESOLVEDBY");
				r.setResolvedBy(resolvedBy);
				
				String outcome = rs.getString("OUTCOME");
				r.setOutcome(outcome);
				
				receiptList.add(r);
				
			}
			
		} catch (IOException|SQLException ex) {
			log.error(ex.getMessage());
		} 
		
	return receiptList;
	}

	@Override
	public int createReceipt(Receipt receipt) {
		
		String sql = "INSERT INTO RECEIPT (ID, RID, DETAILS, AMOUNT, STATUS, PURCHASEDATE, STATUSDATE)"
				+ " VALUES (?,?,?,?,?,?,?)";
		ResultSet rs = null;
		int receiptsCreated = 0;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)
				){
			con.setAutoCommit(false);
			
			ps.setInt(1, receipt.getId());
			ps.setInt(2, receipt.getRid());
			ps.setString(3, receipt.getDetails());
			ps.setDouble(4, receipt.getAmount());
			ps.setString(5, receipt.getStatus());
			ps.setString(6, receipt.getPurchaseDate());
			ps.setString(7, receipt.getPurchaseDate());
			receiptsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return receiptsCreated;
	}
//
//	@Override
//	public int updateEmployee(Account employee) {
//		return 0;
//	}
//
//	@Override
//	public int deleteEmployeeById(int id) {
//		return 0;
//	}

	@Override
	public void resolveReceiptByRid(int rid, String outcome, String resolvedBy) {
		String sql = "UPDATE RECEIPT SET STATUS = 'RESOLVED', OUTCOME = ?, RESOLVEDBY = ? WHERE RID = ?";

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){

			ps.setString(1, outcome);
			ps.setString(2, resolvedBy);
			ps.setInt(3, rid);
			ps.executeQuery();
		
			
		} catch (IOException|SQLException e) {
			log.error(e.getMessage());
		}
	}

}
