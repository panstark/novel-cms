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
import com.jeesite.modules.user.entity.UserInfoWx;
import com.jeesite.modules.user.service.UserInfoWxService;

/**
 * 微信用户表Controller
 * @author guoxhe
 * @version 2019-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/user/userInfoWx")
public class UserInfoWxController extends BaseController {

	@Autowired
	private UserInfoWxService userInfoWxService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public UserInfoWx get(String id, boolean isNewRecord) {
		return userInfoWxService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("user:userInfoWx:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserInfoWx userInfoWx, Model model) {
		model.addAttribute("userInfoWx", userInfoWx);
		return "modules/user/userInfoWxList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("user:userInfoWx:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<UserInfoWx> listData(UserInfoWx userInfoWx, HttpServletRequest request, HttpServletResponse response) {
		userInfoWx.setPage(new Page<>(request, response));
		Page<UserInfoWx> page = userInfoWxService.findPage(userInfoWx);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("user:userInfoWx:view")
	@RequestMapping(value = "form")
	public String form(UserInfoWx userInfoWx, Model model) {
		model.addAttribute("userInfoWx", userInfoWx);
		return "modules/user/userInfoWxForm";
	}

	/**
	 * 保存微信用户表
	 */
	@RequiresPermissions("user:userInfoWx:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated UserInfoWx userInfoWx) {
		userInfoWxService.save(userInfoWx);
		return renderResult(Global.TRUE, text("保存微信用户表成功！"));
	}
	
	/**
	 * 删除微信用户表
	 */
	@RequiresPermissions("user:userInfoWx:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(UserInfoWx userInfoWx) {
		userInfoWxService.delete(userInfoWx);
		return renderResult(Global.TRUE, text("删除微信用户表成功！"));
	}

	
}