package com.example.trello_springboot.services.user;

import com.example.trello_springboot.criteria.AuthUserCriteria;
import com.example.trello_springboot.dtos.user.AuthUSerDTO;
import com.example.trello_springboot.dtos.user.AuthUserCreateDTO;
import com.example.trello_springboot.dtos.user.AuthUserUpdateDTO;
import com.example.trello_springboot.services.base.GenericCrudService;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:33 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface UserService extends GenericCrudService<
        Long, AuthUSerDTO,
        AuthUserCreateDTO,
        AuthUserUpdateDTO,
        AuthUserCriteria> {
}
