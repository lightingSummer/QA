package com.summer.qa.model;

import lombok.Data;

import java.util.Date;

@Data
public class Question {
  private Integer id;

  private String title;

  private Integer userId;

  private Date createdDate;

  private Integer commentCount;

  private Integer isDel;

  private String content;
}
