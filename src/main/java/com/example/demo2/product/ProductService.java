package com.example.demo2.product;

import com.example.demo2.student.Student;
import com.example.demo2.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getProduct() {
    return productRepository.findAll();
  }

  public void addNewProduct(Product product) {
//    Optional<Product> productOptional = productRepository.findStudentByEmail(product.getEmail());
//    if (productOptional.isPresent()) {
//      throw new IllegalStateException("email taken");
//
//    }
    productRepository.save(product);
  }

  public void deleteProduct(Long studentId) {
    boolean exists = productRepository.existsById(studentId);
    if(!exists) {
      throw new IllegalStateException("student with id"+ studentId + "does not exist");
    }
    productRepository.deleteById(studentId);

  }

//  @Transactional
//  public void updateStudent(Long studentId,String name,String email) {
//    Student student = productRepository.findById(studentId).orElseThrow(
//      () -> new IllegalStateException(
//        "Student with id " + studentId + "does not exist"
//      ));
//
//    if(name != null && !Objects.equals(student.getName(), name)
//      && name.length() > 0 ) {
//      student.setName(name);
//    }
//
//    if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)) {
//      Optional<Student> studentOptional = productRepository.findStudentByEmail(email);
//
//      if(studentOptional.isPresent()) {
//        throw new IllegalStateException("email taken");
//      }
//      student.setEmail(email);
//    }
}
