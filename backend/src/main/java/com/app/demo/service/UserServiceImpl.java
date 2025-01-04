package com.app.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.demo.bean.Exam;
import com.app.demo.bean.Test;
import com.app.demo.bean.User;
import com.app.demo.bean.UserResponses;
import com.app.demo.bean.UserResponses.ResponseEntry;
import com.app.demo.dao.TestRepo;
import com.app.demo.dao.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	@Autowired
	private TestRepo repo2;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User authenticateUser(String username, String password) {
		// UserDetails userdetails=loadUserByUsername(username);
		// TODO Auto-generated method stub
		// System.out.println("before encoding password : "+password);
		// String password1=passwordEncoder.encode(password);
		// System.out.println("encoded password : "+password1);
		// return repo.findByUsernameAndPassword(username, password1);

		User user = repo.findByUsername(username);
		boolean pass = passwordEncoder.matches(password, user.getPassword());
		System.out.println(" :" + pass+"\n***************************************************************************************");
		if (pass) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
	}

	@Override
	public int getByEmail(String username, String email) {
		// TODO Auto-generated method stub

		User forgotpassUser = repo.findByUsernameAndEmail(username, email);

		if (forgotpassUser != null) {
			int otp = messageBodyforOTP(forgotpassUser.getEmail(), forgotpassUser.getFirstname(),
					forgotpassUser.getLastname());

			return otp;
		} else {
			return 0;
		}

	}

	public boolean changePass(String username, String password) 
	{
		User user1 = repo.findByUsername(username);

		if (user1 != null) {
			user1.setPassword(passwordEncoder.encode(password));
			repo.save(user1);
			return true;
		}

		return false;
	}

	@Override
	public User findUserProfile(String username) {
		// TODO Auto-generated method stub
		User userProfile = repo.findByUsername(username);
		System.out.println("Profile : "+userProfile);
		return userProfile;
	}

	// this is not correctly working
	@Transactional
	public void updateUserProfile(String username, User updatedProfile) {
		User userUpdatedProfile = repo.findByUsername(username);

		if (userUpdatedProfile != null) {
			// Update user profile fields
			userUpdatedProfile.setFirstname(updatedProfile.getFirstname());
			userUpdatedProfile.setLastname(updatedProfile.getLastname());
			userUpdatedProfile.setEmail(updatedProfile.getEmail());
			userUpdatedProfile.setMobileno(updatedProfile.getMobileno());
			userUpdatedProfile.setQualification(updatedProfile.getQualification());
			userUpdatedProfile.setDesignation(updatedProfile.getDesignation());

			System.out.println("Updated Profile Before Database: " + userUpdatedProfile);
			repo.save(userUpdatedProfile);
		}
	}

	@Override
	public void calculatePoints(String username, Date startExamTimeDate, List<ResponseEntry> responses) {
		Exam exam = new Exam();
		// TODO Auto-generated method stub
		for (ResponseEntry responseEntry : responses) {
			if (responseEntry.getQuestionType().equals("positive")) {
				int selectedAnswer = 0;
				if (responseEntry.getSelectedOption().equals("Strongly Agree")) {
					selectedAnswer = 5;
				} else {
					selectedAnswer = Integer.parseInt(responseEntry.getSelectedOption());
				}

				switch (responseEntry.getPersonalityTrait()) {
				case "Openness": {
					exam.setOpenness(exam.getOpenness() + selectedAnswer);
					break;
				}
				case "Conscientiousness": {
					exam.setConscientiousness(exam.getConscientiousness() + selectedAnswer);
					break;
				}
				case "Extraversion": {
					exam.setExtraversion(exam.getExtraversion() + selectedAnswer);
					break;
				}
				case "Agreeableness": {
					exam.setAgreeableness(exam.getAgreeableness() + selectedAnswer);
					break;
				}
				case "Neuroticism": {
					exam.setNeuroticism(exam.getNeuroticism() + selectedAnswer);
					break;
				}
				default: {
					System.out.println("no personality traits");
				}
				}
			} else {
				int selectedAnswer = 0;
				if (responseEntry.getSelectedOption().equals("Strongly Agree")) {
					selectedAnswer = 1;
				} else {
					selectedAnswer = Integer.parseInt(responseEntry.getSelectedOption());
				}
				switch (responseEntry.getPersonalityTrait()) {
				case "Openness": {
					exam.setOpenness(exam.getOpenness() + selectedAnswer);
					break;
				}
				case "Conscientiousness": {
					exam.setConscientiousness(exam.getConscientiousness() + selectedAnswer);
					break;
				}
				case "Extraversion": {
					exam.setExtraversion(exam.getExtraversion() + selectedAnswer);
					break;
				}
				case "Agreeableness": {
					exam.setAgreeableness(exam.getAgreeableness() + selectedAnswer);
					break;
				}
				case "Neuroticism": {
					exam.setNeuroticism(exam.getNeuroticism() + selectedAnswer);
					break;
				}
				default: {
					System.out.println("no personality traits");
				}
				}
			}

		}

		// System.out.println("All Points ::
		// "+exam.getOpenness()+"\t"+exam.getConscientiousness()+"\t"
		// +exam.getExtraversion()+"\t"+exam.getAgreeableness()+"\t"+exam.getNeuroticism());

		Test test = new Test(null, username, startExamTimeDate, exam.getOpenness(), exam.getConscientiousness(),
				exam.getExtraversion(), exam.getAgreeableness(), exam.getNeuroticism());
		
		User testUser=repo.findByUsername(username);
		repo2.save(test);
		messageBodyforReport(testUser.getEmail(), testUser.getFirstname(), testUser.getLastname(),exam.getOpenness(),exam.getConscientiousness(),exam.getExtraversion(),exam.getAgreeableness(),exam.getNeuroticism());
		//repo2.save(test);
	}


	private static void messageBodyforReport(String recipient, String firstname, String lastname,int openness, int conscientiousness, int extraversion, int agreeableness, int neuroticism) 
	{
		System.out.println("Inside Message Body");
		 String opennessMessage = "";
		 String conscientiousnessMessage = "";
		 String extraversionMessage = "";
		 String agreeablenessMessage = "";
		 String neuroticismMessage = "";
		// Openness (Intellect or Imagination)
        if (openness > 15) {
            opennessMessage = "Highly Creative: You have a strong imagination and are open to new experiences.";
        } else if (openness > 9 && openness <= 15) {
            opennessMessage = "Moderately Creative: You enjoy a balance between routine and novelty.";
        } else {
            opennessMessage = "Less Creative: You may prefer familiarity and routine.";
        }
        
     // Conscientiousness
        if (conscientiousness > 15) {
           conscientiousnessMessage = "Highly Conscientious: You are reliable, organized, and responsible.";
        } else if (conscientiousness > 9 && conscientiousness <= 15) {
            conscientiousnessMessage = "Moderately Conscientious: You have a good balance between orderliness and spontaneity.";
        } else {
            conscientiousnessMessage = "Less Conscientious: You may prefer flexibility over structure.";
        }
        
        // Extraversion
        if (extraversion > 15) {
            extraversionMessage = "Extroverted: You thrive in social settings and enjoy being around people.";
        } else if (extraversion > 9 && extraversion <= 15) {
            extraversionMessage = "Ambivert: Comfortable in both social and solitary settings.";
        } else {
            extraversionMessage = "Introverted: Prefers more solitary activities and quiet moments.";
        }
        
     // Agreeableness
        if (agreeableness > 15) {
            agreeablenessMessage = "Highly Agreeable: You are very cooperative and easy to get along with.";
        } else if (agreeableness > 9 && agreeableness <= 15) {
            agreeablenessMessage = "Moderately Agreeable: You strike a balance between assertiveness and cooperativeness.";
        } else {
            agreeablenessMessage = "Less Agreeable: You may prioritize your own needs over the needs of others.";
        }
        

        // Neuroticism 
        if (neuroticism > 15) {
            neuroticismMessage = "Highly Stable: You tend to remain calm and emotionally resilient.";
        } else if (neuroticism > 9 && neuroticism <= 15) {
            neuroticismMessage = "Moderately Stable: You experience some emotional ups and downs.";
        } else {
            neuroticismMessage = "Less Stable: You may be more prone to stress and anxiety.";
        }

		
		
		System.out.println("Preparing to send message!..");

		 String subject = "Big Five Personality Test Result";
		String to = recipient;
		String from = "arkhambatman08@gmail.com";


		
		
		String body = "Dear " + firstname + " " + lastname + ",\n\n"
		            + "Thank you for completing the Big Five Personality Test. We are excited to share your personality scores with you. Here are your results:\n\n"
		            + "- **Openness:** " + openness + "\n"
		            + "  " + opennessMessage + "\n\n"
		            + "- **Conscientiousness:** " +conscientiousness + "\n"
		            + "  " + conscientiousnessMessage + "\n\n"
		            + "- **Extraversion:** " + extraversion + "\n"
		            + "  " + extraversionMessage + "\n\n"
		            + "- **Agreeableness:** " + agreeableness + "\n"
		            + "  " + agreeablenessMessage + "\n\n"
		            + "- **Neuroticism:** " + neuroticism + "\n"
		            + "  " + neuroticismMessage + "\n\n"
		            + "Additionally, here's your Total Score:\n"
		            + "- **Total Score:** " + (openness+conscientiousness+extraversion+agreeableness+neuroticism) + "\n\n\n"
		            + " Well done on completing the Big Five Personality Test! Your results offer insights into your personality, and now you have the power to shape it further. "
		            		+ "Want to boost your extraversion? Attend social events or try new activities. Seeking more conscientiousness? Create a daily routine. Remember, it's about progress, not perfection."
		            		+ " Embrace positive changes, and enjoy the journey of self-improvement!"+ "\n\n"
		            +"Remember, personal growth is a continuous journey. If you'd like to enhance certain aspects of your personality, consider setting small, achievable goals. \n"
		            + "Embrace new experiences, practice kindness, and nurture meaningful connections. Every step you take contributes to your unique path of self-improvement. Cheers to becoming the best version of yourself!\n\n\n"

		            + "These scores provide insights into various aspects of your personality. If you have any questions or would like to discuss your results further, feel free to reach out.\n\n"
		            + "Thank you for using the Big Five Personality Test. We appreciate your participation.\n\n"
		            + "Best Regards,\n"
		            + "-Developement Team-\n"
		            + "Big Five Personality Test";

		sendReport(body, subject, to, from);	
	}
	

	private static void sendReport(String message, String subject, String to, String from) {
	    // New Gmail host
	    String host = "smtp.gmail.com";

	    // System properties
	    Properties properties = System.getProperties();
	    System.out.println("Properties: " + properties);

	    properties.put("mail.smtp.host", host);
	    properties.put("mail.smtp.port", "465");
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	    Session session = Session.getDefaultInstance(properties, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("arkhambatman08@gmail.com", "zpwy bunu fqfz pdmf");
	        }
	    });

	    session.setDebug(true);

	    MimeMessage mimeMessage = new MimeMessage(session);

	    try {
	        mimeMessage.setFrom(new InternetAddress(from));
	        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        mimeMessage.setSubject(subject);
	        mimeMessage.setText(message);

	        Transport.send(mimeMessage);
	        System.out.println("Email sent successfully!");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	
	
	
	

	@Override
	public List<Test> getTestsByUsername(String username) {
		// TODO Auto-generated method stub
		return repo2.findByUsername(username);
	}

	private static int messageBodyforOTP(String recipient, String firstname, String lastname) {
		System.out.println("Preparing to send message!..");

		String subject = "Password Reset OTP - Big Five Personality Test";
		String to = recipient;
		String from = "arkhambatman08@gmail.com";

		// Generate OTP
		int otpLength = 6;
		int generatedOTP = generateOTP(otpLength);
		System.out.println("Generated OTP : " + generatedOTP);

		// Create email body with OTP
		String body = "Dear " + firstname + " " + lastname + ",\n\n"
				+ "You have requested to reset your password for your 'Big Five Personality Test' account. Please use the following One-Time Password (OTP) to complete the password reset process:\n\n"
				+ "OTP: " + generatedOTP + "\n\n"
				+ "This OTP is valid for a limited time. Please do not share this OTP with anyone. If you did not initiate this password reset, please disregard this email.\n\n"
				+ "Thank you for using Big Five Personality Test.\n\n" + "Best Regards,";

		sendEmailforOTP(body, subject, to, from);

		return generatedOTP;
	}

	private static int generateOTP(int length) {
		String allowedChars = "0123456789";
		StringBuilder otp = new StringBuilder(length);
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(allowedChars.length());
			otp.append(allowedChars.charAt(index));
		}

		// Convert the OTP string to an integer
		return Integer.parseInt(otp.toString());
	}

	private static void sendEmailforOTP(String message, String subject, String to, String from) {
		// New Gmail host
		String host = "smtp.gmail.com";

		// System properties
		Properties properties = System.getProperties();
		System.out.println("Properties : " + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("arkhambatman08@gmail.com", "zpwy bunu fqfz pdmf");
			}
		});

		session.setDebug(true);

		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);

			Transport.send(mimeMessage);
			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
