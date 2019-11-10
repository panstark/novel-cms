/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import java.util.List;

import com.jeesite.modules.novel.dao.NovelContentDao;
import com.jeesite.modules.novel.entity.NovelContent;
import com.jeesite.modules.user.dao.UserReadLogDao;
import com.jeesite.modules.user.entity.UserReadLog;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private NovelInfoDao novelInfoDao;
	@Autowired
	private NovelContentDao novelContentDao;
	@Autowired
	private UserReadLogDao userReadLogDao;
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


	/**
	 * 获取简介页面的内容
	 * @param userId
	 * @return
	 */
	public NovelInfo findfirstNovelAndContent(String userId) {
		NovelInfo novelInfo = novelInfoDao.findFirstNovel();

		//获取读者本小说的阅读章节
		String novelId = novelInfo.getId();
		UserReadLog userReadLog = userReadLogDao.findReadLogByBook(userId,novelId);
		if(null!=userReadLog){
			novelInfo.setUserReadChapterId(userReadLog.getLastReadChapterId());
			novelInfo.setUserReadChapterTitle(userReadLog.getLastReadChapterTitle());
		}else{
			//获取第一个章节
			NovelContent novelContent = novelContentDao.findFirstContentByNovelId(novelId);
			if(null!=novelContent){
				novelInfo.setUserReadChapterId(novelContent.getId());
				novelInfo.setUserReadChapterTitle(novelContent.getTitle());
			}
		}

		//获取最新章节
		NovelContent novelContent = novelContentDao.findLastContentByNovelId(novelId);
		if(null!=novelContent) {
			novelInfo.setLatestChapterId(novelContent.getId());
			novelInfo.setLatestChapterTitle(novelContent.getTitle());
		}

		return novelInfo;
	}
}