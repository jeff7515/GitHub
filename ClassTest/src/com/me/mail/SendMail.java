package com.me.mail;

import java.util.Properties;
import java.util.Date;
import javax.mail.*;                  // Include Authenticator, Message, PasswordAuthentication, Session, Transport
import javax.mail.internet.*;     // Include InternetAddress, MimeMessage

public class SendMail {
    public static void main(String[] args) {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");   
        prop.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);   
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");   
        prop.setProperty("mail.smtp.port", "465");   
        prop.setProperty("mail.smtp.socketFactory.port", "465");   
        prop.put("mail.smtp.auth", "true");   
        final String user = "jeff.7515.tw";
        final String password = "19870715Gmail";
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { 
		return new PasswordAuthentication(user, password); 		} 
            });
        try {		
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("jeff.7515.tw@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("hsieh.y@husky.neu.edu"));
            msg.setSubject("Test from Java Mail"); msg.setSentDate(new Date());
            msg.setText("Hello!");
            Transport.send(msg);
            System.out.println("Message sent successfully!");
        } catch (Exception e) { System.out.println(e); }
    }
}
