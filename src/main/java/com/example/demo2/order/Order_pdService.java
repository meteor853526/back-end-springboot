package com.example.demo2.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class Order_pdService {
  private final Order_pdRepository orderRepository ;

  @Autowired
  public Order_pdService(Order_pdRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order_pd> getOrder(String owner) {
    return orderRepository.findOrder_pd(owner);
  }

  public List<Order_pd> getBuyerOrder(String buyer) {
    return orderRepository.findBuyerOrder_pd(buyer);
  }

  public void  saveOrderToDB(String fname, String lname, int phone, String address, String type, String pay_type, String time, int productid, int number)
  {
    Order_pd p = new Order_pd();
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
//    p.setIntroduce(introduce);
//    p.setCategory(category);
//    p.setType(type);
//    p.setNumber(number);
//    p.setName(name);
//    p.setPrice(price);

    orderRepository.save(p);
  }



  public void addNewOrder(Order_pd order) {

    orderRepository.save(order);
  }

  public void deleteOrder(Long studentId) {
    boolean exists = orderRepository.existsById(studentId);
    if(!exists) {
      throw new IllegalStateException("student with id"+ studentId + "does not exist");
    }
    orderRepository.deleteById(studentId);

  }

  public void deletShop_Car(int Id) {


  }
  @Transactional
  public void updateOrder(int id) {
    orderRepository.updateState(id);
  }

  @Transactional
  public void updatepdOrder(int id) {
    orderRepository.updatebuyState(id);
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
