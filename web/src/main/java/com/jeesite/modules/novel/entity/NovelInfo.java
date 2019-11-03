/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 小说标题表Entity
 * @author guoxhe
 * @version 2019-11-03
 */
@Table(name="novel_info", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="number", attrName="number", label="文章标号"),
		@Column(name="like_num", attrName="likeNum", label="喜欢个数"),
		@Column(name="read_num", attrName="readNum", label="阅读次数"),
		@Column(name="author_id", attrName="authorId", label="作者id"),
		@Column(name="author_name", attrName="authorName", label="作者名称", queryType=QueryType.LIKE),
		@Column(name="title", attrName="title", label="文章标题", queryType=QueryType.LIKE),
		@Column(name="title_two", attrName="titleTwo", label="文章副标题", queryType=QueryType.LIKE),
		@Column(name="type", attrName="type", label="小说类型"),
		@Column(name="introduction", attrName="introduction", label="简介"),
		@Column(name="mini_introduction", attrName="miniIntroduction", label="精华"),
		@Column(name="picture_url", attrName="pictureUrl", label="图片链接"),
		@Column(name="music_url", attrName="musicUrl", label="图片链接"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="ext1", attrName="ext1", label="备用字段1", isQuery=false),
		@Column(name="ext2", attrName="ext2", label="备用字段2", isQuery=false),
		@Column(name="ext3", attrName="ext3", label="备用字段3", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class NovelInfo extends DataEntity<NovelInfo> {
	
	private static final long serialVersionUID = 1L;
	private Long number;		// 文章标号
	private Long likeNum;		// 喜欢个数
	private Long readNum;		// 阅读次数
	private String authorId;		// 作者id
	private String authorName;		// 作者名称
	private String title;		// 文章标题
	private String titleTwo;		// 文章副标题
	private String type;		// 小说类型
	private String introduction;		// 简介
	private String miniIntroduction;		// 精华
	private String pictureUrl;		// 图片链接
	private String musicUrl;		// 图片链接
	private String ext1;		// 备用字段1
	private String ext2;		// 备用字段2
	private String ext3;		// 备用字段3
	
	public NovelInfo() {
		this(null);
	}

	public NovelInfo(String id){
		super(id);
	}
	
	@NotNull(message="文章标号不能为空")
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Long getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Long likeNum) {
		this.likeNum = likeNum;
	}
	
	public Long getReadNum() {
		return readNum;
	}

	public void setReadNum(Long readNum) {
		this.readNum = readNum;
	}
	
	@Length(min=0, max=64, message="作者id长度不能超过 64 个字符")
	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	@Length(min=0, max=600, message="作者名称长度不能超过 600 个字符")
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@NotBlank(message="文章标题不能为空")
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
	
	@NotBlank(message="小说类型不能为空")
	@Length(min=0, max=1, message="小说类型长度不能超过 1 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=2000, message="简介长度不能超过 2000 个字符")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	@Length(min=0, max=500, message="精华长度不能超过 500 个字符")
	public String getMiniIntroduction() {
		return miniIntroduction;
	}

	public void setMiniIntroduction(String miniIntroduction) {
		this.miniIntroduction = miniIntroduction;
	}
	
	@Length(min=0, max=300, message="图片链接长度不能超过 300 个字符")
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	@Length(min=0, max=300, message="图片链接长度不能超过 300 个字符")
	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
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
	
}