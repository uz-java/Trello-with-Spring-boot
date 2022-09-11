package com.example.trello_springboot.services.mail;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:33 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface MailService {
    void send(String to, String subject, String mailBody) throws MessagingException;

    void sendActivationLink(String to, Map<String,Object> models);
}
