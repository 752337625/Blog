package bonc.com.cn.entity;

import java.io.Serializable;
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
@Entity(name = "blog_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842946297474313728L;

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
	 * 当前账户是否可用
	 */
	@Column(columnDefinition = "tinyint(1) COMMENT '当前账户是否可用'")
	private int enabled;
	
	/**
	 * 是否同意服务条款
	 */
	@Column(columnDefinition = "tinyint(1) COMMENT '当前是否同意服务条款'")
	private int clause=1;

	/**
	 * 当前账户是否被锁定
	 */
	@Column(columnDefinition = "tinyint(1) COMMENT '当前账户是否被锁定'")
	private int locked;
	
	/**
	 * 用户注册手机号
	 */
	@Column(columnDefinition = "varchar(100) COMMENT '用户注册手机号'")
	private String telephone;
	

	/**
	 * 用户注册邮箱
	 */
	@Column(columnDefinition = "varchar(100) COMMENT '用户注册邮箱'")
	private String email;
	

	/**
	 * 注册地址
	 */
	@Column(columnDefinition = "varchar(100) COMMENT '初次登陆地址'")
	private String address;
	/**
	 * 注册IP
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '初次登录IP'")
	private String IP;
	
	/**
	 * 个人描述
	 */
	@Column(columnDefinition = "varchar(400) COMMENT '个人描述'")
	private String description;
	
	/**
	 * 盐值
	 */
	@Column(columnDefinition = "varchar(100) COMMENT '密码加盐'")
	private String salt;

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

	public String getCredentialsSalt() {
		return userName + salt + salt;
	}

}
