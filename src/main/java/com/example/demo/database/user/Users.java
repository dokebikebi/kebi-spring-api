package com.example.demo.database.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {

  @Id
  private String id;
  private String password;
  private String userName;
  private String kidName;
  private String kidAge;
  private String kidSex;
  private String email;
  private String address;
  private String phone;
  private String comments;
}