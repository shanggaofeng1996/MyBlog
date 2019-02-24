package com.sgf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sgf.dao.BlogTypeDao;
import com.sgf.entity.BlogType;
import com.sgf.service.BlogTypeService;

/**
 * 博客类型Service实现类
 * @author Administrator
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService{

	@Resource
	private BlogTypeDao blogTypeDao;

	public List<BlogType> countList() {
		return blogTypeDao.countList();
	}

	public List<BlogType> list(Map<String,Object> map){
		return blogTypeDao.list(map);
	}

	public Long getTotal(Map<String,Object> map){
		return blogTypeDao.getTotal(map);
	}

	@Override
	public Integer addBlogType(BlogType blogType) {
		return blogTypeDao.addBlogType(blogType);
	}

	@Override
	public Integer updateBlogType(BlogType blogType) {
		return blogTypeDao.updateBlogType(blogType);
	}

	@Override
	public Integer deleteBlogType(Integer id) {
		return blogTypeDao.deleteBlogType(id);
	}

}
