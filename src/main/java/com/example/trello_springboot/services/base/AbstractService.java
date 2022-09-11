package com.example.trello_springboot.services.base;

import com.example.trello_springboot.mappers.GenericMapper;
import com.example.trello_springboot.repositories.GenericRepository;
import com.example.trello_springboot.utils.BaseUtils;
import lombok.RequiredArgsConstructor;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:14 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@RequiredArgsConstructor
public abstract class AbstractService<R extends GenericRepository, M extends GenericMapper> {
    protected final R repository;
    protected final M mapper;
    protected final BaseUtils utils;
}
