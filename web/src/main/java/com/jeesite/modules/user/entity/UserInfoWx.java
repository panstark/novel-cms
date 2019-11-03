/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.user.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 微信用户表Entity
 * @author guoxhe
 * @version 2019-11-03
 */
@Table(name="user_info_wx", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="nick_name", attrName="nickName", label="昵称", queryType=QueryType.LIKE),
		@Column(name="real_name", attrName="realName", label="真实名称", queryType=QueryType.LIKE),
		@Column(name="wx_id", attrName="wxId", label="微信id"),
		@Column(name="avatar_url", attrName="avatarUrl", label="头像路径", isQuery=false),
		@Column(name="gender", attrName="gender", label="状态", comment="状态（0男 1女）"),
		@Column(name="province", attrName="province", label="省"),
		@Column(name="city", attrName="city", label="市"),
		@Column(name="county", attrName="county", label="县"),
		@Column(name="area", attrName="area", label="区"),
		@Column(name="language", attrName="language", label="语言"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="ext1", attrName="ext1", label="备用字段1", isQuery=false),
		@Column(name="ext2", attrName="ext2", label="备用字段2", isQuery=false),
		@Column(name="ext3", attrName="ext3", label="备用字段3", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class UserInfoWx extends DataEntity<UserInfoWx> {
	
	private static final long serialVersionUID = 1L;
	private String nickName;		// 昵称
	private String realName;		// 真实名称
	private String wxId;		// 微信id
	private String avatarUrl;		// 头像路径
	private String gender;		// 状态（0男 1女）
	private String province;		// 省
	private String city;		// 市
	private String county;		// 县
	private String area;		// 区
	private String language;		// 语言
	private String ext1;		// 备用字段1
	private String ext2;		// 备用字段2
	private String ext3;		// 备用字段3
	
	public UserInfoWx() {
		this(null);
	}

	public UserInfoWx(String id){
		super(id);
	}
	
	@NotBlank(message="昵称不能为空")
	@Length(min=0, max=64, message="昵称长度不能超过 64 个字符")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@NotBlank(message="真实名称不能为空")
	@Length(min=0, max=64, message="真实名称长度不能超过 64 个字符")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Length(min=0, max=64, message="微信id长度不能超过 64 个字符")
	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	
	@Length(min=0, max=600, message="头像路径长度不能超过 600 个字符")
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	@Length(min=0, max=1, message="状态长度不能超过 1 个字符")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@NotBlank(message="省不能为空")
	@Length(min=0, max=64, message="省长度不能超过 64 个字符")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=64, message="市长度不能超过 64 个字符")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=64, message="县长度不能超过 64 个字符")
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
	@Length(min=0, max=64, message="区长度不能超过 64 个字符")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=64, message="语言长度不能超过 64 个字符")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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