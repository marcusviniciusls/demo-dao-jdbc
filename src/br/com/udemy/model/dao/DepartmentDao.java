package br.com.udemy.model.dao;



import java.util.List;

import br.com.udemy.model.entities.Department;

public interface DepartmentDao {
	
	// Métodos
	
	public void insert(Department obj);
	public void update(Department obj);
	public void deleteById(Integer id);
	public Department findById(Integer id);
	public List<Department> findAll();
	

}
