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
import com.jeesite.modules.novel.entity.NovelComment;
import com.jeesite.modules.novel.service.NovelCommentService;

import java.util.List;

/**
 * 读者评论表Controller
 * @author guoxhe
 * @version 2019-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/novel/novelComment")
public class NovelCommentController extends BaseController {

	@Autowired
	private NovelCommentService novelCommentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NovelComment get(String id, boolean isNewRecord) {
		return novelCommentService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("novel:novelComment:view")
	@RequestMapping(value = {"list", ""})
	public String list(NovelComment novelComment, Model model) {
		model.addAttribute("novelComment", novelComment);
		return "modules/novel/novelCommentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("novel:novelComment:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NovelComment> listData(NovelComment novelComment, HttpServletRequest request, HttpServletResponse response) {
		novelComment.setPage(new Page<>(request, response));
		Page<NovelComment> page = novelCommentService.findPage(novelComment);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("novel:novelComment:view")
	@RequestMapping(value = "form")
	public String form(NovelComment novelComment, Model model) {
		model.addAttribute("novelComment", novelComment);
		return "modules/novel/novelCommentForm";
	}

	/**
	 * 保存读者评论表
	 */

	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NovelComment novelComment) {
		novelCommentService.save(novelComment);
		return renderResult(Global.TRUE, text("保存读者评论表成功！"));
	}
	
	/**
	 * 删除读者评论表
	 */
	@RequiresPermissions("novel:novelComment:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NovelComment novelComment) {
		novelCommentService.delete(novelComment);
		return renderResult(Global.TRUE, text("删除读者评论表成功！"));
	}

	/**
	 * 保存读者评论表
	 */
	@PostMapping(value = "comment")
	@ResponseBody
	public String comment(@RequestBody NovelComment novelComment) {
		novelCommentService.save(novelComment);
		return "{code:000}";
	}

	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "list-conments")
	@ResponseBody
	public List<NovelComment> list(@RequestParam("novelId") String novelId,@RequestParam("pageNum")  Integer pageNum,@RequestParam("pageSize") Integer pageSize) {

		List<NovelComment> comments = novelCommentService.findCommentList(novelId,pageNum,pageSize);

		return comments;
	}
	
}