package com.sgf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sgf.dao.LinkDao;
import com.sgf.entity.Link;
import com.sgf.service.LinkService;

/**
 * 友情链接Service实现类
 * @author Administrator
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService{

	@Resource
	private LinkDao linkDao;

	public List<Link> list(Map<String, Object> map) {
		return linkDao.list(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return linkDao.getTotal(map);
	}

	@Override
	public Integer add(Link link) {
		return linkDao.add(link);
	}

	@Override
	public Integer update(Link link) {
		return linkDao.update(link);
	}

	@Override
	public Integer delete(Integer id) {
		return linkDao.delete(id);
	}


}
