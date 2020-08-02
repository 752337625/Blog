package bonc.com.cn.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bonc.com.cn.entity.User;
import bonc.com.cn.server.RegisterServer;

@Controller
@RequestMapping("/blog")
public class RegisterController {
	
	@Autowired
	private RegisterServer registerServer;
	
	@PostMapping("/registerServer")
	@ResponseBody
	public Map<String, Object> register(User user,HttpServletRequest req){
		 Map<String, Object> registerServerMethod = registerServer.registerServerMethod(user,req);
		return registerServerMethod;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
