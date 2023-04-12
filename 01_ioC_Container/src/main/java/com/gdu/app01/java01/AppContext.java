package com.gdu.app01.java01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 	@Configuration
 	안녕. 난 Configuration이라고 해
 	Spring Container에 Bean을 만들어 두는 Java 클래스야.
 	Spring Bean Configuration File하고 같은 일을 하지 
 */

@Configuration
public class AppContext {

	// Bean을 만들고 싶으면 메소드를 만드면 됩니다. (Bean 하나 = 메소드 하나)
	
	/*
	 	@Bean
	 	난 Bean을 만드는 메소드이다.
	 	반환타입이 Bean의 타입(<bean> 태그의 class 속성)이고, 
	 	메소드명이 Bean의 이름(<bean> 태그의 id 속성)이야.
	 */
	@Bean
	public Contact contact1() {		// <bean id="contact1" class="Contact">
		Contact c = new Contact();	// default constructor
		c.setTel("02-456-1263");	// setter <property name="tel" value="02-456-1263">
		c.setFax("02-456-789");		// setter <property name="fax" value="02-456-789">
		return c;					// 반환한 객체 c가 Spring Container에 저장됩니다.
	}
	
	@Bean
	public User user1() {			// <bean id="user1" class="User">
		User u = new User();		// default constructor
		u.setId("spider");			// setter <property name="id" value="spider">
		u.setContact(contact1());	// setter <property name="contact" ref="contact1">
		return u;					// 반환한 객체 u가 Spring Container에 저장됩니다.
	}
	
	
	@Bean(name="contact2")	// name 속성이 추가되면 Bean의 id로 사용됩니다
	public Contact www() {	// name 속성이 사용되었으므로 메소드명은 더 이상 Bean의 id가 아니다.
		return new Contact("02-333-333", "02-456-789");
	}
	
	@Bean(name="user2")
	public User aaa() {
		return new User("betman", www());
	}
	
	
}
