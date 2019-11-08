/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.novel.entity.NovelComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 读者评论表DAO接口
 * @author guoxhe
 * @version 2019-11-03
 */
@MyBatisDao
public interface NovelCommentDao extends CrudDao<NovelComment> {

    List<NovelComment> findCommentList(@Param("novelId")String novelId,@Param("page") String page,@Param("num") String num);
}