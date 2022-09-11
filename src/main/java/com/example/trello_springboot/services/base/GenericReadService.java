package com.example.trello_springboot.services.base;

import com.example.trello_springboot.criteria.GenericCriteria;
import com.example.trello_springboot.dtos.GenericDto;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:19 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface GenericReadService<ID extends Serializable, C extends GenericCriteria, D extends GenericDto> extends BaseService {
    List<D> getAll(@NonNull C criteria);

    D get(@NonNull ID id);
}
