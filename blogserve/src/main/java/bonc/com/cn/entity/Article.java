package bonc.com.cn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity(name = "blog_article")
public class Article  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7467743774635864360L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "integer COMMENT '主键'")
	private Long articleId;

	/**
	 * 关联ID->发表用户ID
	 */
	@Column(columnDefinition = "integer COMMENT '关联ID->发表用户ID'",nullable=false)
	private Long userId;

	/**
	 * 标题
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '标题'",nullable=false)
	private String articleTitle;

	/**
	 * 作者
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '作者'",nullable=false)
	private String articleAuthor;

	/**
	 * 关键字
	 */
	@Column(columnDefinition = "varchar(50) COMMENT '关键字'",nullable=false)
	private String articleKeyword;

	/**
	 * 描述
	 */
	@Column(columnDefinition = "text COMMENT '描述'",nullable=false)
	private String articleDescription;

	/**
	 * 发布形式
	 */
	@Column(columnDefinition = "int(10) COMMENT '发布形式'",nullable=false)
	private int articleRelease;
	
	
	/**
	 * 文章类型
	 */
	@Column(columnDefinition = "int(10) COMMENT '文章类型'",nullable=false)
	private int articleTypel;
	
	
	/**
	 * 菜单修改人
	 */
	@Column(columnDefinition = "varchar(60) COMMENT '文章标签'",nullable=false)
	private String articleLabel;
	
	/**
	 * 分类专栏
	 */
	@Column(columnDefinition = "varchar(60) COMMENT '分类专栏'",nullable=false)
	private String articleClassify;
	
	/**
	 *文字内容
	 */
	@Column(columnDefinition = "varchar(60) COMMENT '文章内容'",nullable=false)
	private String articleContent;
	
	/**
	 *文章封面
	 */
	@Column(columnDefinition = "varchar(100) COMMENT '文章封面'",nullable=false)
	private String articleImageUrl;
	
	/**
	 * 文章浏览量
	 */
	@Column(columnDefinition = "int(50) COMMENT '文章浏览量'")
	private Integer articleView = 0;

	/**
	 * 文章评论数量
	 */
	@Column(columnDefinition = "int(50) COMMENT '文章评论数量'")
	private Integer articleCommentCount = 0;
	
	/**
	 * 文章点赞数量
	 */
	@Column(columnDefinition = "int(50) COMMENT '文章点赞数量'")
	private Integer articleLikeCount = 0;

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
