package bonc.com.cn.server.impl;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bonc.com.cn.dao.MenuDao;
import bonc.com.cn.entity.Menu;
import bonc.com.cn.server.MenuServer;

@Service
public class MenuServverImpl implements MenuServer {
	
	@Autowired
	private MenuDao menuDao;


	@Override
	public Menu menuServerMethod(Menu menu) {
		
		
		Menu newMenu = menuDao.save(menu);
		return null;
	}
	
	

}
