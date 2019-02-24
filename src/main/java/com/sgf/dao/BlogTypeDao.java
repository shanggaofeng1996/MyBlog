package com.sgf.dao;

import java.util.List;
import java.util.Map;

import com.sgf.entity.BlogType;

/**
 * 博客类型Dao接口
 * @author Administrator
 *
 */
public interface BlogTypeDao {

	/**
	 * 查询所有博客类型，以及对应的博客数量
	 * @return
	 */
	public List<BlogType> countList();

	/**
	 * 通过id查找博客类型实体
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);

	/**
	 * 分页查询博客蕾蕾信息
	 * @return
	 */
	public List<BlogType> list(Map<String,Object> map);

	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public  Long getTotal(Map<String,Object> map);

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
