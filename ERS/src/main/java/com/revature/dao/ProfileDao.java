package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.model.Profile;

public interface ProfileDao {
	
//	public List<Profile> getDepartments();
	public Profile getProfileById(int id);
	public Profile getProfileById(int id, Connection con);
//	public int createDepartment(Profile department);
//	public int updateDepartment(Profile department);
//	public int deleteDepartmentById(int id);
//	public void increaseBudget(int deptId, float increaseAmount);
	public int updateProfile(Profile profile);
	public List<Profile> getProfiles();

}
