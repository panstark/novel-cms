/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.user.entity.UserInfoWx;
import com.jeesite.modules.user.dao.UserInfoWxDao;

/**
 * 微信用户表Service
 * @author guoxhe
 * @version 2019-11-03
 */
@Service
@Transactional(readOnly=true)
public class UserInfoWxService extends CrudService<UserInfoWxDao, UserInfoWx> {
	
	/**
	 * 获取单条数据
	 * @param userInfoWx
	 * @return
	 */
	@Override
	public UserInfoWx get(UserInfoWx userInfoWx) {
		return super.get(userInfoWx);
	}
	
	/**
	 * 查询分页数据
	 * @param userInfoWx 查询条件
	 * @param userInfoWx.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserInfoWx> findPage(UserInfoWx userInfoWx) {
		return super.findPage(userInfoWx);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userInfoWx
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(UserInfoWx userInfoWx) {
		super.save(userInfoWx);
	}
	
	/**
	 * 更新状态
	 * @param userInfoWx
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(UserInfoWx userInfoWx) {
		super.updateStatus(userInfoWx);
	}
	
	/**
	 * 删除数据
	 * @param userInfoWx
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(UserInfoWx userInfoWx) {
		super.delete(userInfoWx);
	}
	
}