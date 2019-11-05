/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.user.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 读者阅读记录Entity
 * @author guoxiaohe
 * @version 2019-11-04
 */
@Table(name="user_read_log", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="novel_id", attrName="novelId", label="小说主键"),
		@Column(name="wx_user_id", attrName="wxUserId", label="读者id"),
		@Column(name="last_read_chapter_id", attrName="lastReadChapterId", label="上次阅读章节id"),
		@Column(name="last_read_chapter_title", attrName="lastReadChapterTitle", label="上次阅读章节标题", queryType=QueryType.LIKE),
		@Column(name="number", attrName="number", label="文章标号"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="ext1", attrName="ext1", label="备用字段1", isQuery=false),
		@Column(name="ext2", attrName="ext2", label="备用字段2", isQuery=false),
		@Column(name="ext3", attrName="ext3", label="备用字段3", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class UserReadLog extends DataEntity<UserReadLog> {
	
	private static final long serialVersionUID = 1L;
	private String novelId;		// 小说主键
	private String wxUserId;		// 读者id
	private String lastReadChapterId;		// 上次阅读章节id
	private String lastReadChapterTitle;		// 上次阅读章节标题
	private Long number;		// 文章标号
	private String ext1;		// 备用字段1
	private String ext2;		// 备用字段2
	private String ext3;		// 备用字段3
	
	public UserReadLog() {
		this(null);
	}

	public UserReadLog(String id){
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
	
	@NotBlank(message="读者id不能为空")
	@Length(min=0, max=64, message="读者id长度不能超过 64 个字符")
	public String getWxUserId() {
		return wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}
	
	@Length(min=0, max=64, message="上次阅读章节id长度不能超过 64 个字符")
	public String getLastReadChapterId() {
		return lastReadChapterId;
	}

	public void setLastReadChapterId(String lastReadChapterId) {
		this.lastReadChapterId = lastReadChapterId;
	}
	
	@Length(min=0, max=100, message="上次阅读章节标题长度不能超过 100 个字符")
	public String getLastReadChapterTitle() {
		return lastReadChapterTitle;
	}

	public void setLastReadChapterTitle(String lastReadChapterTitle) {
		this.lastReadChapterTitle = lastReadChapterTitle;
	}
	
	@NotNull(message="文章标号不能为空")
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
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