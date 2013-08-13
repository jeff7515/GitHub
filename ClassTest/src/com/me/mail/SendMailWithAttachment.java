package com.me.mail;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMailWithAttachment {

	public static void main(String[] args) {

//		String to = "hsieh.y@husky.neu.edu";
		String to = "training@mercurysystemsinc.com";
		String from = "jeff.7515.tw@gmail.com";
		String filename = "/Users/jeffhsieh/Desktop/status_20130613.doc";
		String msgText1 = "";
		String subject = "Status report of Jeff Hsieh from Java Mail";

		// create some properties and get the default Session

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties prop = System.getProperties();
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		prop.setProperty("mail.smtp.socketFactory.fallback", "false");
		prop.setProperty("mail.smtp.port", "465");
		prop.setProperty("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jeff.7515.tw",
						"19870715Gmail");
			}
		});

		try {
			// create a message
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);

			// create and fill the first message part
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(msgText1);

			// create the second message part
			MimeBodyPart mbp2 = new MimeBodyPart();
			

			// attach the file to the message
			FileDataSource fds = new FileDataSource(filename);
			mbp2.setDataHandler(new DataHandler(fds));
			mbp2.setFileName(fds.getName());

			// create the Multipart and add its parts to it
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);

			// add the Multipart to the message
			msg.setContent(mp);

			// set the Date: header
			msg.setSentDate(new Date());

			// send the message
			Transport.send(msg);

		} catch (MessagingException mex) {
			mex.printStackTrace();
			Exception ex = null;
			if ((ex = mex.getNextException()) != null) {
				ex.printStackTrace();
			}
		}
	}
}