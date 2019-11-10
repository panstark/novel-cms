/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.novel.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.novel.entity.NovelLike;
import com.jeesite.modules.novel.service.NovelLikeService;

/**
 * 读者喜欢个数表Controller
 * @author guoxhe
 * @version 2019-11-04
 */
@Controller
@RequestMapping(value = "${adminPath}/novel/novelLike")
public class NovelLikeController extends BaseController {

	@Autowired
	private NovelLikeService novelLikeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NovelLike get(String id, boolean isNewRecord) {
		return novelLikeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("novel:novelLike:view")
	@RequestMapping(value = {"list", ""})
	public String list(NovelLike novelLike, Model model) {
		model.addAttribute("novelLike", novelLike);
		return "modules/novel/novelLikeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("novel:novelLike:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NovelLike> listData(NovelLike novelLike, HttpServletRequest request, HttpServletResponse response) {
		novelLike.setPage(new Page<>(request, response));
		Page<NovelLike> page = novelLikeService.findPage(novelLike);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("novel:novelLike:view")
	@RequestMapping(value = "form")
	public String form(NovelLike novelLike, Model model) {
		model.addAttribute("novelLike", novelLike);
		return "modules/novel/novelLikeForm";
	}

	/**
	 * 保存读者喜欢个数表
	 */
	@RequiresPermissions("novel:novelLike:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NovelLike novelLike) {
		novelLikeService.save(novelLike);
		return renderResult(Global.TRUE, text("保存读者喜欢个数表成功！"));
	}
	
	/**
	 * 删除读者喜欢个数表
	 */
	@RequiresPermissions("novel:novelLike:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NovelLike novelLike) {
		novelLikeService.delete(novelLike);
		return renderResult(Global.TRUE, text("删除读者喜欢个数表成功！"));
	}

	@RequestMapping(value = "find-by-novel-user-id")
	@ResponseBody
	public NovelLike findByNovelAndUserId(@RequestParam("novelId") String novelId,@RequestParam("userId") String userId) {
		return novelLikeService.findByNovelAndUserId(novelId,userId);
	}

	@RequestMapping(value = "like")
	@ResponseBody
	public void like(@RequestBody NovelLike novelLike) {
		novelLikeService.likeNovel(novelLike);
	}

	@RequestMapping(value = "like/cancel")
	@ResponseBody
	public void likeCancel(@RequestBody NovelLike novelLike) {
		 novelLikeService.cancelLikeNovel(novelLike);
	}
}