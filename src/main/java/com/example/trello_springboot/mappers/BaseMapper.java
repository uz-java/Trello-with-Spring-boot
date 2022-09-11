package com.example.trello_springboot.mappers;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:08 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface BaseMapper<E, D, CD, UD> extends GenericMapper {
    E fromDto(D dto);

    E fromCreateDto(CD dto);

    E fromUpdateDto(UD dto);

    D toDto(E domain);

    List<D> toDto(List<E> domains);
}
