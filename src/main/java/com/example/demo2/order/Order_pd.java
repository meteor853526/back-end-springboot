package com.example.demo2.order;

import javax.persistence.*;

@Entity
@Table
public class Order_pd {


  @Id
  @SequenceGenerator(
    name = "Order_sequence",
    sequenceName = "Order_sequence",
    allocationSize = 1
  )

  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "Order_sequence"
  )

  @Column(name = "訂單編號")
  private int id;

  @Column(name = "姓氏")
  private String Fname;

  @Column(name = "名字")
  private String Lname;

  @Column(name = "電話")
  private String phone;

  @Column(name = "收貨地址")
  private String address;

  @Column(name = "送貨方式")
  private String type;

  @Column(name = "結帳方式")
  private String Pay_type;

  @Column(name = "訂單成立時間")
  private String time;

  @Column(name = "商品編號")
  private int productid;

  @Column(name = "商品名稱")
  private String productname;

  @Column(name = "訂單狀態")
  private String state;

  @Column(name = "購買者")
  private String buyer;

  @Column(name = "數量")
  private int number;


  public Order_pd(int id, String fname, String lname, String phone, String address, String type, String pay_type, String time, int productid, String productname, int number,String buyer,String state) {

    this.id = id;
    this.Fname = fname;
    this.Lname = lname;
    this.phone = phone;
    this.address = address;
    this.type = type;
    this.Pay_type = pay_type;
    this.time = time;
    this.productid = productid;
    this.productname = productname;
    this.number = number;
    this.buyer = buyer;
    this.state = state;
  }

  public Order_pd(String fname, String lname, String phone, String address, String type, String pay_type, String time, int productid, String productname, int number,String buyer,String state) {
    this.Fname = fname;
    this.Lname = lname;
    this.phone = phone;
    this.address = address;
    this.type = type;
    this.Pay_type = pay_type;
    this.time = time;
    this.productid = productid;
    this.productname = productname;
    this.number = number;
    this.buyer = buyer;
    this.state = state;
  }

  public Order_pd() {
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getBuyer() {
    return buyer;
  }

  public void setBuyer(String buyer) {
    this.buyer = buyer;
  }

  public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }
  public String getPay_type() {
    return Pay_type;
  }

  public void setPay_type(String pay_type) {
    Pay_type = pay_type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFname() {
    return Fname;
  }

  public void setFname(String fname) {
    Fname = fname;
  }

  public String getLname() {
    return Lname;
  }

  public void setLname(String lname) {
    Lname = lname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getProductid() {
    return productid;
  }

  public void setProductid(int productid) {
    this.productid = productid;
  }


  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "[" +
      '\"' + id + '\"' + ","+
      '\"' + productid + '\"' + ","+
      '\"' + productname + '\"' + ","+
      '\"' + type + '\"' + ","+
      '\"' + Pay_type + '\"' + ","+
      '\"' + number + '\"' + ","+
      '\"' + time + '\"' + ","+
      '\"' + state + '\"' +
      ']';
  }
}
