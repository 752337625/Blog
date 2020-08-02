package bonc.com.cn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bonc.com.cn.entity.Menu;
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

}
