package com.example.demo2.shop_car;

import javax.persistence.*;

@Entity
@Table
public class Shop_Car {

  @Id
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )
  @Column(name = "id")
  private int id;

  @Column(name = "email")
  private String email;

  @Column(name = "productid")
  private int Productid;

  @Column(name = "number")
  private int number;

  @Column(name = "price")
  private int price;

  private String productName;

  public Shop_Car(int id, String email, int productid, int number,String productName,int price) {
    this.id = id;
    this.email = email;
    this.Productid = productid;
    this.productName = productName;
    this.number = number;
    this.price = price;
  }

  public Shop_Car(String email, int productid, int number,String productName,int price) {
    this.email = email;
    this.Productid = productid;
    this.productName = productName;
    this.number = number;
    this.price = price;
  }

  public Shop_Car() {

  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductid() {
    return Productid;
  }

  public void setProductid(int productid) {
    Productid = productid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Car{" +
      "id=" + id +
      ", productid='" + Productid + '\'' +
      ", email='" + email + '\'' +
      ", dob=" +  number +

      '}';
  }
}
