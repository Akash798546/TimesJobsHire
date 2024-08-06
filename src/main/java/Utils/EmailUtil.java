package Utils;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.Properties;

public class EmailUtil {
//    public static void sendEmail(String subject, String body) {
//        String to = "recipient@example.com";
//        String from = "sender@example.com";
//        final String username = "your-email-username"; // replace with your Gmail username
//        final String password = "your-email-password"; // replace with your Gmail password
//
//        String host = "smtp.gmail.com";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//          });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.setRecipients(Message.RecipientType.TO,
//                InternetAddress.parse(to));
//            message.setSubject(subject);
//            message.setText(body);
//
//            Transport.send(message);
//
//            System.out.println("Email sent successfully!");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
	
	
	
	public static void main(String[] args) throws EmailException
	{
		sendEmail();
	}
//    }

	public static void sendEmail() throws EmailException {
		Email email=new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("stghiretest@gmail.com","akash@1234"));
		email.setSSLOnConnect(true);
		email.setFrom("stghiretest@gmail.com");
		email.setSubject("Hire Daily Sanity Status Report");
		email.setMsg("Hi, Please find the daily sanity report in attachment");
		email.addTo("timesjoblive@gmail.com");
		email.send();
	}
}
