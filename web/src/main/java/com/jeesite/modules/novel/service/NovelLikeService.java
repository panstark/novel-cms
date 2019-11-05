/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.novel.entity.NovelLike;
import com.jeesite.modules.novel.dao.NovelLikeDao;

/**
 * 读者喜欢个数表Service
 * @author guoxhe
 * @version 2019-11-04
 */
@Service
@Transactional(readOnly=true)
public class NovelLikeService extends CrudService<NovelLikeDao, NovelLike> {
	
	/**
	 * 获取单条数据
	 * @param novelLike
	 * @return
	 */
	@Override
	public NovelLike get(NovelLike novelLike) {
		return super.get(novelLike);
	}
	
	/**
	 * 查询分页数据
	 * @param novelLike 查询条件
	 * @param novelLike.page 分页对象
	 * @return
	 */
	@Override
	public Page<NovelLike> findPage(NovelLike novelLike) {
		return super.findPage(novelLike);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param novelLike
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(NovelLike novelLike) {
		super.save(novelLike);
	}
	
	/**
	 * 更新状态
	 * @param novelLike
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(NovelLike novelLike) {
		super.updateStatus(novelLike);
	}
	
	/**
	 * 删除数据
	 * @param novelLike
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(NovelLike novelLike) {
		super.delete(novelLike);
	}
	
}