/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 读者评论表Entity
 * @author guoxhe
 * @version 2019-11-03
 */
@Table(name="novel_comment", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="novel_id", attrName="novelId", label="小说主键"),
		@Column(name="wx_user_id", attrName="wxUserId", label="读者id"),
		@Column(name="introduction", attrName="introduction", label="评论"),
		@Column(name="comments", attrName="comments", label="评论"),
		@Column(name="num", attrName="num", label="评论喜欢数"),
		@Column(name="title", attrName="title", label="文章标题", queryType=QueryType.LIKE),
		@Column(name="title_two", attrName="titleTwo", label="文章副标题"),
		@Column(name="type", attrName="type", label="评论类型"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="ext1", attrName="ext1", label="备用字段1", isQuery=false),
		@Column(name="ext2", attrName="ext2", label="备用字段2", isQuery=false),
		@Column(name="ext3", attrName="ext3", label="备用字段3", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class NovelComment extends DataEntity<NovelComment> {
	
	private static final long serialVersionUID = 1L;
	private String novelId;		// 小说主键
	private String wxUserId;		// 读者id
	private String introduction;		// 评论
	private String comments;		// 评论
	private String title;		// 文章标题
	private String titleTwo;		// 文章副标题
	private String type;		// 评论类型
	private Integer num;		// 评论类型
	private String ext1;		// 备用字段1
	private String ext2;		// 备用字段2
	private String ext3;		// 备用字段3
	
	public NovelComment() {
		this(null);
	}

	public NovelComment(String id){
		super(id);
	}
	
	@NotBlank(message="小说主键不能为空")
	@Length(min=0, max=64, message="小说主键长度不能超过 64 个字符")
	public String getNovelId() {
		return novelId;
	}

	public void setNovelId(String novelId) {
		this.novelId = novelId;
	}
	
	@Length(min=0, max=64, message="读者id长度不能超过 64 个字符")
	public String getWxUserId() {
		return wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}

	@Length(min=0, max=500, message="评论长度不能超过 500 个字符")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Length(min=0, max=100, message="文章标题长度不能超过 100 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=100, message="文章副标题长度不能超过 100 个字符")
	public String getTitleTwo() {
		return titleTwo;
	}

	public void setTitleTwo(String titleTwo) {
		this.titleTwo = titleTwo;
	}
	
	@Length(min=0, max=1, message="评论类型长度不能超过 1 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=500, message="备用字段1长度不能超过 500 个字符")
	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	
	@Length(min=0, max=500, message="备用字段2长度不能超过 500 个字符")
	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	
	@Length(min=0, max=500, message="备用字段3长度不能超过 500 个字符")
	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}