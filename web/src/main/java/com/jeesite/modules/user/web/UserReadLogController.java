/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.user.web;

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
import com.jeesite.modules.user.entity.UserReadLog;
import com.jeesite.modules.user.service.UserReadLogService;

/**
 * 读者阅读记录Controller
 * @author guoxiaohe
 * @version 2019-11-04
 */
@Controller
@RequestMapping(value = "${adminPath}/user/userReadLog")
public class UserReadLogController extends BaseController {

	@Autowired
	private UserReadLogService userReadLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserReadLog get(String id, boolean isNewRecord) {
		return userReadLogService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("user:userReadLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserReadLog userReadLog, Model model) {
		model.addAttribute("userReadLog", userReadLog);
		return "modules/user/userReadLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("user:userReadLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserReadLog> listData(UserReadLog userReadLog, HttpServletRequest request, HttpServletResponse response) {
		userReadLog.setPage(new Page<>(request, response));
		Page<UserReadLog> page = userReadLogService.findPage(userReadLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("user:userReadLog:view")
	@RequestMapping(value = "form")
	public String form(UserReadLog userReadLog, Model model) {
		model.addAttribute("userReadLog", userReadLog);
		return "modules/user/userReadLogForm";
	}

	/**
	 * 保存读者阅读记录
	 */
	@RequiresPermissions("user:userReadLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserReadLog userReadLog) {
		userReadLogService.save(userReadLog);
		return renderResult(Global.TRUE, text("保存读者阅读记录成功！"));
	}
	
	/**
	 * 删除读者阅读记录
	 */
	@RequiresPermissions("user:userReadLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserReadLog userReadLog) {
		userReadLogService.delete(userReadLog);
		return renderResult(Global.TRUE, text("删除读者阅读记录成功！"));
	}
	
}