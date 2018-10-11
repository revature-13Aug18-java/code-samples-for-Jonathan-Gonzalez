package com.revature.dao;

import java.util.List;

import com.revature.model.Receipt;

public interface ReceiptDao {

	public List<Receipt> getReceiptsById(int id);
	public List<Receipt> getReceipts();
//	public Receipt getReceiptById(int id, int rid);
//	public int createEmployee(Account employee);
//	public int updateEmployee(Account employee);
//	public int deleteEmployeeById(int id);
	public int createReceipt(Receipt receipt);
	public void resolveReceiptByRid(int rid, String outcome, String resolvedBy);
	
}
