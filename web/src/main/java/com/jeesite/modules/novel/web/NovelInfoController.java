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
import com.jeesite.modules.novel.entity.NovelInfo;
import com.jeesite.modules.novel.service.NovelInfoService;

/**
 * 小说标题表Controller
 * @author guoxhe
 * @version 2019-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/novel/novelInfo")
public class NovelInfoController extends BaseController {

	@Autowired
	private NovelInfoService novelInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NovelInfo get(String id, boolean isNewRecord) {
		return novelInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("novel:novelInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(NovelInfo novelInfo, Model model) {
		model.addAttribute("novelInfo", novelInfo);
		return "modules/novel/novelInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("novel:novelInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NovelInfo> listData(NovelInfo novelInfo, HttpServletRequest request, HttpServletResponse response) {
		novelInfo.setPage(new Page<>(request, response));
		Page<NovelInfo> page = novelInfoService.findPage(novelInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("novel:novelInfo:view")
	@RequestMapping(value = "form")
	public String form(NovelInfo novelInfo, Model model) {
		model.addAttribute("novelInfo", novelInfo);
		return "modules/novel/novelInfoForm";
	}

	/**
	 * 保存小说标题表
	 */
	@RequiresPermissions("novel:novelInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NovelInfo novelInfo) {
		novelInfoService.save(novelInfo);
		return renderResult(Global.TRUE, text("保存小说标题表成功！"));
	}
	
	/**
	 * 删除小说标题表
	 */
	@RequiresPermissions("novel:novelInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NovelInfo novelInfo) {
		novelInfoService.delete(novelInfo);
		return renderResult(Global.TRUE, text("删除小说标题表成功！"));
	}
	
}