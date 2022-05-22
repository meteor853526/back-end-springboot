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
  private String image;

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

  @Column(name = "owner")
  private String owner;


  public Product(Long id, String image, String name, String introduce, String category,int price,String type,int number,String owner) {
    this.id = id;
    this.image = image;
    this.name = name;
    this.introduce = introduce;
    this.category = category;
    this.price = price;
    this.type = type;
    this.number = number;
    this.owner = owner;
  }

  public Product(String image, String name, String introduce, String category,int price,String type,int number,String owner) {
    this.image = image;
    this.name = name;
    this.introduce = introduce;
    this.category = category;
    this.price = price;
    this.type = type;
    this.number = number;
    this.owner = owner;
  }

  public Product() {
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String photo) {
    this.image = image;
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

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
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
