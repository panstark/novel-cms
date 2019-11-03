/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.user.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.user.entity.UserInfoWx;

/**
 * 微信用户表DAO接口
 * @author guoxhe
 * @version 2019-11-03
 */
@MyBatisDao
public interface UserInfoWxDao extends CrudDao<UserInfoWx> {
	
}