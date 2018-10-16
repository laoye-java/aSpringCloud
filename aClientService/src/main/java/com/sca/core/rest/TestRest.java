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
//这里面的属性有可能会更新的，配置中心变化的话就要刷新，没有这个注解内，配置就不能及时更新
@RefreshScope //在客户端发起post调用/refresh接口之后，可以刷新修改配置
public class TestRest {

	@Value("${userName}")
	private String userName ;

	@Value("${age}")
	private int age ;

	private final String serverId = "a" ;

	@RequestMapping(value="/test",
		method= {RequestMethod.POST,RequestMethod.GET})
	public JSONObject test(HttpServletRequest request) {
		System.out.println("==请求来了test==" + serverId);
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
		System.out.println("==请求来了test2==" + serverId);
		JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(params)) ;
		json.put("serverInstanceId", serverId) ;
		return json ;
	}

}
