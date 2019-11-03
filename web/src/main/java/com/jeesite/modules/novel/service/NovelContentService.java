/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.novel.entity.NovelContent;
import com.jeesite.modules.novel.dao.NovelContentDao;

/**
 * 小说内容表Service
 * @author guoxhe
 * @version 2019-11-03
 */
@Service
@Transactional(readOnly=true)
public class NovelContentService extends CrudService<NovelContentDao, NovelContent> {
	
	/**
	 * 获取单条数据
	 * @param novelContent
	 * @return
	 */
	@Override
	public NovelContent get(NovelContent novelContent) {
		return super.get(novelContent);
	}
	
	/**
	 * 查询分页数据
	 * @param novelContent 查询条件
	 * @param novelContent.page 分页对象
	 * @return
	 */
	@Override
	public Page<NovelContent> findPage(NovelContent novelContent) {
		return super.findPage(novelContent);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param novelContent
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(NovelContent novelContent) {
		super.save(novelContent);
	}
	
	/**
	 * 更新状态
	 * @param novelContent
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(NovelContent novelContent) {
		super.updateStatus(novelContent);
	}
	
	/**
	 * 删除数据
	 * @param novelContent
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(NovelContent novelContent) {
		super.delete(novelContent);
	}
	
}