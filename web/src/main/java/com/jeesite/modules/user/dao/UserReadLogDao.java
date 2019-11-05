/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.user.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.user.entity.UserReadLog;
import org.apache.ibatis.annotations.Param;

/**
 * 读者阅读记录DAO接口
 * @author guoxiaohe
 * @version 2019-11-04
 */
@MyBatisDao
public interface UserReadLogDao extends CrudDao<UserReadLog> {

    UserReadLog findReadLogByBook(@Param("userId")String userId, @Param("novelId")String novelId);
}