package com.example.demo2.user;


import com.example.demo2.product.Product;
import com.example.demo2.product.ProductRepository;
import com.example.demo2.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUser() {
    return userRepository.findAll();
  }

  public void saveUserToDB(String email, String passwd ,String type)
  {
    User p = new User();
//    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//    if(fileName.contains(".."))
//    {
//      System.out.println("not a a valid file");
//    }
//    try {
//      p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    p.setEmail(email);
    p.setPasswd(passwd);
    p.setType(type);
    //p.setImage(image);


    userRepository.save(p);
  }



  public void addUser(User user) {
//    Optional<Product> productOptional = productRepository.findStudentByEmail(product.getEmail());
//    if (productOptional.isPresent()) {
//      throw new IllegalStateException("email taken");
//
//    }


    userRepository.save(user);
  }

  public String userLogin(User user) {
    Optional<User> UserOptional = userRepository.findUserByEmail(user.getEmail(), user.getPasswd(),user.getType());
    System.out.println(user.getEmail()+ user.getPasswd());
    if(!UserOptional.isPresent()) {
      throw new IllegalStateException("user with id"+ user.getEmail() + "does not exist");
    }
    return "no";


  }

  public Optional<User> userCheck(String email,String passwd,String type) {
    return userRepository.findUserByEmail(email,passwd,type);
//    System.out.println(user.getEmail()+ user.getPasswd());
//    if(UserOptional.isPresent()) {
//      throw new IllegalStateException("user with id"+ user.getEmail() + "exist");
//    }
//    return "no";


  }
  public void deleteUser(Long id) {
    boolean exists = userRepository.existsById(id);
    if(!exists) {
      throw new IllegalStateException("student with id"+ id + "does not exist");
    }
    userRepository.deleteById(id);

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
