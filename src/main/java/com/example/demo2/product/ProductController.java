package com.example.demo2.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.MultipartConfigElement;
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

  @GetMapping(path = "/owner")
  public List<Product> getOwnerProduct(@RequestParam("owner") String owner) {
    return productService.getOwner(owner);
  }



  @RequestMapping(value = "/addP", method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
  public void saveProduct(
                            @RequestParam("name") String name,
                            @RequestParam("price") int price,
                            @RequestParam("category") String category,
                            @RequestParam("type") String type,
                            @RequestParam("number") int number,
                            @RequestParam("introduce") String introduce,
                            @RequestParam("owner") String owner,
                            @RequestParam("file") MultipartFile file)
  {
    System.out.println(file);
    productService.saveProductToDB(name, price, category,type,number,introduce,owner,file);
  }
//  @PostMapping("/addP")
//
//  public void saveProduct(@RequestBody Product product)
//  {
//    productService.saveProductToDB(product);
//  }

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
