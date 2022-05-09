package com.example.demo2.product;

import com.example.demo2.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product,Long>{
  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Product> findStudentByEmail(String email);

  @Query(value = "select * from book b where b.name=?1", nativeQuery = true )
  Optional<Product> findByID(String name);

}
