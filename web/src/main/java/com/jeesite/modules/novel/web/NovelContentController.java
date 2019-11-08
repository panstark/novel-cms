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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.novel.entity.NovelContent;
import com.jeesite.modules.novel.service.NovelContentService;

/**
 * 小说内容表Controller
 * @author guoxhe
 * @version 2019-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/novel/novelContent")
public class NovelContentController extends BaseController {

	@Autowired
	private NovelContentService novelContentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NovelContent get(String id, boolean isNewRecord) {
		return novelContentService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("novel:novelContent:view")
	@RequestMapping(value = {"list", ""})
	public String list(NovelContent novelContent, Model model) {
		model.addAttribute("novelContent", novelContent);
		return "modules/novel/novelContentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("novel:novelContent:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NovelContent> listData(NovelContent novelContent, HttpServletRequest request, HttpServletResponse response) {
		novelContent.setPage(new Page<>(request, response));
		Page<NovelContent> page = novelContentService.findPage(novelContent);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("novel:novelContent:view")
	@RequestMapping(value = "form")
	public String form(NovelContent novelContent, Model model) {
		model.addAttribute("novelContent", novelContent);
		return "modules/novel/novelContentForm";
	}

	/**
	 * 保存小说内容表
	 */
	@RequiresPermissions("novel:novelContent:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NovelContent novelContent) {
		novelContentService.save(novelContent);
		return renderResult(Global.TRUE, text("保存小说内容表成功！"));
	}
	
	/**
	 * 删除小说内容表
	 */
	@RequiresPermissions("novel:novelContent:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NovelContent novelContent) {
		novelContentService.delete(novelContent);
		return renderResult(Global.TRUE, text("删除小说内容表成功！"));
	}

	@RequestMapping(value = "findNextChapter")
	@ResponseBody
	public NovelContent findNextChapter(String novelId,String number) {
		return novelContentService.findNextChapter(novelId,number);
	}

	@RequestMapping(value = "findpreviousChapter")
	@ResponseBody
	public NovelContent findpreviousChapter(String novelId,String number) {
		return novelContentService.findPreviousChapter(novelId,number);
	}
	
}