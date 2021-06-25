package br.com.udemy.model.dao;

import br.com.udemy.model.dao.impl.DepartmentDaoJDBC;
import br.com.udemy.model.dao.impl.SellerDaoJDBC;
import db.DB;

public class DaoFactory {
	
	// Instaciar os DAOs
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
