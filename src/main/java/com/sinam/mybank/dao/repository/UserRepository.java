package com.sinam.mybank.dao.repository;

import com.sinam.mybank.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
