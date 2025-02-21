package capgemini.courseRepo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSignUpEmail(String toEmail, String subject, String courseName) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("isabellauni2002@gmail.com");
		message.setTo(toEmail);
		message.setText("A new attendee has signed up to your " + courseName + " course!");
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("Mail sent....!");
	}
	
	public void sendRegIntEmail(String toEmail, String subject, String courseName) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("isabellauni2002@gmail.com");
		message.setTo(toEmail);
		message.setText("A new attendee has registered interest in your " + courseName + " course!");
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("Mail sent....!");
	}
	
	public void sendApprovalEmail(String toEmail, String subject, String courseName, String employeeEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("isabellauni2002@gmail.com");
		message.setTo(toEmail);
		message.setText(employeeEmail + " requires your approval for the " + courseName + " course! Please respond to them with your approval.");
		message.setSubject(subject);
		
		System.out.println(toEmail+ subject+ courseName + employeeEmail);
		System.out.println(message);
		
		mailSender.send(message);
		
		System.out.println("Mail sent....!");
	}
}
