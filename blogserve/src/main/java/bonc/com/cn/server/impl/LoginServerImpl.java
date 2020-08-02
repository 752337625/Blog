package bonc.com.cn.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bonc.com.cn.dao.LoginDao;
import bonc.com.cn.entity.User;
import bonc.com.cn.server.LoginServer;

@Service
public class LoginServerImpl  implements LoginServer{
	
	@Autowired
	private LoginDao LoginDao;

	@Override
	public User findByUserName(String username) {
		return  LoginDao.findByUserName(username);
	}

}
