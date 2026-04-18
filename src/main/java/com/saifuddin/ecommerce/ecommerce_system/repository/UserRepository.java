package com.saifuddin.ecommerce.ecommerce_system.repository;

import com.saifuddin.ecommerce.ecommerce_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail (String  email);
}
