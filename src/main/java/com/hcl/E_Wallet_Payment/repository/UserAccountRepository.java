package com.hcl.E_Wallet_Payment.repository;
import com.hcl.E_Wallet_Payment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String emailId);

    boolean existsByEmail(String username);
}

