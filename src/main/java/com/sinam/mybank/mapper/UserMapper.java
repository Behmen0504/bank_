package com.sinam.mybank.mapper;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import com.sinam.mybank.dao.entity.TransactionEntity;
import com.sinam.mybank.dao.entity.UserEntity;
import com.sinam.mybank.model.BankAccountDTO;
import com.sinam.mybank.model.TransactionDTO;
import com.sinam.mybank.model.UserDTO;
import com.sinam.mybank.model.auth.UserRegisterRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserEntity mapUserRequestDtoToEntity(UserRegisterRequestDto userRegisterRequestDto);
    public UserEntity createUserEntity(Long id) {
        if(id == null) return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        return userEntity;
    }

    @Mapping(source = "bankAccountEntityList",target = "bankAccountDTOList" )
    public abstract UserDTO mapUserEntityToUserDto(UserEntity userEntity);

    public abstract List<BankAccountDTO> mapEntitiesToDtos(List<BankAccountEntity> bankAccountEntities);
}
