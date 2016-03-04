package com.hantian.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hantian.demo.dao.IDepartmentDao;
import com.hantian.demo.pojo.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends DaoImpl implements IDepartmentDao {
	/*
	 * <p>Title: saveOrUpdate</p> <p>Description: </p>
	 * 
	 * @param department
	 * 
	 * @see
	 * com.hantian.demo.dao.impl.IDepartmentDao#saveOrUpdate(com.hantian.demo
	 * .pojo.Department)
	 */
	@Override
	public void saveOrUpdate(Department department) {
		String sql = "";
		if (null == department.getId() || department.getId() <= 0) {
			sql += "insert into department(name,parent,description,version,create_time) values(?,?,?,?,?)";
			this.getJdbcTemplate().update(
					sql,
					new Object[] {
							department.getName(),
							department.getParent() != null ? department.getParent()
									.getId() : 0, department.getDescription(),
							department.getVersion(), department.getCreateTime() });
		} else {
			sql += "update department set name=?,parent=?,description=?,version=?,create_time=? where id=?";
			this.getJdbcTemplate().update(
					sql,
					new Object[] {
							department.getName(),
							department.getParent() != null ? department.getParent()
									.getId() : 0, department.getDescription(),
							department.getVersion(), department.getCreateTime(),department.getId() });
		}
	}

	/*
	 * <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @see com.hantian.demo.dao.impl.IDepartmentDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		this.getJdbcTemplate().update(
				"delete from department where parent=? or id=?", id, id);
	}

	/*
	 * <p>Title: findById</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.hantian.demo.dao.impl.IDepartmentDao#findById(int)
	 */
	@Override
	public Department findById(int id) {
		String sql = "";
		sql += "select * from department where id=?";
		List<Department> departments = this.getJdbcTemplate().query(sql,
				new Object[] { id }, new RowMapper<Department>() {

					@Override
					public Department mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Department department = new Department();
						department.setCreateTime(rs.getTimestamp("create_time"));
						department.setDescription(rs.getString("description"));
						department.setName(rs.getString("name"));
						Department parent = new Department();
						parent.setId(rs.getInt("parent"));
						department.setParent(parent);
						department.setId(rs.getInt("id"));
						department.setVersion(rs.getInt("version"));
						return department;
					}

				});
		if (null != departments && departments.size() > 0) {
			return departments.get(0);
		} else {
			return null;
		}
	}

	/*
	 * <p>Title: list</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.hantian.demo.dao.impl.IDepartmentDao#list()
	 */
	@Override
	public List<Department> list() {
		String sql = "";
		sql += "select * from department";
		List<Department> departments = this.getJdbcTemplate().query(sql,
				new RowMapper<Department>() {

					@Override
					public Department mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Department department = new Department();
						department.setCreateTime(rs.getTimestamp("create_time"));
						department.setDescription(rs.getString("description"));
						department.setName(rs.getString("name"));
						Department parent = new Department();
						parent.setId(rs.getInt("parent"));
						department.setParent(parent);
						department.setId(rs.getInt("id"));
						department.setVersion(rs.getInt("version"));
						return department;
					}

				});
		if (null != departments) {
			for (Department department : departments) {
				if (null != department.getParent()) {
					Department d = findById(department.getParent().getId());
					department.setParent(d);
				}
			}
		}
		return departments;
	}
}
