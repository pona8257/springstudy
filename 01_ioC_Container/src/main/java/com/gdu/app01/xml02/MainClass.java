package com.gdu.app01.xml02;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml02/app-context.xml");
		
		Academy academy = ctx.getBean("academy", Academy.class);
		// 제일 상위 클래스를 지정 해준뒤 하나씩 내려오는 방식으로
		
		
		System.out.println("이름 : " + academy.getName());
		System.out.println("주소 : " + academy.getAddress().getAddress());
		System.out.println("도로명 주소 : " + academy.getAddress().getStrAddress());
		System.out.println("전화번호 : " + academy.getAddress().getContact().getPhoneNo());
		System.out.println("팩스번호 : " + academy.getAddress().getContact().getPaxNo());

		
	}

}
