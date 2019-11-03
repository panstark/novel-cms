/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.novel.entity.NovelInfo;
import com.jeesite.modules.novel.dao.NovelInfoDao;

/**
 * 小说标题表Service
 * @author guoxhe
 * @version 2019-11-03
 */
@Service
@Transactional(readOnly=true)
public class NovelInfoService extends CrudService<NovelInfoDao, NovelInfo> {
	
	/**
	 * 获取单条数据
	 * @param novelInfo
	 * @return
	 */
	@Override
	public NovelInfo get(NovelInfo novelInfo) {
		return super.get(novelInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param novelInfo 查询条件
	 * @param novelInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<NovelInfo> findPage(NovelInfo novelInfo) {
		return super.findPage(novelInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param novelInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(NovelInfo novelInfo) {
		super.save(novelInfo);
	}
	
	/**
	 * 更新状态
	 * @param novelInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(NovelInfo novelInfo) {
		super.updateStatus(novelInfo);
	}
	
	/**
	 * 删除数据
	 * @param novelInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(NovelInfo novelInfo) {
		super.delete(novelInfo);
	}
	
}