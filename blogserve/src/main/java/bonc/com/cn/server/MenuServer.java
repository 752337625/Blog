package bonc.com.cn.server;


import java.util.List;

import bonc.com.cn.entity.Menu;

public interface MenuServer {
	
	/**
	 * 新增菜单
	 * @param user
	 * @param req
	 * @return
	 */
	Menu menuServerMethod(Menu menu);
	/**
	 * 查询菜单
	 * @return
	 */
	List<Menu> menuListMethod();
	

}
