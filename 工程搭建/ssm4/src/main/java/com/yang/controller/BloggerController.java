package com.yang.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.Service.BloggerService;

/**
 * ����Controller��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Resource
	private BloggerService bloggerService;
}
