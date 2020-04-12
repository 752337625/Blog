package bonc.com.cn.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcFilter {
	
	/**
	 * FormAuthenticationFilter 过滤器 过滤记住我
	 * @return
	 */
	@Bean
	public FormAuthenticationFilter formAuthenticationFilter(){
	    FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
	    //对应前端的checkbox的name = rememberMe
	    formAuthenticationFilter.setRememberMeParam("rememberMe");
	    return formAuthenticationFilter;
	}

}
