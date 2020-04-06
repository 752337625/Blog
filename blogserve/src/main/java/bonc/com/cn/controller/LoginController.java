package bonc.com.cn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bonc.com.cn.entity.User;
import bonc.com.cn.server.LoginServer;

@Controller
@RequestMapping("/blog")
public class LoginController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private LoginServer loginServer;

	@ResponseBody
	@RequestMapping("/Login")
	public String LoginView() {
		return "index";
	}

	@ResponseBody
	@PostMapping("/LoginData")
	public Map<String, Object> UserLogin(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 从SecurityUtils里边创建一个 subject
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
		try {
			// 执行认证登陆
			subject.login(token);
		} catch (IncorrectCredentialsException e) {
			map.put("message", "密码错误");
			map.put("statue", 400);
			map.put("success", false);
			return map;
		} catch (UnknownAccountException e) {
			map.put("message", "用户错误");
			map.put("statue", 400);
			map.put("success", false);
			return map;
		} catch (LockedAccountException e) {
			map.put("message", "帐号被锁定,请联系管理人员");
			map.put("statue", 400);
			map.put("success", false);
			return map;
		} catch (ExcessiveAttemptsException e) {
			map.put("message", "登录次数过多,登陆失败");
			map.put("statue", 400);
			map.put("success", false);
			return map;
		} catch (DisabledAccountException e) {
			map.put("message", "帐号被禁用");
			map.put("statue", 400);
			map.put("success", false);
			return map;
		} catch (ExpiredCredentialsException e) {
			map.put("message", "密码过期,点击忘记密码进行修改");
			map.put("statue", 400);
			map.put("success", false);
			return map;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			map.put("message", "联系管理员,错误未知");
			map.put("statue", 400);
			map.put("success", false);
		}
		User findByUserName = loginServer.findByUserName(user.getUserName());
		subject.getSession().setAttribute("salt", findByUserName.getSalt());
		map.put("mess", "登录成功");
		map.put("statue", 200);
		map.put("success", true);
		map.put("data", findByUserName);
		return map;
	}

}
