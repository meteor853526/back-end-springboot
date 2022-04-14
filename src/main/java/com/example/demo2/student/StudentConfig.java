package com.example.demo2.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner (StudentRepository studentRepository) {
    return args -> {
      Student Mariam = new Student(
        "Mariam","meteor", LocalDate.of(2000, Month.JANUARY,5),21
      );
      Student Alex = new Student(
        "Alex","meteor", LocalDate.of(2000, Month.JANUARY,5),21
      );
      studentRepository.saveAll(
        List.of(Mariam,Alex)
      );
    };
  }
}
