package com.ascending.hhhEats.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class SendGridEmailService {
    private SendGrid sg;
    private String friendInvitationTemplateId = "xxx";
    private String eventInvitationTemplateId = "xxx";
    private String registrationTemplateId = "xxx";

    public SendGridEmailService(@Autowired SendGrid sendGrid) {
        this.sg = sendGrid;
    }

    public void sendEmail(String emailJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> emailDetails = mapper.readValue(emailJson, new TypeReference<Map>(){});

        Mail mail = new Mail();
        String subject = emailDetails.get("subject").toString();

        if (subject.equals("Friend Invitation")) {
            mail.setTemplateId(friendInvitationTemplateId);
        } else if (subject.equals("Event Invitation")) {
            mail.setTemplateId(eventInvitationTemplateId);
        } else if (subject.equals("Registration Confirmation")) {
            mail.setTemplateId(registrationTemplateId);
        } else {
            return;
        }

        mail.setFrom(new Email(emailDetails.get("from").toString()));

        Map<String, String> requestInfo = (Map<String, String>) emailDetails.get("request");
        List<String> toEmails = (List<String>) emailDetails.get("to_emails");
        List<String> toUsernames = (List<String>) emailDetails.get("to_usernames");

        Personalization personalization = new Personalization();

        for (String to : toEmails) {
            personalization.addTo(new Email(to));
        }

        personalization.setSubject(subject);
        personalization.addDynamicTemplateData("username", toUsernames.get(0));
        personalization.addDynamicTemplateData("request", requestInfo);
    }
}
