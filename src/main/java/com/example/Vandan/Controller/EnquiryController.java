package com.example.Vandan.Controller;

import com.example.Vandan.model.Enquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnquiryController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/enquiry")
    public String showForm(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        return "enquiry";
    }

    @PostMapping("/enquiry")
    public String submitForm(@ModelAttribute Enquiry enquiry, Model model) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("jay60436@gmail.com");
        message.setSubject("New Enquiry from " + enquiry.getName());
        message.setText("Name: " + enquiry.getName() +
                "\nContact: " + enquiry.getContact() +
                "\nQuery: " + enquiry.getQuery());
        mailSender.send(message);

        model.addAttribute("message", "Your enquiry has been sent successfully!");
        return "enquiry";
    }
}
