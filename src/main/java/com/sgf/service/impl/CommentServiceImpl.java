package com.sgf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sgf.dao.CommentDao;
import com.sgf.entity.Comment;
import com.sgf.service.CommentService;

/**
 * 评论Service实现类
 * @author Administrator
 *
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Resource
	private CommentDao commentDao;

	public List<Comment> list(Map<String, Object> map) {
		return commentDao.list(map);
	}

	public int add(Comment comment) {
		return commentDao.add(comment);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return commentDao.getTotal(map);
	}

	@Override
	public int update(Comment comment) {
		return commentDao.update(comment);
	}

	@Override
	public Integer delete(Integer id) {
		return commentDao.delete(id);
	}


}
