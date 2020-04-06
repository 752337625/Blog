package bonc.com.cn.entity.History;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity(name = "blog_historyUser")
@EntityListeners(AuditingEntityListener.class)
public class HistoryUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "integer COMMENT '主键'")
	private Long id;

	/**
	 * 用户名
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '用户名'")
	private String userName;

	/**
	 * 密码
	 */
	@Column(columnDefinition = "varchar(100) COMMENT '密码'")
	private String password;


	/**
	 * 地址
	 */
	@Column(columnDefinition = "varchar(100) COMMENT '登陆地址'")
	private String address;
	/**
	 * IP
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '登录IP'")
	private String IP;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@CreatedDate
	@Column(columnDefinition = "datetime COMMENT '创建日期'")
	private Date createTime;

	/**
	 * 修改时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(columnDefinition = "datetime  COMMENT '修改日期'")
	@LastModifiedDate
	private Date modifyTime;

}
