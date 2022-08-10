package com.example.demo.Controller;



import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Mail1;
import com.example.demo.Service.EmailService;

@RestController
public class mailController {
	
	@Autowired
	private EmailService emailService;
	
	private static final org.apache.log4j.Logger LOGGER=org.apache.log4j.Logger.getLogger(mailController.class);
	
	@GetMapping("/sendmailwithout")
	@Scheduled(cron="0 0 */1 * * *")
	public String sendMail()
	{
		//PropertyConfigurator configure(System.getProperty("user.dir"+File.separator+"log4j.properties"));
		LOGGER.debug("this is debug message");
		return emailService.sendMail();
	}
	
	@Scheduled(fixedRateString = "PT01H",initialDelay = 10000)
	@GetMapping("/sendmailwithattachment")
	public String sendMailWithAttachment()
	{
		return emailService.sendMailWithAttachment();
	}
	
	
	
	
	
	@Scheduled(cron="*/1 * * * * *")
	@PostMapping("/save")
	public Object sendEmailWithoutattachments(@RequestBody Mail1 mail1)
	{
		
		return emailService.sendEmailWithoutattachments(mail1);
	}
	
	@Scheduled(fixedRateString = "PT01S")
	@PostMapping("/save1")
	public String sendEmailWithAttachments(@RequestBody Mail1 mail1)
	{
		emailService.sendEmailWithAttachments(mail1);
		return "mail";
	}
}
