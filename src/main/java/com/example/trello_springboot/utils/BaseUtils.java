package com.example.trello_springboot.utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author "Tojaliyev Asliddin"
 * @since 11/09/22 14:37 (Sunday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class BaseUtils {

    public String generateActivationToken(@NonNull Long id) {
        return generateActivationToken(String.valueOf(id));
    }

    public String generateActivationToken(@NonNull String text) {
        return UUID.randomUUID().toString();
    }
}
