package com.hantian.demo.dao;

import java.util.List;

import com.hantian.demo.pojo.Department;

public interface IDepartmentDao {

	public abstract void saveOrUpdate(Department department);

	public abstract void delete(int id);

	public abstract Department findById(int id);

	public abstract List<Department> list();

}