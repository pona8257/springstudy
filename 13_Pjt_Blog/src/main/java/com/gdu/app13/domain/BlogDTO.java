package com.gdu.app13.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
  private int blogNO;
  private String titile;
  private String content;
  private int hit;
  private Date createdAt;
  private Date modifiedAt;
  private MemberDTO memberDTO; // private int memberNo 블로그의 상세보기할 떄 정보를 실어나르는 역할을 한다
  
}
