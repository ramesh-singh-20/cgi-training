package com.cgi.service;

import com.cgi.dao.EmailDAO;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final EmailDAO emailDAO;

    public EmailService(){
        emailDAO= new EmailDAO();
    }

    public void sendEmail(){
        emailDAO.getEmails().stream().forEach(email -> System.out.println("Email sent to: "+email));

    }
}
