package com.bigfive.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	
	private static Mail instance = new Mail();
	
	private Session session;
	
	public Mail() {
		System.out.println("Creando Mail");
		final String username = "mail@gmail.com";
        final String password = "ctow qgwt vmqj daie";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        this.setSession(Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
        }));
    }
	
	/**
	 * 
	 * 
	 * 
	 */
	public static void sendMail(String to, String subject ,String msg) {
		 try {
	            Message message = new MimeMessage(instance.getSession());
	            message.setFrom(new InternetAddress("zcratx98@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            message.setSubject(subject);
	    
	            MimeBodyPart mimeBodyPart = new MimeBodyPart();
	            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
	    
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(mimeBodyPart);
	    
	            message.setContent(multipart);
	    
	            Transport.send(message);
	            
	            System.out.println("Email Sended");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	}

	public Session getSession() {
		return session;
		
	}

	public void setSession(Session session) {
		this.session = session;
		
	}
	
}
