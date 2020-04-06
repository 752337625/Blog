package bonc.com.cn.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	@Value("${blog.web.url}")
	private String Url;

	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(10);// 散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
		shiroFilterFactoryBean.setLoginUrl(Url);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 开放登陆接口和注册接口
		filterChainDefinitionMap.put("/blog/LoginData", "anon");
		filterChainDefinitionMap.put("/blog/register", "anon");
		// 拦截设置放到最后，不然会导致所有 url 都被拦截
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 自定义身份认证 realm;
	 * <p>
	 * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm， 否则会影响 CustomRealm类 中其他类的依赖注入
	 */
	@Bean
	public CustomRealm customRealm() {
		CustomRealm customRealm = new CustomRealm();
		customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return customRealm;
	}
	/**
	 * session有效期
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		// 设置session过期时间3600s
		sessionManager.setGlobalSessionTimeout(360000L);
		return sessionManager;
	}

	/**
	 * 注入 securityManager
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm.
		securityManager.setRealm(customRealm());
		// 设置session过期时间3600s
		 securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

}
