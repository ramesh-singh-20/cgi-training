package com.cgi.dao;

import com.cgi.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailDAO {
    private static List<String> emails;

    static {
        emails= new ArrayList<>();
        Contact c1= new Contact("abc@gmail.com");
        Contact c2= new Contact("def@gmail.com");
        Contact c3= new Contact("xyz@gmail.com");

        emails.add(c1.getEmail());
        emails.add(c2.getEmail());
        emails.add(c3.getEmail());
    }


    public List<String> getEmails(){
        //In real- world applications this list will be fetched from database.
        return emails;
    }
}
