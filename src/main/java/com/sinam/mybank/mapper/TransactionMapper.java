package com.sinam.mybank.mapper;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import com.sinam.mybank.dao.entity.TransactionEntity;
import com.sinam.mybank.model.TransactionDTO;
import com.sinam.mybank.model.requests.TransactionRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public abstract class TransactionMapper {
    public static final TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


    @Mappings({
            @Mapping(source = "transactionEntity.senderAccountEntity.id",target = "senderAccountId"),
            @Mapping(source = "transactionEntity.receiverAccountEntity.id",target = "receiverAccountId")
    })
    public abstract TransactionDTO mapEntityToDto(TransactionEntity transactionEntity);

    @Mappings({
            @Mapping(source = "transactionRequestDTO.senderAccountId",target = "senderAccountEntity", qualifiedByName = "createBankAccountEntity"),
            @Mapping(source = "transactionRequestDTO.receiverAccountId",target = "receiverAccountEntity", qualifiedByName = "createBankAccountEntity")
    })
    public abstract TransactionEntity mapTransactionRequestDtoToEntity(TransactionRequestDTO transactionRequestDTO);

    public abstract List<TransactionDTO> mapEntitiesToDtos(List<TransactionEntity> transactionEntities);
    public BankAccountEntity createBankAccountEntity(Long id) {
        if(id == null) return null;
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setId(id);
        return bankAccountEntity;
    }
}
