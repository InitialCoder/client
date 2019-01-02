package com.ascend.client.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/get.json")
	@ResponseBody
	public String get(){
//		System.out.println("");
		byte[] b=new byte[1024*1024];
		return "get.json";
	}

}
