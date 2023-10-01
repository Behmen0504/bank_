package com.sinam.mybank.mapper;

import com.sinam.mybank.dao.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public UserEntity createUserEntity(Long id) {
        if(id == null) return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        return userEntity;
    }
}
