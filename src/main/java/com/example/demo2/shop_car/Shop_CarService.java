package com.example.demo2.shop_car;

import com.example.demo2.student.Student;
import com.example.demo2.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Shop_CarService {
  private final Shop_CarRepository shop_CarRepository;

  @Autowired
  public Shop_CarService(Shop_CarRepository shop_CarRepository) {
    this.shop_CarRepository = shop_CarRepository;
  }

  public List<Shop_Car> getShop_Car() {
    return shop_CarRepository.findAll();
  }

  public void addNewShop_Car(String email,int productid,String productName,int price, int number) {
    Shop_Car shop_Car = new Shop_Car();
    shop_Car.setEmail(email);
    shop_Car.setProductid(productid);
    shop_Car.setProductName(productName);
    shop_Car.setPrice(price);
    shop_Car.setNumber(number);
    shop_CarRepository.save(shop_Car);
  }


  public List<Shop_Car> ListShop_Car(String email) {

    System.out.println(shop_CarRepository.findShop_CarByEmail(email));

    return shop_CarRepository.findShop_CarByEmail(email);
//    return shop_CarRepository.findShop_CarByEmail(email);


  }
  @Transactional
  public void updateAddCar(int id) {
    shop_CarRepository.addnumCar(id);
  }
  @Transactional
  public void updateCutCar(int id) {
    shop_CarRepository.cutnumCar(id);
  }

  public void deleteShop_Car(int Id) {
    shop_CarRepository.deleteCar(Id);
  }

//  @Transactional
//  public void updateStudent(Long studentId,String name,String email) {
//    Student student = studentRepository.findById(studentId).orElseThrow(
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
//      Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
//
//      if(studentOptional.isPresent()) {
//        throw new IllegalStateException("email taken");
//      }
//      student.setEmail(email);
//    }
//
//
//  }
}
