package com.gdu.app02.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class PostController {

	/*	다른 방법 2가지
	public String detail(@RequestParam("name") String name, @RequestParam("age") int age) { }
	public String detail(Person p) { }
	*/
	
	@GetMapping("/post/detail.do")
	public String detail(HttpServletRequest request) throws Exception {	// name, age 파라미터가 있다 
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("/post/detail.do");
		System.out.println("name : " + name + ", age : " + age);
		
		// return "redirect:이동경로";  
		return "redirect:/post/list.do?name=" + URLEncoder.encode(name, "UTF-8") + "&age=" + age;	//  /post/list.do 매핑으로 이동하시오!, redirect는 파라미터 전달이 안됨으로 필요하면 return에 다시한번 전달해준다.
																									// redirect는 무조건 매핑, forword는 jsp
	}
	
	@GetMapping("/post/list.do")
	public String list(HttpServletRequest request,	// name, age 파라미터가 있다 (위에서 넘겨줘서)
						Model model) {				// forward 방식 에서만 쓴다 model
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		// /WEB-INF/views/post/list.do로 forward 하겠다
		return "post/list";
		
	}
	
	@GetMapping("/post/detail.me")
	public String detailMe(HttpServletRequest request,
							RedirectAttributes redirectAttributes) {	// Redirect할 때 속성(Attribute)을 전달하는 스프링 인터페이스
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// Redirect 경로까지 전달되는 속성 : Flash Attribute
		redirectAttributes.addFlashAttribute("name", name);		// addAttribute() 아님을 주의 !!! forward가 방식이 addAttribute()
		redirectAttributes.addFlashAttribute("age", age);
		
		return "redirect:/post/list.me";
		
	}
	
	@GetMapping("/post/list.me")
	public String listMe() {	// Flash Attribute는 Redirect 경로까지 자동으로 전달되므로 별도의 코드가 필요하지 않다
		return "post/list";
		
	}
	
}
