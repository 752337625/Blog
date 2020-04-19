package bonc.com.cn.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "blog_role")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3350031756551357316L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "integer COMMENT '主键'")
	private Integer id;
	
	
	
	/**
	 * 角色编号
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '角色编号'")
	private String roleId;
	

	/**
	 * 角色中文
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '角色名字'")
	private String roleNameZh;

}
