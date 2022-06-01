package com.example.demo2.comment;

import javax.persistence.*;

@Entity
@Table
public class Comment {

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
  @Column(name = "評論編號")
  private int id;

  @Column(name = "商品編號")
  private int productid;

  @Column(name = "評論者")
  private String buyer;

  @Column(name = "星數")
  private int star;

  @Column(name = "文字內容")
  private String content;

  @Column(name = "日期")
  private String time;

  public Comment(int productid, int star, String content, String time,String buyer) {
    this.productid = productid;
    this.star = star;
    this.content = content;
    this.time = time;
    this.buyer = buyer;
  }

  public Comment(int id, int productid, int star, String content, String time,String buyer) {
    this.id = id;
    this.productid = productid;
    this.star = star;
    this.content = content;
    this.time = time;
    this.buyer = buyer;
  }

  public Comment() {
  }

  public String getBuyer() {
    return buyer;
  }

  public void setBuyer(String buyer) {
    this.buyer = buyer;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductid() {
    return productid;
  }

  public void setProductid(int productid) {
    this.productid = productid;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}
