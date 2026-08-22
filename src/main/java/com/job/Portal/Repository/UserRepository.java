package com.job.Portal.Repository;

import com.job.Portal.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    //Email may or may not exist
    Optional<User> findByEmail(String Email);
}
