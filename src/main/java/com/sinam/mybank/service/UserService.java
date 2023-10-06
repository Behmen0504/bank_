package com.sinam.mybank.service;

import com.sinam.mybank.dao.entity.UserEntity;
import com.sinam.mybank.dao.repository.UserRepository;
import com.sinam.mybank.mapper.UserMapper;
import com.sinam.mybank.model.UserDTO;
import com.sinam.mybank.service.auth.AuthService;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUser() {
        UserEntity userEntity = userRepository.findById(AuthService.getUser().getId()).get();
        return UserMapper.INSTANCE.mapUserEntityToUserDto(userEntity);
    }




}
