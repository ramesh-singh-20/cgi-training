package com.cgi.service;

import com.cgi.dao.EmailDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class EmailService {
    private final EmailDAO emailDAO;

    @Inject
    public EmailService(EmailDAO emailDAO){
        this.emailDAO= emailDAO;
    }

    public void sendEmail(){
        emailDAO.getEmails().stream().forEach(email -> System.out.println("Email sent to: "+email));

    }
}
