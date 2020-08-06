package bonc.com.cn.server.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bonc.com.cn.dao.MenuDao;
import bonc.com.cn.entity.Menu;
import bonc.com.cn.server.MenuServer;

@Service
public class MenuServerImpl implements MenuServer {

	@Autowired
	private MenuDao menuDao;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 新增菜单
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@Override
	public Menu menuServerMethod(Menu menu) {

		Menu newMenu = menuDao.save(menu);
		return newMenu;
	}

	/**
	 * 查询菜单
	 * 
	 * @return
	 */
	@Override
	public List<Menu> menuListMethod() {
		List<Menu> findByMenuIsParent = menuDao.findByMenuIsParent(1);
		findByMenuIsParent.forEach(menu->{
			List<Menu> findByMenuParentId = menuDao.findByMenuParentId(menu.getId());
			menu.setChildren(findByMenuParentId);
		});
		return findByMenuIsParent;
	}

}
