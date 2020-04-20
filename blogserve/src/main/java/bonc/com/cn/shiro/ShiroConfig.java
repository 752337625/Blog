package bonc.com.cn.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

@Configuration
public class ShiroConfig {

	@Value("${blog.web.url}")
	private String Url;
	
	@Autowired
	private ShiroRealm shiroRealm;
	
	/**
	 * 注入securityManager
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		securityManager.setRealm(shiroRealm);
	    //securityManager.setRememberMeManager(rememberMeManager());  
		return securityManager;
	}
	  
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl(Url);
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/blog/loginServer", "anon");
		filterChainDefinitionMap.put("/blog/registerServer", "anon");
		filterChainDefinitionMap.put("/blog/logoutServer", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(10);// 散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}
	/**  
	  * cookie管理对象;  
	  * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中  
	  * @return  
	 */  
	/*
	 * public CookieRememberMeManager rememberMeManager(){ CookieRememberMeManager
	 * cookieRememberMeManager = new CookieRememberMeManager(); SimpleCookie
	 * simpleCookie = new SimpleCookie("rememberMe");
	 * simpleCookie.setMaxAge(259200);
	 * cookieRememberMeManager.setCookie(simpleCookie);
	 * cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="
	 * )); return cookieRememberMeManager; }
	 */

}
