/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.novel.entity.NovelLittle;
import com.jeesite.modules.novel.dao.NovelLittleDao;

/**
 * 短篇小说Service
 * @author guoxhe
 * @version 2019-11-03
 */
@Service
@Transactional(readOnly=true)
public class NovelLittleService extends CrudService<NovelLittleDao, NovelLittle> {
	
	/**
	 * 获取单条数据
	 * @param novelLittle
	 * @return
	 */
	@Override
	public NovelLittle get(NovelLittle novelLittle) {
		return super.get(novelLittle);
	}
	
	/**
	 * 查询分页数据
	 * @param novelLittle 查询条件
	 * @param novelLittle.page 分页对象
	 * @return
	 */
	@Override
	public Page<NovelLittle> findPage(NovelLittle novelLittle) {
		return super.findPage(novelLittle);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param novelLittle
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(NovelLittle novelLittle) {
		super.save(novelLittle);
	}
	
	/**
	 * 更新状态
	 * @param novelLittle
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(NovelLittle novelLittle) {
		super.updateStatus(novelLittle);
	}
	
	/**
	 * 删除数据
	 * @param novelLittle
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(NovelLittle novelLittle) {
		super.delete(novelLittle);
	}
	
}