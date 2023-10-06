package com.sinam.mybank.mapper;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import com.sinam.mybank.dao.entity.UserEntity;
import com.sinam.mybank.model.BankAccountDTO;
import com.sinam.mybank.model.requests.BankAccountRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public abstract class BankAccountMapper {
    public static final BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    public abstract BankAccountDTO mapEntityToDto(BankAccountEntity bankAccountEntity);

    public abstract BankAccountEntity mapBankAccountRequestDtoToEntity(BankAccountRequestDTO bankAccountRequest);

    public abstract BankAccountRequestDTO mapBankAccountDtoToRequestDto(BankAccountDTO bankAccountDTO);

    public abstract List<BankAccountDTO> mapEntitiesToDtos(List<BankAccountEntity> bankAccountEntities);
}
