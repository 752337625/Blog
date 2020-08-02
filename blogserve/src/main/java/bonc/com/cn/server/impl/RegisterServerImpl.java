package bonc.com.cn.server.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bonc.com.cn.dao.RegisterDao;
import bonc.com.cn.entity.User;
import bonc.com.cn.server.RegisterServer;
import bonc.com.cn.util.MD5Util;

@Service
public class RegisterServerImpl implements RegisterServer {
	

	@Autowired
	private RegisterDao registerDao;

	@Autowired
	private MD5Util MD5Util;

	@Override
	public Map<String, Object> registerServerMethod(User user, HttpServletRequest req) {
		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (null == user.getPassword() || " ".equals(user.getPassword())) {
			map.put("statue", 400);
			map.put("message", "密码不能为空");
			map.put("success", false);
		} else if (null == user.getUserName() || " ".equals(user.getUserName())) {
			map.put("statue", 400);
			map.put("message", "用户名不能为空");
			map.put("success", false);
		} else if (null == user.getEmail() || " ".equals(user.getEmail())) {
			map.put("statue", 400);
			map.put("message", "用户名邮箱不能为空");
			map.put("success", false);

		} else if (null == user.getTelephone() || " ".equals(user.getTelephone())) {
			map.put("statue", 400);
			map.put("message", "用户名手机号不能为空");
			map.put("success", false);
		} else if (user.getClause() == 0) {
			map.put("statue", 400);
			map.put("message", "请接受《服务条款》和《隐私政策》");
			map.put("success", false);
		} else {
			user.setPassword(MD5Util.encryptPassword(user));
			User save = registerDao.save(user);
			map.put("statue", 200);
			map.put("message", "保存成功");
			map.put("data", save);
			map.put("success", true);
		}
		return map;
	}

}
