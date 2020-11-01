package com.example.demo.database.board;

import com.example.demo.database.user.Users;

import javax.persistence.*;

import lombok.Data;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Board {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String content;
  private String type;
//  @ManyToOne
//  private Users users;

  @CreationTimestamp
  private LocalDateTime insertTime;
}