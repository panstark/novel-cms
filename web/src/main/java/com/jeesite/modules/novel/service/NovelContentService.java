/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import com.jeesite.modules.common.ChapterEnum;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private NovelContentDao novelContentDao;
	
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


	public NovelContent findNextChapter(String novelId, String number) {
		Integer chapterNum = Integer.valueOf(number);
		Integer nextChapter = chapterNum +1;
		String nextChapterStr = String.valueOf(nextChapter);
		NovelContent novelContent = findChapterByTotalNum(novelId,nextChapterStr);
		if(null==novelContent){
			novelContent = novelContentDao.findLastContentByNovelId(novelId);
			novelContent.setChapterState(ChapterEnum.LASTCHAPTER.getCode());
		}
		return novelContent;
	}

	public NovelContent findPreviousChapter(String novelId, String number) {
		Integer chapterNum = Integer.valueOf(number);
		NovelContent novelContent;
		if(chapterNum<=1){
			novelContent = novelContentDao.findFirstContentByNovelId(novelId);
			novelContent.setChapterState(ChapterEnum.FIRSTCHAPTER.getCode());
		}else{
			Integer nextChapter = chapterNum -1;
			String nextChapterStr = String.valueOf(nextChapter);
			novelContent = findChapterByTotalNum(novelId,nextChapterStr);
		}

		return novelContent;
	}

	private NovelContent findChapterByTotalNum(String novelId,String number) {

		NovelContent novelContent = novelContentDao.findChapterByTotalNum(novelId,number);

		return novelContent;
	}

}