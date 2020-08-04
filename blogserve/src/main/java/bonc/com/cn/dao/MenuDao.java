package bonc.com.cn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bonc.com.cn.entity.Menu;

public interface MenuDao  extends JpaRepository<Menu, Integer>{
	
	
	List<Menu> findByMenuIsParent(int menuIsParent);
	List<Menu> findByMenuParentId(Long menuParentId);
}
