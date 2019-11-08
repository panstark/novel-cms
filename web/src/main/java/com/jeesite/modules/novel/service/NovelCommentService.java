/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.novel.entity.NovelComment;
import com.jeesite.modules.novel.dao.NovelCommentDao;

/**
 * 读者评论表Service
 * @author guoxhe
 * @version 2019-11-03
 */
@Service
@Transactional(readOnly=true)
public class NovelCommentService extends CrudService<NovelCommentDao, NovelComment> {

	@Autowired
	private NovelCommentDao novelCommentDao;
	
	/**
	 * 获取单条数据
	 * @param novelComment
	 * @return
	 */
	@Override
	public NovelComment get(NovelComment novelComment) {
		return super.get(novelComment);
	}
	
	/**
	 * 查询分页数据
	 * @param novelComment 查询条件
	 * @return
	 */
	@Override
	public Page<NovelComment> findPage(NovelComment novelComment) {
		return super.findPage(novelComment);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param novelComment
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(NovelComment novelComment) {
		super.save(novelComment);
	}
	
	/**
	 * 更新状态
	 * @param novelComment
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(NovelComment novelComment) {
		super.updateStatus(novelComment);
	}
	
	/**
	 * 删除数据
	 * @param novelComment
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(NovelComment novelComment) {
		super.delete(novelComment);
	}

	public List<NovelComment> findCommentList(String novelId, String page, String num) {
		List<NovelComment> comments = novelCommentDao.findCommentList(novelId,page,num);
		return comments;
	}
}