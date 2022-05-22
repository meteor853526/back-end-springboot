package com.example.demo2.product;

import com.example.demo2.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.awt.*;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product,Long>{
  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Product> findStudentByEmail(String email);

  @Query(value = "select name from product p where p.id=?1", nativeQuery = true )
  String findByID(int id);

  @Query("SELECT p FROM Product p WHERE p.owner = ?1")
  List<Product> findOwnerPD(String owner);
}
