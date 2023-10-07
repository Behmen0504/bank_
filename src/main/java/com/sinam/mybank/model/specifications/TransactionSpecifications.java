package com.sinam.mybank.model.specifications;

import com.sinam.mybank.dao.entity.TransactionEntity;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class TransactionSpecifications {
    public static Specification<TransactionEntity> hasTransactionId(Long transactionId) {
        return (root, query, criteriaBuilder) -> {
            if (transactionId != null) {
                return criteriaBuilder.equal(root.get("id"), transactionId);
            }
            return null;
        };
    }

    public static Specification<TransactionEntity> hasSenderAccountId(Long senderAccountId) {
        return (root, query, criteriaBuilder) -> {
            if (senderAccountId != null) {
                return criteriaBuilder.equal(root.get("senderAccountEntity").get("id"), senderAccountId);
            }
            return null;
        };
    }

    public static Specification<TransactionEntity> hasUserFin(String userFin) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.isEmpty(userFin)) {
                return criteriaBuilder.equal(root.get("senderAccountEntity").get("userEntity").get("fin"), userFin);
            }
            return null;
        };
    }
}
