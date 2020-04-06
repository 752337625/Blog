package bonc.com.cn.server;

import bonc.com.cn.entity.User;

public interface LoginServer {
	
	
	User findByUserName(String username);  

}
