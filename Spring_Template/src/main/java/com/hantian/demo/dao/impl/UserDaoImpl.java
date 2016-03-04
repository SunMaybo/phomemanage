package com.hantian.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hantian.demo.dao.IUserDao;
import com.hantian.demo.pojo.SearchForm;
import com.hantian.demo.pojo.User;

/**
 * @ClassName: UserDaoImpl
 * @Description: 对用户表的底层操作类
 * @author maybo
 * @date 2016年3月2日 上午11:09:22
 *
 */
@Repository("userDao")
public class UserDaoImpl extends DaoImpl implements IUserDao {
	/*
	 * <p>Title: saveOrUpdate</p> <p>Description: </p>
	 * 
	 * @param user
	 * 
	 * @see
	 * com.hantian.demo.dao.impl.IUserDao#saveOrUpdate(com.hantian.demo.pojo
	 * .User)
	 */
	@Override
	public void saveOrUpdate(User user) {
		String sql = "";
		if (null==user.getId()||user.getId() <= 0) {
			sql += "insert into client(name,work_number,email,phone,sex,department,position,status,version,create_time)values(?,?,?,?,?,?,?,?,?,?)";
			this.getJdbcTemplate().update(
					sql,
					new Object[] { user.getName(), user.getWorkNumber(),
							user.getEmail(), user.getPhone(), user.getSex(),
							user.getDepartment().getId(), user.getPosition(),
							user.getStatus(), user.getVersion(),
							user.getCreateTime() });
		} else {
			sql += "update client set name=?,work_number=?,email=?,phone=?,sex=?,department=?,position=?,status=?,version=?,create_time=? where id=?";
			this.getJdbcTemplate().update(
					sql,
					new Object[] { user.getName(), user.getWorkNumber(),
							user.getEmail(), user.getPhone(), user.getSex(),
							user.getDepartment().getId(), user.getPosition(),
							user.getStatus(), user.getVersion(),
							user.getCreateTime(), user.getId() });
		}

	}

	/*
	 * <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @see com.hantian.demo.dao.impl.IUserDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		String sql = "delete from client where id=?";
		this.getJdbcTemplate().update(sql, new Object[] { id });
	}

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * <p>Title: findById</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.hantian.demo.dao.impl.IUserDao#findById(int)
	 */
	@Override
	public User findById(int id) {
		User user = this
				.getJdbcTemplate()
				.queryForObject(
						"select c.*,d.id as d_id,d.name as d_name from client c left join department d on c.department=d.id where c.id=?",
						new Object[] { id }, new UserRowMapper<User>());
		return user;
	}

	/*
	 * <p>Title: list</p> <p>Description: </p>
	 * 
	 * @param searchForm
	 * 
	 * @return
	 * 
	 * @see
	 * com.hantian.demo.dao.impl.IUserDao#list(com.hantian.demo.pojo.SearchForm)
	 */
	@Override
	public Map<String, Object> list(SearchForm searchForm) {
		String sql = "";
		List<User> users = null;
		if (null == searchForm) {
			sql += "select c.*,d.id as d_id,d.name as d_name from client c left join department d on c.department=d.id";
			users = this.getJdbcTemplate()
					.query(sql, new UserRowMapper<User>());

		} else if (null == searchForm.getKey()
				|| "".equals(searchForm.getKey())) {
			// 非关键查询处理
			sql += "select c.*,d.id as d_id,d.name as d_name from client c left join department d on c.department=d.id limit ? offset ?";
			users = this.getJdbcTemplate().query(
					sql,
					new Object[] {
							searchForm.getPageSize(),
							(searchForm.getPage() - 1)
									* searchForm.getPageSize() },
					new UserRowMapper<User>());

		} else {// 关键查询处理
			sql += "select c.*,d.id as d_id,d.name as d_name from client c left join department d on c.department=d.id where c.name ~* ? or c.email ~* ? or c.phone ~* ? or c.position ~* ? or c.sex ~* ? or d.name ~* ? limit ? offset ?";
			users = this.getJdbcTemplate().query(
					sql,
					new Object[] {
							searchForm.getKey(),
							searchForm.getKey(),
							searchForm.getKey(),
							searchForm.getKey(),
							searchForm.getKey(),
							searchForm.getKey(),
							searchForm.getPageSize(),
							(searchForm.getPage() - 1)
									* searchForm.getPageSize() },
					new UserRowMapper<User>());
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("users", users);
		if (null != searchForm) {
			int total = total();
			searchForm.setTotals(total);
			maps.put("pageInfo", searchForm);
		}
		return maps;
	}

	private int total() {
		Integer total = this.getJdbcTemplate().queryForObject(
				"select count(*) from client", Integer.class);
		return total == null ? 0 : total;
	}

	public class UserRowMapper<T extends User> implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setCreateTime(rs.getTimestamp("create_time"));
			user.getDepartment().setId(rs.getInt("d_id"));
			user.getDepartment().setName(rs.getString("d_name"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setPosition(rs.getString("position"));
			user.setSex(rs.getString("sex"));
			user.setStatus(rs.getInt("status"));
			user.setVersion(rs.getInt("version"));
			user.setWorkNumber(rs.getLong("work_number"));
			return user;
		}

	}
}
