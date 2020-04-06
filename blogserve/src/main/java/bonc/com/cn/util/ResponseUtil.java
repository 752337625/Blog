package bonc.com.cn.util;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
public class ResponseUtil {

	private String message;
	private Integer statue;
	private Boolean success;
	private Object data;

	public ResponseUtil(String message, Integer statue, Boolean success, Object data) {
		this.message = message;
		this.statue = statue;
		this.success = success;
		this.data = data;
	}

	public ResponseUtil(String message, Integer statue, Boolean success) {
		this.message = message;
		this.statue = statue;
		this.success = success;
	}

}
