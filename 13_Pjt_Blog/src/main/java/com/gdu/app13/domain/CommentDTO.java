package com.gdu.app13.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
  private int commentNo;
  private String content;
  private int state;
  private int depth;
  private int groupNO;
  private Date createdAt;
  private int blogNo; // 댓글은 상세보기가 필요하지 않으니 blogDTO를 가질필요가 없가
  private MemberDTO memberDTO;
}
