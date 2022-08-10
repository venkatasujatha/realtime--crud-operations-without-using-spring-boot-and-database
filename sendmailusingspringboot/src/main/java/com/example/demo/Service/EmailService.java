package com.example.demo.Service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Mail1;

@Service
public class EmailService implements EmailService1{

	@Autowired
	JavaMailSender mailSender;

	public String sendMail() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("sujatha.valluru@tectoro.com");
		mailMessage.setTo("valluru.1sujatha@gmail.com");
		mailMessage.setSubject("Hi");
		mailMessage.setText("i am sending test mail");

		mailSender.send(mailMessage);

		return "mail sent successfully" ;
	}

	public String sendMailWithAttachment() {
		try
		{
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, true);
		messageHelper.setFrom("sujatha.valluru@tectoro.com");
		messageHelper.setTo("valluru.1sujatha@gmail.com");
		messageHelper.setText("i am sending test mail");
		messageHelper.setSubject("Hi");
		File file=new File("/home/tectoro/Downloads/laptop.jpg");
		messageHelper.addAttachment(file.getName(), file);
		mailSender.send(mimeMessage);
		
		return "mail send successfully";
		}
		catch (Exception e) {
			return "mail send failed";
		}
	}

	
	
	
	
	public Object sendEmailWithoutattachments(Mail1 mail1) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(mail1.getFrom());
		mailMessage.setTo(mail1.getTo());
		mailMessage.setCc(mail1.getCc());
		
		mailMessage.setSubject(mail1.getSubject());
		mailMessage.setText(mail1.getTextbody());
		mailSender.send(mailMessage);
		
		return "mail send successfully";
	}

	public Object sendEmailWithAttachments(Mail1 mail1) {
		
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
			
			messageHelper.setFrom(mail1.getFrom());
			messageHelper.setTo(mail1.getTo());
			messageHelper.setCc(mail1.getCc());
			messageHelper.setSubject(mail1.getSubject());
			messageHelper.setText(mail1.getTextbody());
			File file=new File("/home/tectoro/Downloads/laptop.jpg");
			messageHelper.addAttachment(file.getName(), file);
			
			mailSender.send(mimeMessage);
			return "mail send successfully";
			
		} catch (MessagingException e) {
			
			return "mail send failed";
		}
		
		
		
	}

}
