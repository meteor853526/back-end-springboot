package com.example.demo2.user;

import com.example.demo2.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT s FROM User s WHERE s.email = ?1 and s.passwd = ?2 and s.type = ?3")
  Optional<User> findUserByEmail(String email , String passwd,String type);
}
