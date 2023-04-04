package com.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	public void sendOtpForForgetPassword(String email,String otp) {

        final String username = "harshillohana20@gmail.com";
        final String password = "arlbnhfkpetmzvih";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        session.setDebug(true);
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("OTP For Update Details");
			message.setContent("Please use this OTP for Update Details.... ==> " + otp, "text/html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	public void sendMessageForApplyPass(long enrollmentNum,String firstName,String reason,int approve) {

        final String username = "harshillohana20@gmail.com";
        final String password = "arlbnhfkpetmzvih";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        session.setDebug(true);
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("harshillohana20@gmail.com")
            );
            message.setSubject("Request For Gate Pass");
            if(reason!=null) {
			message.setContent("Respect Sir/Maam <br> FirstName: " + firstName + "<br>EnrollmentNum: " + enrollmentNum + "<br>Reason: " + reason + "<br>"
					+ "<a href='http://localhost:9898/eGatePassProject/ViewHodPendingRequest/ChangePassStatus?enrollmentNum="+enrollmentNum+"&currentStatus=1' Accept</a><br>"
							+ "<a href='http://localhost:9898/eGatePassProject/ViewHodPendingRequest/ChangePassStatus?enrollmentNum="+enrollmentNum+"&currentStatus=-1' Reject</a>","text/html");
            }
			Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
