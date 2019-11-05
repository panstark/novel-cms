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
import com.jeesite.modules.novel.entity.NovelLittle;
import com.jeesite.modules.novel.service.NovelLittleService;

/**
 * 短篇小说Controller
 * @author guoxhe
 * @version 2019-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/novel/novelLittle")
public class NovelLittleController extends BaseController {

	@Autowired
	private NovelLittleService novelLittleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NovelLittle get(String id, boolean isNewRecord) {
		return novelLittleService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("novel:novelLittle:view")
	@RequestMapping(value = {"list", ""})
	public String list(NovelLittle novelLittle, Model model) {
		model.addAttribute("novelLittle", novelLittle);
		return "modules/novel/novelLittleList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("novel:novelLittle:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NovelLittle> listData(NovelLittle novelLittle, HttpServletRequest request, HttpServletResponse response) {
		novelLittle.setPage(new Page<>(request, response));
		Page<NovelLittle> page = novelLittleService.findPage(novelLittle);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("novel:novelLittle:view")
	@RequestMapping(value = "form")
	public String form(NovelLittle novelLittle, Model model) {
		model.addAttribute("novelLittle", novelLittle);
		return "modules/novel/novelLittleForm";
	}

	/**
	 * 保存短篇小说
	 */
	@RequiresPermissions("novel:novelLittle:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NovelLittle novelLittle) {
		novelLittleService.save(novelLittle);
		return renderResult(Global.TRUE, text("保存短篇小说成功！"));
	}
	
	/**
	 * 删除短篇小说
	 */
	@RequiresPermissions("novel:novelLittle:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NovelLittle novelLittle) {
		novelLittleService.delete(novelLittle);
		return renderResult(Global.TRUE, text("删除短篇小说成功！"));
	}

	///classic/latest
    @RequestMapping(value = "first")
    @ResponseBody
    public NovelLittle findfirstNovel() {
	    return novelLittleService.findFirstNovel();
    }

    @RequestMapping(value = "next/{num}")
    @ResponseBody
    public NovelLittle findNextNovel(@PathVariable(name="num") String num) {
        return novelLittleService.findNextNovel(num);
    }

    @RequestMapping(value = "previous/{num}")
    @ResponseBody
    public NovelLittle findPreviousNovel(@PathVariable(name="num") String num) {
        return novelLittleService.findPreviousNovel(num);
    }

    @RequestMapping(value = "detail/{id}")
    @ResponseBody
    public NovelLittle findNovelLittleDetail(@PathVariable(name="id") String id) {
        return novelLittleService.get(id);
    }

//    @RequestMapping(value = "favor/id")
//    @ResponseBody
//    public NovelLittle findNovelFavor(String userId,String id) {
//        return novelLittleService.findNovelFavor(id,userId);
//    }


	
}