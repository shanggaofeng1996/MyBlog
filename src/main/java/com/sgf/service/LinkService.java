package com.sgf.service;

import java.util.List;
import java.util.Map;

import com.sgf.entity.Link;

/**
 * 友情链接Service接口
 * @author Administrator
 *
 */
public interface LinkService {

	/**
	 * 查找友情链接信息
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String,Object> map);
	public Long getTotal(Map<String,Object> map);

	/**
	 * 添加友情链接
	 * @param link
	 * @return
	 */
	public Integer add(Link link);

	/**
	 * 更新友情链接
	 * @param link
	 * @return
	 */
	public Integer update(Link link);

	/**
	 * 根据ID删除友情链接
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);

}
