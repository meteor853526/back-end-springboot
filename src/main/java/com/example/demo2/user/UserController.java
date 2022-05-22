package com.example.demo2.user;
import com.example.demo2.product.Product;
import com.example.demo2.product.ProductService;
import com.example.demo2.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin("http://localhost:3000/")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getUser() {
    return userService.getUser();
  }


  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public void saveUser(@RequestParam("email") String email, @RequestParam("passwd") String passwd,@RequestParam("type") String type) {
    Optional<User> UserOptional = userService.userCheck(email,passwd,type);
    if(UserOptional.isPresent()) {
        throw new IllegalStateException("user with id"+ email + "exist");
    }else{
      userService.saveUserToDB(email, passwd,type);
    }
    //userService.saveUserToDB(email, passwd,type);

  }
  @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
  public void checkUser(@RequestBody User user) {
    userService.userLogin(user);
  }


//  @PostMapping("/addP")
//
//  public void saveProduct(@RequestBody Product product)
//  {
//    productService.saveProductToDB(product);
//  }



  @PostMapping
  public void registerNewProduct(@RequestBody User user) {
    userService.addUser(user);
  }

  @DeleteMapping(path= "{StudentId}")
  public void setStudentService(@PathVariable("StudentId") Long studentId){
    userService.deleteUser(studentId);
  }

//  @PutMapping(path= "{studentId}")
//  public void updateStudent(
//    @PathVariable("studentId") Long studentId,
//    @RequestParam(required = false) String name,
//    @RequestParam(required = false) String email) {
//
//    productService.updateStudent(studentId,name,email);
//  }

}
