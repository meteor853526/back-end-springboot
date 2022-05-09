package com.example.demo2.product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Product {

  @Id
  @SequenceGenerator(
    name = "Product_sequence",
    sequenceName = "Product_sequence",
    allocationSize = 1
  )

  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "Product_sequence"
  )
  @Column(name = "id")
  private Long id;

  @Column(name = "image")
  private String photo;

  @Column(name = "name")
  private String name;

  @Column(name = "商品介紹")
  private String introduce;

  @Column(name = "商品類別")
  private String category;

  @Column(name = "價格")
  private int price;

  @Column(name = "款式")
  private String type;

  @Column(name = "數量")
  private int number;


  public Product(Long id, String photo, String name, String introduce, String category,int price,String type,int number) {
    this.id = id;
    this.photo = photo;
    this.name = name;
    this.introduce = introduce;
    this.category = category;
    this.price = price;
    this.type = type;
    this.number = number;

  }

  public Product(String photo, String name, String introduce, String category,int price,String type,int number) {
    this.photo = photo;
    this.name = name;
    this.introduce = introduce;
    this.category = category;
    this.price = price;
    this.type = type;
    this.number = number;
  }

  public Product() {
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
  @Override
  public String toString() {
    return "Student{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", introduce='" + introduce + '\'' +
      ", category='" + category + '\'' +
      ", price='" + price + '\'' +
      ", type='" + type + '\'' +
      ", number='" + number + '\'' +
      '}';
  }

}
