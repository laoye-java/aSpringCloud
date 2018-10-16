package com.sca.core.rest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestRest {

	@RequestMapping(value="/test",
		method= {RequestMethod.POST,RequestMethod.GET})
	public JSONObject testGet(HttpServletRequest request, String a) {
		String serverName = request.getParameter("serverName") ;
		JSONObject json = new JSONObject() ;
		json.put("serverName",serverName) ;
		json.put("serverInstanceId","zuul") ;
		return json ;
	}
	
}
