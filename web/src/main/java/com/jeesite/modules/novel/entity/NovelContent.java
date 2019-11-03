/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 小说内容表Entity
 * @author guoxhe
 * @version 2019-11-03
 */
@Table(name="novel_content", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="novel_id", attrName="novelId", label="关联主键"),
		@Column(name="big_chapter", attrName="bigChapter", label="卷"),
		@Column(name="big_chapter_str", attrName="bigChapterStr", label="卷"),
		@Column(name="chapter", attrName="chapter", label="章"),
		@Column(name="chapter_str", attrName="chapterStr", label="卷"),
		@Column(name="total_num", attrName="totalNum", label="总章数"),
		@Column(name="title", attrName="title", label="文章标题", queryType=QueryType.LIKE),
		@Column(name="title_two", attrName="titleTwo", label="文章副标题"),
		@Column(name="type", attrName="type", label="小说类型"),
		@Column(name="content", attrName="content", label="章节内容"),
		@Column(name="mini_introduction", attrName="miniIntroduction", label="精华"),
		@Column(name="picture_url", attrName="pictureUrl", label="图片链接"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="ext1", attrName="ext1", label="备用字段1", isQuery=false),
		@Column(name="ext2", attrName="ext2", label="备用字段2", isQuery=false),
		@Column(name="ext3", attrName="ext3", label="备用字段3", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class NovelContent extends DataEntity<NovelContent> {
	
	private static final long serialVersionUID = 1L;
	private String novelId;		// 关联主键
	private Long bigChapter;		// 卷
	private String bigChapterStr;		// 卷
	private Long chapter;		// 章
	private String chapterStr;		// 卷
	private Long totalNum;		// 总章数
	private String title;		// 文章标题
	private String titleTwo;		// 文章副标题
	private String type;		// 小说类型
	private String content;		// 章节内容
	private String miniIntroduction;		// 精华
	private String pictureUrl;		// 图片链接
	private String ext1;		// 备用字段1
	private String ext2;		// 备用字段2
	private String ext3;		// 备用字段3
	
	public NovelContent() {
		this(null);
	}

	public NovelContent(String id){
		super(id);
	}
	
	@NotBlank(message="关联主键不能为空")
	@Length(min=0, max=64, message="关联主键长度不能超过 64 个字符")
	public String getNovelId() {
		return novelId;
	}

	public void setNovelId(String novelId) {
		this.novelId = novelId;
	}
	
	@NotNull(message="卷不能为空")
	public Long getBigChapter() {
		return bigChapter;
	}

	public void setBigChapter(Long bigChapter) {
		this.bigChapter = bigChapter;
	}
	
	@Length(min=0, max=30, message="卷长度不能超过 30 个字符")
	public String getBigChapterStr() {
		return bigChapterStr;
	}

	public void setBigChapterStr(String bigChapterStr) {
		this.bigChapterStr = bigChapterStr;
	}
	
	@NotNull(message="章不能为空")
	public Long getChapter() {
		return chapter;
	}

	public void setChapter(Long chapter) {
		this.chapter = chapter;
	}
	
	@Length(min=0, max=30, message="卷长度不能超过 30 个字符")
	public String getChapterStr() {
		return chapterStr;
	}

	public void setChapterStr(String chapterStr) {
		this.chapterStr = chapterStr;
	}
	
	public Long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
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
	
	@Length(min=0, max=1, message="小说类型长度不能超过 1 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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