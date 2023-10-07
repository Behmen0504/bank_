package com.sinam.mybank.model.specifications;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;


public class BankAccountSpecifications {

    public static Specification<BankAccountEntity> hasId(Long bankAccountId) {
        return (root, query, criteriaBuilder) -> {
            if (bankAccountId != null) {
                return criteriaBuilder.equal(root.get("id"), bankAccountId);
            }
            return null;
        };
    }

    public static Specification<BankAccountEntity> hasUserFin(String userFin) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.isEmpty(userFin)) {
                return criteriaBuilder.equal(root.get("userEntity").get("fin"), userFin);
            }
            return null;
        };
    }
}
