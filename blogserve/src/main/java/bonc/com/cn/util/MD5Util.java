package bonc.com.cn.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Configuration;

import bonc.com.cn.entity.User;

@Configuration
public class MD5Util {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	public static final String ALGORITHM_NAME = "md5"; // 基础散列算法
	public static final int HASH_ITERATIONS = 10; // 自定义散列次数

	public String encryptPassword(User user) {
		// 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassword(),ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
		return newPassword;
	}

}
