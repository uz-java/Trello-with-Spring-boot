package com.example.trello_springboot.controllers;

import com.example.trello_springboot.services.base.BaseService;
import lombok.RequiredArgsConstructor;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:47 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@RequiredArgsConstructor
public abstract class ApiController<S extends BaseService> {
    protected final S service;
    protected final String API="/api";
    protected final String V1="/v1";
}
