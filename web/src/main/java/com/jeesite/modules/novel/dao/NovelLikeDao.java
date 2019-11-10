/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.novel.entity.NovelLike;
import org.apache.ibatis.annotations.Param;

/**
 * 读者喜欢个数表DAO接口
 * @author guoxhe
 * @version 2019-11-04
 */
@MyBatisDao
public interface NovelLikeDao extends CrudDao<NovelLike> {

    NovelLike findByNovelAndUserId(@Param("novelId")String novelId,@Param("userId") String userId);
}