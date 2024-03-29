/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.novel.entity.NovelContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 小说内容表DAO接口
 * @author guoxhe
 * @version 2019-11-03
 */
@MyBatisDao
public interface NovelContentDao extends CrudDao<NovelContent> {

    NovelContent findLastContentByNovelId(String novelId);

    NovelContent findFirstContentByNovelId(String novelId);

    NovelContent findChapterByTotalNum(@Param("novelId")String novelId, @Param("number") Integer number);

    Integer findChapterCount(String novelId);

    List<NovelContent> findChapterByScope(@Param("novelId")String novelId, @Param("page")Integer page);
}