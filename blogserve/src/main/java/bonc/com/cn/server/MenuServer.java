package bonc.com.cn.server;


import bonc.com.cn.entity.Menu;

public interface MenuServer {
	
	/**
	 * 新增菜单
	 * @param user
	 * @param req
	 * @return
	 */
	Menu menuServerMethod(Menu menu);

}
