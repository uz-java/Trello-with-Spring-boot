package com.example.trello_springboot.services.user;

import com.example.trello_springboot.criteria.AuthUserCriteria;
import com.example.trello_springboot.domains.auth.AuthUser;
import com.example.trello_springboot.dtos.user.AuthUSerDTO;
import com.example.trello_springboot.dtos.user.AuthUserCreateDTO;
import com.example.trello_springboot.dtos.user.AuthUserUpdateDTO;
import com.example.trello_springboot.mappers.AuthUserMapper;
import com.example.trello_springboot.repositories.AuthUserRepository;
import com.example.trello_springboot.services.base.AbstractService;
import com.example.trello_springboot.services.mail.MailService;
import com.example.trello_springboot.utils.BaseUtils;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:34 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Service
public class UserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements UserService {
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;
    private final ServerProperties serverProperties;

    public UserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, BaseUtils utils, MailService mailService, PasswordEncoder passwordEncoder, ServerProperties serverProperties) {
        super(repository, mapper, utils);
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
        this.serverProperties = serverProperties;
    }

    @Override
    public List<AuthUSerDTO> getAll(@NonNull AuthUserCriteria criteria) {
        return null;
    }

    @Override
    public AuthUSerDTO get(@NonNull Long aLong) {
        return null;
    }

    @Override
    public Long create(@NonNull AuthUserCreateDTO dto) {
        AuthUser authUser = mapper.fromCreateDto(dto);
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authUser.setCreatedBy(-1L);
        authUser.setStatus(AuthUser.Status.NOT_ACTIVE);
        repository.save(authUser);
        sendActivationLink(authUser);
        return authUser.getId();
    }

    private void sendActivationLink(AuthUser authUser) {
        serverProperties.getAddress();
        Map<String,Object> models=new HashMap<>();
        models.put("username",authUser.getUsername());
        models.put("activation_link",utils.generateActivationToken(authUser.getId()));
        mailService.sendActivationLink(authUser.getEmail(),models);
    }

    @Override
    public void delete(@NonNull Long aLong) {

    }

    @Override
    public void update(@NonNull AuthUserUpdateDTO dto) {

    }
}
