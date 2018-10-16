package com.sca.core.rest;

import com.alibaba.fastjson.JSONObject;
import com.sca.core.bean.Params;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
@RefreshScope //在客户端发起post调用/refresh接口之后，可以刷新修改配置
public class TestRest {

	@Value("${userName}")
	private String userName ;

	@Value("${age}")
	private int age ;

	private final String serverId = "a" ;

	@RequestMapping(value="/test",
		method= {RequestMethod.POST,RequestMethod.GET})
	public JSONObject test2(HttpServletRequest request) {
		String serverName = request.getParameter("serverName") ;
		JSONObject json = new JSONObject() ;
		json.put("userName",userName) ;
		json.put("age",age) ;
		json.put("serverName",serverName) ;
		json.put("serverInstanceId", serverId) ;
		return json ;
	}

	@RequestMapping(value="/test2",
		method= {RequestMethod.POST,RequestMethod.GET})
	public JSONObject test2(@RequestBody Params params) {
		JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(params)) ;
		json.put("serverInstanceId", serverId) ;
		return json ;
	}

}
