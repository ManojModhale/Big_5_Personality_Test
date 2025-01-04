package com.app.demo.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.bean.Test;
import com.app.demo.bean.User;
import com.app.demo.bean.UserResponses;
import com.app.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService service;
	
	@PostMapping("/newuser")
	public void register(@RequestBody User user)
	{
		System.out.println("from form : "+user);
		service.registerUser(user);
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestParam String username, @RequestParam String password)
	{
		System.out.println(" :"+username+" : "+password);
		return service.authenticateUser(username, password);
	}
	
	@PostMapping("/forgotpass")
	public int forgotPassword(@RequestParam String username, @RequestParam String email)
	{
		System.out.println(username+"  "+email);
		return service.getByEmail(username, email);
	}
	
	@PostMapping("/changepass")
	public boolean changePassword(@RequestParam String username,@RequestParam String password)
	{
		boolean success=service.changePass(username, password);
		
		 if (success) 
		 {
			 return true;
	            //return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
	     } 
		 else 
		 {
			 return false;
	            //return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	     }
	}
	
	@GetMapping("/profile/{username}")
	public User userProfile(@PathVariable String username)
	{
		User userProfile=service.findUserProfile(username);
		return userProfile;
	}
	
	@PutMapping("/updateprofile/{username}")
	public void updateProfile(@PathVariable String username, @RequestBody User updatedProfile)
	{		
	        //System.out.println("Username: " + username);
	        //System.out.println("Updated Profile: " + updatedProfile);

	     service.updateUserProfile(username, updatedProfile);
	}
	
	 @PostMapping("/submitAnswer")
	 public ResponseEntity<String> submitResponses(@RequestBody UserResponses userResponses) 
	 {
	        
	        String username = userResponses.getUsername();
	        String startTime = userResponses.getStartTime();
	     
	        Instant startTimeInstant = Instant.parse(startTime);
	        Date startExamTimeDate = Date.from(startTimeInstant);
	        List<UserResponses.ResponseEntry> responses = userResponses.getUserResponses();
	        
	        /*System.out.println(userResponses);
	        System.out.println("Username: " + username);
	        System.out.println("Exam Start Time: " + startExamTimeDate);
	        System.out.println("User Responses: " + responses);*/
	        System.out.println("Answers has been submitted calculation will start..");
	        service.calculatePoints(username,startExamTimeDate,responses);

	     
	     return ResponseEntity.ok("Successfully received and processed user responses!");
	 }
	 
	 @GetMapping("/getAllTests/{username}")
	 public List<Test> getTestsByUsername(@PathVariable String username) 
	 {
	        List<Test> userTests = service.getTestsByUsername(username);
	        for (Test test : userTests) {
	        	System.out.println("all Tests : "+userTests);
			}
	        
	        return userTests;
	  }

}
