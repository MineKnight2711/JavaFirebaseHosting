package com.example.javabackend.modules.user.repository;

import com.example.javabackend.entity.AccountType;
import com.example.javabackend.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountTypeRepository extends JpaRepository<AccountType, Long> {
    @Query("SELECT u FROM AccountType u where u.AccountTypeID = ?1")
    AccountType findByAccountTypeId(Long accountTypeId);
}
