/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.user.entity.UserReadLog;
import com.jeesite.modules.user.dao.UserReadLogDao;

/**
 * 读者阅读记录Service
 * @author guoxiaohe
 * @version 2019-11-04
 */
@Service
@Transactional(readOnly=true)
public class UserReadLogService extends CrudService<UserReadLogDao, UserReadLog> {
	
	/**
	 * 获取单条数据
	 * @param userReadLog
	 * @return
	 */
	@Override
	public UserReadLog get(UserReadLog userReadLog) {
		return super.get(userReadLog);
	}
	
	/**
	 * 查询分页数据
	 * @param userReadLog 查询条件
	 * @param userReadLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<UserReadLog> findPage(UserReadLog userReadLog) {
		return super.findPage(userReadLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param userReadLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(UserReadLog userReadLog) {
		super.save(userReadLog);
	}
	
	/**
	 * 更新状态
	 * @param userReadLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(UserReadLog userReadLog) {
		super.updateStatus(userReadLog);
	}
	
	/**
	 * 删除数据
	 * @param userReadLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(UserReadLog userReadLog) {
		super.delete(userReadLog);
	}
	
}