package com.example.trello_springboot.services.base;

import com.example.trello_springboot.dtos.Dto;
import com.example.trello_springboot.dtos.GenericDto;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:24 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface GenericService<ID extends Serializable, CD extends Dto, UD extends GenericDto> extends BaseService {
    ID create(@NonNull CD dto);

    void delete(@NonNull ID id);

    void update(@NonNull UD dto);
}
