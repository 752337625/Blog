package bonc.com.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bonc.com.cn.entity.Menu;
import bonc.com.cn.entity.User;
import bonc.com.cn.server.MenuServer;

@Controller
@RequestMapping("/blog/menuServer")
public class MenuController {

	@Autowired
	private MenuServer menuServer;

	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> menuAdd(Menu menu) {
		Map<String, Object> map = new HashMap<String, Object>();
		Menu newMenu = menuServer.menuServerMethod(menu);
		map.put("message", "保存成功");
		map.put("statue", 200);
		map.put("success", true);
		map.put("data", newMenu);
		return map;
	}
	
	
	@RequestMapping("/select")
	@ResponseBody
	public Map<String ,Object> menuList(){
		Map<String,Object> map = new HashMap<String ,Object>();
		Subject subject = SecurityUtils.getSubject();
		User User= (User) subject.getPrincipal();
		try {
			List<Menu> menuListMethod = menuServer.menuListMethod();
			map.put("message", "查询成功");
			map.put("statue", 200);
			map.put("success", true);
			map.put("data", menuListMethod);
			map.put("user", User);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("message", "客户权限不足，无法查询出菜单。");
			map.put("statue", 500);
			map.put("success", false);
		}
		
		return map;
		
	}

}
