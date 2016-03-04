package com.hantian.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName: DaoImpl
 * @Description: 基本数据访问层用户注入jdbcTemplate
 * @author maybo
 * @date 2016年3月2日 上午11:20:22
 *
 */
public class DaoImpl {
	/**
	 * @Fields jdbcTemplate :jdbc数据访问模版类
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
