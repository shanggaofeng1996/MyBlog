package com.sgf.dao;

import java.util.List;
import java.util.Map;

import com.sgf.entity.Comment;
import javafx.beans.binding.ObjectBinding;

/**
 * 评论Dao接口
 * @author Administrator
 *
 */
public interface CommentDao {

	/**
	 * 查询用户评论信息
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String,Object> map);

	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public int add(Comment comment);

	/**
	 * 获取评论的总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 更新博客状态
	 * @param comment
	 * @return
	 */
	public int  update(Comment comment);

	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
