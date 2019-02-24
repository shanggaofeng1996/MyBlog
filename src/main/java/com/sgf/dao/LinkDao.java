package com.sgf.dao;

import java.util.List;
import java.util.Map;

import com.sgf.entity.Link;

/**
 * 友情链接Dao接口
 * @author Administrator
 *
 */
public interface LinkDao {

	/**
	 * 查找友情链接信息
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String,Object> map);

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
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
