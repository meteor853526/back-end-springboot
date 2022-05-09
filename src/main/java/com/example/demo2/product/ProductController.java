package com.example.demo2.product;

import com.example.demo2.student.Student;
import com.example.demo2.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
@CrossOrigin("http://localhost:3000/")
public class ProductController {
  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> getProduct() {
    return productService.getProduct();
  }

  @PostMapping
  public void registerNewProduct(@RequestBody Product product) {
    productService.addNewProduct(product);
  }

  @DeleteMapping(path= "{StudentId}")
  public void setStudentService(@PathVariable("StudentId") Long studentId){
    productService.deleteProduct(studentId);
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
