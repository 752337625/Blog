package bonc.com.cn.controller;

import java.util.HashMap;
import java.util.Map;


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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bonc.com.cn.entity.User;

@Controller
@RequestMapping("/blog")
public class LoginController {
	
	

	@PostMapping("/Login")
	@ResponseBody
	public String LoginView() {
		
		
		
		return "1";
	}

	@ResponseBody
	@PostMapping("/LoginData")
	public Map<String, Object> UserLogin(User user,boolean rememberMe) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 从SecurityUtils里边创建一个 subject
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword(),rememberMe);
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
		User User= (User) subject.getPrincipal();
		map.put("message", "登录成功");
		map.put("statue", 200);
		map.put("success", true);
		map.put("data", User);
		return map;
	}
	 /**
     * 登出  这个方法没用到,用的是shiro默认的logout
     * @param session
     * @param model
     * @return
     */
	@ResponseBody
	@GetMapping("/logout")
    public Map<String, Object> logout() {
    	Map<String, Object> map = new HashMap<String, Object>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        map.put("message", "登出成功");
		map.put("statue", 200);
		map.put("success", true);
		map.put("data", "登出成功");
        return map;
    }

}
