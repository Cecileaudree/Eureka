package com.example.email.Controller;

import com.example.email.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;

@RestController
@RequestMapping("email")

public class EmailController {

    private final EmailService emailService;

    private RestTemplate restTemplate;


    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody String email) throws jakarta.mail.MessagingException {
        try {
            emailService.sendEmail(email);
            return "Email sent successfully!";
        } catch (MessagingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
