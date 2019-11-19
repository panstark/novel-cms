/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import com.jeesite.modules.common.enums.ChapterEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.novel.entity.NovelContent;
import com.jeesite.modules.novel.dao.NovelContentDao;

import java.util.ArrayList;
import java.util.List;

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


	public NovelContent findNextChapter(String novelId, Integer number) {
		Integer nextChapter = number +1;
		NovelContent novelContent = findChapterByTotalNum(novelId,nextChapter);
		if(null==novelContent){
			novelContent = novelContentDao.findLastContentByNovelId(novelId);
			novelContent.setChapterState(ChapterEnum.LASTCHAPTER.getCode());
		}
		return novelContent;
	}

	public NovelContent findPreviousChapter(String novelId, Integer number) {

		NovelContent novelContent;
		if(number<=1){
			novelContent = novelContentDao.findFirstContentByNovelId(novelId);
			novelContent.setChapterState(ChapterEnum.FIRSTCHAPTER.getCode());
		}else{
			Integer nextChapter = number -1;
			novelContent = findChapterByTotalNum(novelId,nextChapter);
		}

		return novelContent;
	}

	private NovelContent findChapterByTotalNum(String novelId,Integer number) {

		NovelContent novelContent = novelContentDao.findChapterByTotalNum(novelId,number);

		return novelContent;
	}

    public NovelContent findNovelContentById(String chapterId) {
		//获取本章节内容
		NovelContent novelContent = get(chapterId);

		return novelContent;
    }

	@Transactional(readOnly=false)
	public void saveNovelContent(NovelContent novelContent) {
		String novelId = novelContent.getNovelId();
		NovelContent novelContentLast = novelContentDao.findLastContentByNovelId(novelId);
		if(null!=novelContentLast){
			novelContent.setPreviousChapterId(novelContentLast.getId());
			novelContent.setIsLast(ChapterEnum.LASTCHAPTER.getCode());
			if(null==novelContent.getTotalNum()){
				novelContent.setTotalNum(novelContentLast.getTotalNum()+1);
			}
		}else{
			novelContent.setTotalNum(1);
			novelContent.setIsLast(ChapterEnum.FIRSTCHAPTER.getCode());
		}

		super.save(novelContent);

		//更新上一条小说内容
		if(null!=novelContentLast){
			if(!ChapterEnum.FIRSTCHAPTER.getCode().equals(novelContentLast.getIsLast())){
				novelContentLast.setIsLast("");
			}
			novelContentLast.setNextChapterId(novelContent.getId());
			super.update(novelContentLast);
		}

	}

	public void setData(NovelContent novelContent) {
		if(StringUtils.isNotBlank(novelContent.getId())){
			return;
		}
		String novelId = novelContent.getNovelId();
		if(StringUtils.isBlank(novelId)) {
			return;
		}
		NovelContent novelContentLast = novelContentDao.findLastContentByNovelId(novelId);
		NovelContent previousNovelContent = get(novelContentLast.getId());
		if(null==previousNovelContent){
			return;
		}
		novelContent.setTotalNum(previousNovelContent.getTotalNum()+1);
		novelContent.setChapter(previousNovelContent.getChapter()+1);
		novelContent.setBigChapter(previousNovelContent.getBigChapter());
		novelContent.setChapterStr("第章");
		novelContent.setBigChapterStr(previousNovelContent.getBigChapterStr());
	}


	public List<String> findNovelChapterList(String novelId) {
		Integer count= novelContentDao.findChapterCount(novelId);
		List<String> chapterScopeList = new ArrayList<>();
		if(0==count){
			String chapterScope = "1-20";
			chapterScopeList.add(chapterScope);
			return chapterScopeList;
		}


		Integer scope = count%20==0?count/20:count/20+1;
        for(int i=0;i<scope;i++){
        	String chaperOne = (i*20+1)+"-"+(i*20+20);
			chapterScopeList.add(chaperOne);
		}

		return chapterScopeList;
	}

	public List<NovelContent> findNovelChapterByScope(String novelId,String scope) {
		String page = "0";
		if(null!=scope){
		  page = scope.split("-")[0];
		}
		List<NovelContent> listNovel = novelContentDao.findChapterByScope(novelId,Integer.valueOf(page)-1);

		return listNovel;
	}
}