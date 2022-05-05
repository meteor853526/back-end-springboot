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
    sequenceName = "student_sequence",
    allocationSize = 1
  )

  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "Product_sequence"
  )

  private Long id;
  private String photo;
  private String name;
  private String introduce;
  private String category;
  private int price;
  private String type;
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
