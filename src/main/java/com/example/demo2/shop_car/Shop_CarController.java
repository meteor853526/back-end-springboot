package com.example.demo2.shop_car;


import com.example.demo2.student.Student;
import com.example.demo2.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Shop_Car")
@CrossOrigin("http://localhost:3000/")
public class Shop_CarController {

  private final Shop_CarService shop_CarService;

  @Autowired
  public Shop_CarController(Shop_CarService shop_CarService) {
    this.shop_CarService = shop_CarService;
  }

  @GetMapping
  public List<Shop_Car> getShop_Car(@RequestParam("email") String email) {
    return shop_CarService.ListShop_Car(email);
  }

  @RequestMapping(value = "/addcar", method = RequestMethod.POST)
  public void addshop_Car(@RequestParam("email") String email,
                          @RequestParam("productid") int productid,
                          @RequestParam("productName") String productName,
                          @RequestParam("price") int price


                          ) {
    System.out.println("??????????????????/");
    shop_CarService.addNewShop_Car(email,productid,productName,price);
  }

  @PutMapping(path = "/addnum")
  public void addnum(@RequestParam("id") int id) {

    shop_CarService.updateAddCar(id);

  }
  @PutMapping(path = "/cutnum")
  public void cutnum(@RequestParam("id") int id) {

    shop_CarService.updateCutCar(id);

  }

  @DeleteMapping(path= "/del")
  public void setStudentService(@RequestParam("id") int id){
    shop_CarService.deleteShop_Car(id);
  }
//  @RequestMapping(value = "/listcar", method = RequestMethod.POST)
//  public void Listshop_Car(@RequestParam("email") String email) {
//    System.out.println("???????????????21525???/");
//    shop_CarService.ListShop_Car(email);
//  }





//  @DeleteMapping(path= "{Shop_CarId}")
//  public void setStudentService(@PathVariable("Shop_CarId") Long shop_CarId){
//    shop_CarService.deleteShop_Car(Shop_CarId);
//  }

//  @PutMapping(path= "{Shop_CarId}")
//  public void updateShop_Car(
//    @PathVariable("user") String user,
//    @RequestParam(required = false) String name,
//    @RequestParam(required = false) String email) {
//
//    studentService.updateStudent(studentId,name,email);
//  }
}
