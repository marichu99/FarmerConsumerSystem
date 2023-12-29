package com.servlet.mail.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.servlet.mail.model.Mail;

@Stateless
@Remote
public class MailBean implements MailBeanI,Serializable {
    // TODO Auto-generated method stub
    private final int port = 465;
    private final String host = "smtp.gmail.com";
    private final String from = System.getProperty("FROM");
    private final boolean auth = true;
    private final Session session;
    private final String password = System.getProperty("PASSWORD");
    private final String username = System.getProperty("USERNAME");
    private final boolean debug = true;

    @Override
    public void sendEmail(Mail mail) {
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = { new InternetAddress(mail.getRecipient()) };
            InternetAddress[] replyToEmail = { new InternetAddress(from) };

            message.setRecipients(Message.RecipientType.TO, address);
            message.setReplyTo(replyToEmail);
            message.setSubject(mail.getSubject());
            message.setSentDate(new Date());
            message.setContent(mail.getMessage(), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }

    public MailBean() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", auth);

        props.put("mail.smtp.ssl.enable", true);

        this.session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        session.setDebug(debug);

    }

}
