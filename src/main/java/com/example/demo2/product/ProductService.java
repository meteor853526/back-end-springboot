package com.example.demo2.product;

import com.example.demo2.student.Student;
import com.example.demo2.student.StudentRepository;
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
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getProduct() {
    return productRepository.findAll();
  }

  public List<Product> getOwner(String owner) {
    return productRepository.findOwnerPD(owner);
  }

  public String getProductname(int id) {
    return productRepository.findByID(id);
  }

  public void  saveProductToDB( String name, int price,String category,String type,int number,String introduce,String owner,MultipartFile file)
  {
    Product p = new Product();
    System.out.println(file.toString());
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    System.out.println(file.getContentType());
    System.out.println(fileName);
    if(fileName.contains(".."))
    {
      System.out.println("not a a valid file");
    }
    try {
      p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
      //byte[] imageDate = file.getBytes();
      //System.out.print(imageDate.toString());
      //p.setImage(imageDate);

      //System.out.println(file.getContentType());
      //System.out.println(Base64.getEncoder().encodeToString(file.getBytes()));
    } catch (IOException e) {
      e.printStackTrace();
    }

    //System.out.println(p.getImage());
    p.setIntroduce(introduce);
    p.setCategory(category);
    p.setType(type);
    p.setNumber(number);
    p.setName(name);
    p.setPrice(price);
    p.setOwner(owner);
    productRepository.save(p);
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
