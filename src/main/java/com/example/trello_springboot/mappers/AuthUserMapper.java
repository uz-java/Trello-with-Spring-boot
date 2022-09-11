package com.example.trello_springboot.mappers;

import com.example.trello_springboot.domains.auth.AuthUser;
import com.example.trello_springboot.dtos.user.AuthUSerDTO;
import com.example.trello_springboot.dtos.user.AuthUserCreateDTO;
import com.example.trello_springboot.dtos.user.AuthUserUpdateDTO;
import org.mapstruct.Mapper;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:07 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<AuthUser, AuthUSerDTO, AuthUserCreateDTO, AuthUserUpdateDTO> {

}
