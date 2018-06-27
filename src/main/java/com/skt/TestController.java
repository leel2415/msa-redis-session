package com.skt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String Test(HttpServletRequest request, HttpSession session) {
		
		if(session.getAttribute("attr") == null) {
			String attr = request.getParameter("attr");
			
			if(attr == null) {
				return "input attr";
			} else {
				session.setAttribute("attr", attr);	
			}
		}
		
		return session.getAttribute("attr").toString();
	}
}
