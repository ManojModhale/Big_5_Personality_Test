package com.app.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.demo.bean.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> 
{
	/*
	@Query("from User u where u.username= :username AND u.password = :password")
	public User findByUsernameAndPassword(@Param(value = "username") String username,@Param(value = "password") String password);
	*/

	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsernameAndEmail(String username, String email);

	public User findByUsername(String username);
}
