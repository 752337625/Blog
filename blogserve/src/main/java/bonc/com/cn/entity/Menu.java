package bonc.com.cn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity(name = "blog_menu")
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4976508079766644738L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "integer COMMENT '主键'")
	private Long id;
	
	/**
	 * 菜单名称
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '菜单名称'")
	private String menuText;
	
	
	/**
	 * 菜单图标
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '菜单图标'")
	private String menuIcon;


	/**
	 * 菜单路由
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '菜单路由'")
	private String menuUrl;
	
	/**
	 * 是否是父菜单
	 */
	@Column(columnDefinition = "tinyint(1) COMMENT '父菜单1是0不是'")
	private int menuIsParent = 1;
	/**
	 * 父菜单ID
	 */
	@Column(columnDefinition = "integer COMMENT '父菜单ID->0最高层菜单'")
	private Long menuParentId;
	

	/**
	 * 菜单是否可用
	 */
	@Column(columnDefinition = "tinyint(1) COMMENT '菜单是否可用->1可用0不可用'")
	private int menuEnabled = 1;


	/**
	 * 菜单排序
	 */
	@Column(columnDefinition = "int COMMENT '菜单排序'")
	private int menuSort;
	
	
	/**
	 * 菜单创建人
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '菜单创建人'")
	private String menuCreateUser;
	
	
	/**
	 * 菜单修改人
	 */
	@Column(columnDefinition = "varchar(50) COMMENT ' 菜单修改人'")
	private String menuModifyUser;

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
	
	 @Transient
	private List<Menu> children;

}
