package br.com.udemy.model.dao;



import java.util.List;

import br.com.udemy.model.entities.Department;
import br.com.udemy.model.entities.Seller;

public interface SellerDao {
	
	// Métodos
	
	public void insert(Seller obj);
	public void update(Seller obj);
	public void deleteById(Integer id);
	public Seller findById(Integer id);
	public List<Seller> findAll();
	public List<Seller> findByDepartment(Department department);
	

}
