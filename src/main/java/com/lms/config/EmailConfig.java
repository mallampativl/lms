package com.lms.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class EmailConfig {
	
	
	 @Bean
	    public JavaMailSender getJavaMailSender() 
	    {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.ipage.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("vijaya@infomericainc.in");
	        mailSender.setPassword("Vijaya123");
	          
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "false");
	        props.put("mail.debug", "true");
	        return mailSender;
	    }
	     
	    @Bean
	    public SimpleMailMessage emailTemplate()
	    {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("jsandeep@infomericainc.in");
	        message.setFrom("vijaya@infomericainc.in");
	        message.setText("oVeraction".concat("").concat(""));
	        message.setSubject("Leave Information");
	        return message;
	    }

}
