package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.model.Account;

public interface AccountDao {
	
	public Account login(String username, String password);
//	public Account getAccountById(int id);
//	public Account getAccountById(int id, Connection con);
//	public int createAccount(Account account);
//	public int updateAccount(Account account);
//	public int deleteAccountById(int id);

}
