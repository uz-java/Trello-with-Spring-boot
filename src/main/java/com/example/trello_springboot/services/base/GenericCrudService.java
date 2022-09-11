package com.example.trello_springboot.services.base;

import com.example.trello_springboot.criteria.GenericCriteria;
import com.example.trello_springboot.dtos.Dto;
import com.example.trello_springboot.dtos.GenericDto;

import java.io.Serializable;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:16 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface GenericCrudService<ID extends Serializable,
        D extends GenericDto,CD extends Dto,UD extends GenericDto,C extends GenericCriteria> extends GenericService<ID, CD, UD>, GenericReadService<ID, C, D> {

}
