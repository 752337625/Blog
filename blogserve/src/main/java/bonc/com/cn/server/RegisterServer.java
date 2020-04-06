package bonc.com.cn.server;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bonc.com.cn.entity.User;

public interface RegisterServer {
	
	
	Map<String, Object> registerServerMethod(User user,HttpServletRequest req);

}
