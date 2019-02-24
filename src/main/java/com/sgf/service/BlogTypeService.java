package com.sgf.service;

import java.util.List;
import java.util.Map;

import com.sgf.entity.BlogType;

/**
 * 博客类型Service接口
 * @author Administrator
 *
 */
public interface BlogTypeService {

	/**
	 * 查询所有博客类型，以及对应的博客数量
	 * @return
	 */
	public List<BlogType> countList();

	/**
	 * 获取分页的博客类别信息
	 * @param map
	 * @return
	 */
	public List<BlogType> list(Map<String,Object> map);

	/**
	 * 博客类别的总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);

	/**
	 * 添加博客类别
	 * @param blogType
	 * @return
	 */
	public Integer addBlogType(BlogType blogType);

	/**
	 * 修改博客类别
	 * @param blogType
	 * @return
	 */
	public Integer updateBlogType(BlogType blogType);

	/**
	 * 通过id来删除指定博客
	 * @param id
	 * @return
	 */
	public Integer deleteBlogType(Integer id);


}

