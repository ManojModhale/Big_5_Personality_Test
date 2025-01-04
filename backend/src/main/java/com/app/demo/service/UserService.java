package com.app.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.demo.bean.Test;
import com.app.demo.bean.User;
import com.app.demo.bean.UserResponses.ResponseEntry;

public interface UserService 
{
	public User authenticateUser(String username ,String password);
	
	public void registerUser(User user);
	
	public int getByEmail(String username ,String email);
	
	public boolean changePass(String username, String password);
	
	public User findUserProfile(String username);
	
	public void updateUserProfile(String username,User updatedProfile);

	public void calculatePoints(String username, Date startExamTimeDate, List<ResponseEntry> responses);
	
	public List<Test> getTestsByUsername(String username);
}
