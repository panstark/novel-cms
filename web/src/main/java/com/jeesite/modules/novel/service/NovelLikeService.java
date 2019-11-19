/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import java.util.List;

import com.jeesite.modules.novel.entity.NovelInfo;
import com.jeesite.modules.novel.entity.NovelLittle;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private NovelLikeDao novelLikeDao;

	@Autowired
	private NovelInfoService novelInfoService;

	@Autowired
	private NovelLittleService novelLittleService;
	
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

    public NovelLike findByNovelAndUserId(String novelId, String userId) {
		NovelLike novelLike = novelLikeDao.findByNovelAndUserId(novelId,userId);

		return novelLike;
    }

	@Transactional(readOnly=false)
	public void likeNovel(NovelLike novelLike) {
		String novelId = novelLike.getNovelId();
		String little = novelLike.getExt1();


//		if(null==novelLikeOld){
//			novelLike.setLikeNum(1);
//			super.save(novelLike);
//			String wxUserId = novelLike.getWxUserId();
//			NovelLike novelLikeOld = novelLikeDao.findByNovelAndUserId(novelId,wxUserId);
		if(StringUtils.equals(little,"little")){
			NovelLittle novelLittle = novelLittleService.get(novelId);
			Integer likeNum= novelLittle.getLikeNum();
			novelLittle.setLikeNum(likeNum+1);
			novelLittleService.update(novelLittle);
		}else{
			NovelInfo novelInfo = novelInfoService.get(novelId);
			Integer likeNum= novelInfo.getLikeNum();
			novelInfo.setLikeNum(likeNum+1);
			novelInfoService.update(novelInfo);
		}
	}

	@Transactional(readOnly=false)
	public void cancelLikeNovel(NovelLike novelLike) {

		String novelId = novelLike.getNovelId();
		String little = novelLike.getExt1();
//		String novelId = novelLike.getNovelId();
//		String wxUserId = novelLike.getWxUserId();
//		NovelLike novelLikeOld = novelLikeDao.findByNovelAndUserId(novelId,wxUserId);
//		if(null!=novelLikeOld){
//			super.delete(novelLikeOld);
//
//			NovelInfo novelInfo = novelInfoService.get(novelId);
//			Integer likeNum= novelInfo.getLikeNum();
//			novelInfo.setLikeNum(likeNum-1);
//			novelInfoService.update(novelInfo);
//		}

		if(StringUtils.equals(little,"little")){
			NovelLittle novelLittle = novelLittleService.get(novelId);
			Integer likeNum= novelLittle.getLikeNum();
			novelLittle.setLikeNum(likeNum-1);
			novelLittleService.update(novelLittle);
		}else{
			NovelInfo novelInfo = novelInfoService.get(novelId);
			Integer likeNum= novelInfo.getLikeNum();
			novelInfo.setLikeNum(likeNum-1);
			novelInfoService.update(novelInfo);
		}
	}


	public NovelInfo novelLikeNum(String novelId, String novelType) {
		NovelInfo novelInfo = new NovelInfo();
		if("little".equals(novelType)){
			NovelLittle novelLittle = novelLittleService.get(novelId);
			novelInfo.setId(novelLittle.getId());
			novelInfo.setLikeNum(novelLittle.getLikeNum());
		}else{
			novelInfo = novelInfoService.get(novelId);
		}
		return novelInfo;
	}
}