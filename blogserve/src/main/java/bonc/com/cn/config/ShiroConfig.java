package bonc.com.cn.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bonc.com.cn.filter.KickoutSessionControlFilter;
import bonc.com.cn.listener.ShiroSessionListener;
import bonc.com.cn.realm.CustomRealm;

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
		// 自定义拦截器限制并发人数,参考博客
		LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();
		// 限制同一帐号同时在线的个数
		filtersMap.put("kickout", kickoutSessionControlFilter());
		shiroFilterFactoryBean.setFilters(filtersMap);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 开放登陆接口和注册接口
		filterChainDefinitionMap.put("/blog/LoginData", "anon");
		filterChainDefinitionMap.put("/blog/register", "anon");
		filterChainDefinitionMap.put("/blog/logout", "anon");
		// 拦截设置放到最后，不然会导致所有 url 都被拦截
		// 其他资源都需要认证 authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
		filterChainDefinitionMap.put("/**", "kickout,user");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 配置核心安全事务管理器
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm.
		securityManager.setRealm(customRealm());
		// 配置记住我 ：
		securityManager.setRememberMeManager(rememberMeManager());
		// 配置 ehcache缓存管理器 参考博客：
		securityManager.setCacheManager(ehCacheManager());
		// 配置自定义session管理，使用ehcache 或redis
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	/**
	 * 自定义身份认证 realm;
	 * <p>
	 * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm， 否则会影响 CustomRealm类 中其他类的依赖注入
	 */
	@Bean
	public CustomRealm customRealm() {
		CustomRealm customRealm = new CustomRealm();
		customRealm.setCachingEnabled(true);
		// 启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
		customRealm.setAuthenticationCachingEnabled(true);
		// 缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
		customRealm.setAuthenticationCacheName("authenticationCache");
		// 密码认证
		customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return customRealm;
	}

	/**
	 * cookie对象;会话Cookie模板 ,默认为: JSESSIONID 问题:
	 * 与SERVLET容器名冲突,重新定义为sid或rememberMe，自定义
	 * 
	 * @return
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {
		// 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		// setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
		// setcookie()的第七个参数
		// 设为true后，只能通过http访问，javascript无法访问
		// 防止xss读取cookie
		simpleCookie.setHttpOnly(true);
		simpleCookie.setPath("/");
		// <!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(10000);
		return simpleCookie;
	}

	/**
	 * cookie管理对象;记住我功能,rememberMe管理器
	 * 
	 * @return
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		// rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
		cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		return cookieRememberMeManager;
	}

	/**
	 * shiro缓存管理器; 需要添加到securityManager中
	 * 
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return cacheManager;
	}

	/**
	 * 配置session监听
	 * 
	 * @return
	 */
	@Bean
	public ShiroSessionListener sessionListener() {
		ShiroSessionListener sessionListener = new ShiroSessionListener();
		return sessionListener;
	}

	/**
	 * 配置会话ID生成器
	 * 
	 * @return
	 */
	@Bean
	public SessionIdGenerator sessionIdGenerator() {
		return new JavaUuidSessionIdGenerator();
	}

	@Bean
	public SessionDAO sessionDAO() {
		EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
		// 使用ehCacheManager
		enterpriseCacheSessionDAO.setCacheManager(ehCacheManager());
		// 设置session缓存的名字 默认为 shiro-activeSessionCache
		enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
		// sessionId生成器
		enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator());
		return enterpriseCacheSessionDAO;
	}

	/**
	 * 配置保存sessionId的cookie 注意：这里的cookie 不是上面的记住我 cookie 记住我需要一个cookie session管理
	 * 也需要自己的cookie
	 * 
	 * @return
	 */
	@Bean
	public SimpleCookie sessionIdCookie() {
		// 这个参数是cookie的名称
		SimpleCookie simpleCookie = new SimpleCookie("sid");
		// setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
		// setcookie()的第七个参数
		// 设为true后，只能通过http访问，javascript无法访问
		// 防止xss读取cookie
		simpleCookie.setHttpOnly(true);
		simpleCookie.setPath("/");
		// maxAge=-1表示浏览器关闭时失效此Cookie
		simpleCookie.setMaxAge(-1);
		return simpleCookie;
	}

	/**
	 * 配置会话管理器，设定会话超时及保存
	 * 
	 * @return
	 */
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		// 配置监听
		listeners.add(sessionListener());
		sessionManager.setSessionListeners(listeners);
		sessionManager.setSessionIdCookie(sessionIdCookie());
		sessionManager.setSessionDAO(sessionDAO());
		sessionManager.setCacheManager(ehCacheManager());

		return sessionManager;

	}

	/**
	 * 并发登录控制
	 * 
	 * @return
	 */
	@Bean
	public KickoutSessionControlFilter kickoutSessionControlFilter() {
		KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
		// 用于根据会话ID，获取会话进行踢出操作的；
		kickoutSessionControlFilter.setSessionManager(sessionManager());
		// 使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
		kickoutSessionControlFilter.setCacheManager(ehCacheManager());
		// 是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；
		kickoutSessionControlFilter.setKickoutAfter(false);
		// 同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
		kickoutSessionControlFilter.setMaxSession(1);
		// 被踢出后重定向到的地址；
		kickoutSessionControlFilter.setKickoutUrl("Url");
		return kickoutSessionControlFilter;
	}
}
