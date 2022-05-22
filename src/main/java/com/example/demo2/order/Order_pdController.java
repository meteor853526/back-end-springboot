package com.example.demo2.order;

import com.example.demo2.product.Product;
import com.example.demo2.product.ProductService;
import com.example.demo2.shop_car.Shop_Car;
import com.example.demo2.shop_car.Shop_CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Order")
@CrossOrigin("http://localhost:3000/")
public class Order_pdController {

  private final Order_pdService orderService;
  private final Shop_CarService shop_CarService;
  private final ProductService productService;
  @Autowired
  public Order_pdController(Order_pdService orderService, Shop_CarService shop_carService, ProductService productService) {
    this.orderService = orderService;
    this.shop_CarService = shop_carService;
    this.productService = productService;
  }

  @GetMapping(path = "/owner")
  public List<Order_pd> getOrder(@RequestParam("owner") String owner) {

    return orderService.getOrder(owner);
  }

  @GetMapping(path = "/buyer")
  public List<Order_pd> getBOrder(@RequestParam("buyer") String buyer) {

    return orderService.getBuyerOrder(buyer);
  }

  @GetMapping(path = "/take")
  public List<Shop_Car> getShop_Car(@RequestParam("email") String email,
                                    @RequestParam("Fname") String Fname,
                                    @RequestParam("Lname") String Lname,
                                    @RequestParam("phone") int phone,
                                    @RequestParam("address") String address,
                                    @RequestParam("pay_type") String pay_type,
                                    @RequestParam("delivery_type") String delivery_type,
                                    @RequestParam("time") String time
                                    ) {

    int j;
    List<Shop_Car> temp = shop_CarService.ListShop_Car(email);
    System.out.println(temp);
    System.out.println(temp.size());

    for (Shop_Car shop_car : temp) {
      Order_pd order = new Order_pd();
      System.out.println(shop_car.getProductid() + email + Fname + Lname + phone + address + pay_type + delivery_type + time);
      order.setFname(Fname);
      order.setLname(Lname);
      order.setPhone(phone);
      order.setAddress(address);
      order.setType(delivery_type);
      order.setPay_type(pay_type);
      order.setTime(time);
      order.setProductid(shop_car.getProductid());
      int num = 1;
      order.setNumber(num);
      order.setBuyer(email);
      order.setState("待出貨");
      String name = productService.getProductname(shop_car.getProductid());
      System.out.println(name);
      order.setProductname(name);
//      System.out.println(order.getFname() +','+ order.getLname() +','+ order.getPhone()+','+order.getAddress()+','+order.getType()
//        +','+ order.getPay_type() +','+ order.getTime()+','+order.getProductid() +','+ order.getProductname() +','+ order.getNumber());

      orderService.addNewOrder(order);
      shop_CarService.deleteShop_Car(shop_car.getId());


    }





    return shop_CarService.ListShop_Car(email);
  }
  @PutMapping(path = "/take")
  public void updateOrder_pd(@RequestParam("id") int id) {

    orderService.updateOrder(id);

  }

  @PutMapping(path = "/receive")
  public void updatepdOrder_pd(@RequestParam("id") int id) {

    orderService.updatepdOrder(id);

  }





//  @RequestMapping(value = "/addP", method = RequestMethod.POST,consumes = "multipart/form-data" )
//  public void saveProduct(
//    @RequestParam("name") String name,
//    @RequestParam("price") int price,
//    @RequestParam("category") String category,
//    @RequestParam("type") String type,
//    @RequestParam("number") int number,
//    @RequestParam("introduce") String introduce)
//  {
//    orderService.saveProductToDB(name, price, category,type,number,introduce);
//  }
//  @PostMapping("/addP")
//
//  public void saveProduct(@RequestBody Product product)
//  {
//    productService.saveProductToDB(product);
//  }

//  @PostMapping
//  public void registerNewProduct(@RequestBody Product product) {
//    orderService.addNeworder(product);
//  }
//
//  @DeleteMapping(path= "{StudentId}")
//  public void setStudentService(@PathVariable("StudentId") Long studentId){
//    orderService.deleteorder(studentId);
//  }

//  @PutMapping(path= "{studentId}")
//  public void updateStudent(
//    @PathVariable("studentId") Long studentId,
//    @RequestParam(required = false) String name,
//    @RequestParam(required = false) String email) {
//
//    productService.updateStudent(studentId,name,email);
//  }
}
