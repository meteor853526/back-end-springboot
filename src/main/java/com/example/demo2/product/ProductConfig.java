package com.example.demo2.product;
import com.example.demo2.student.Student;
import com.example.demo2.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ProductConfig {

  @Bean
  CommandLineRunner commandLineRunner (ProductRepository productRepository) {
    return args -> {
//      Student Mariam = new Student(
//        "Mariam","meteor", LocalDate.of(2000, Month.JANUARY,5),21
//      );
//      Student Alex = new Student(
//        "Alex","meteor", LocalDate.of(2000, Month.JANUARY,5),21
//      );
      productRepository.saveAll(
        List.of()
      );
    };
  }
}
