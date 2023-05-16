package com.gdu.app12.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SleepUserDTO {

	private int userNo;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String email;
	private String mobile;
	private String birthyear;
	private String birthday;
	private String postcode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String agreeCode;
	private Date joinedAt;
	private Date pwModifiedAt;
	private Date sleptAt;
	
}
