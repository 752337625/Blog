package bonc.com.cn.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import bonc.com.cn.entity.User;
import bonc.com.cn.server.LoginServer;

@Configuration
public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private LoginServer loginServer;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User userInfo = loginServer.findByUserName(username);
		if (userInfo == null) {
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, 
				userInfo.getPassword(), 
				ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
				getName() 
		);
		return authenticationInfo;
	}

}
