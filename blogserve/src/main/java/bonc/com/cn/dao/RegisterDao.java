package bonc.com.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bonc.com.cn.entity.User;

public interface RegisterDao extends JpaRepository<User, Integer> {
	
	
	

}
