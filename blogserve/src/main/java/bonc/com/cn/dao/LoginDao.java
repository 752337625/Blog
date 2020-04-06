package bonc.com.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bonc.com.cn.entity.User;

public interface LoginDao extends JpaRepository<User, Integer>{
	
	User findByUserName(String username);  

}
