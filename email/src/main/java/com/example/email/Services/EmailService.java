package com.example.email.Services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper (mimeMessage, false, "utf-8");
        mimeMessage.setContent("Vous vous ete parfaitement inscrit", "text/html");
        helper.setTo(to);
        helper.setSubject("inscription");

        javaMailSender.send(mimeMessage);
    }
}
