package com.example.demo2.user;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
@Table
public class User {


  @Id
  @SequenceGenerator(
    name = "User_sequence",
    sequenceName = "User_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "User_sequence"
  )

  private int id;
  private String email;
  private String passwd;
  private String image;
  private String type;

  public User(int id, String email, String passwd, String image,String type) {
    this.id = id;
    this.email = email;
    this.passwd = passwd;
    this.image = image;
    this.type = type;
  }

  public User(String email, String passwd, String image,String type) {
    this.email = email;
    this.passwd = passwd;
    this.image = image;
    this.type = type;
  }

  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
