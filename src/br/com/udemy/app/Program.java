package br.com.udemy.app;


import br.com.udemy.model.dao.DaoFactory;
import br.com.udemy.model.dao.SellerDao;
import br.com.udemy.model.entities.Department;
import br.com.udemy.model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDao sd = DaoFactory.createSellerDao();
		System.out.println("Teste número 01 Teste Seller FindById");
		Seller seller = sd.findById(3);
		
		System.out.println(seller);
		
		
		System.out.println("\nTeste número 02 Teste Seller FindByDepartment");
		Department department = new Department(2,null);
		java.util.List<Seller> list = sd.findByDepartment(department);
		
		list.forEach(System.out::println);
		
		System.out.println("\nTeste número 03 Teste Seller FindByDepartment");
		list = sd.findAll();
		
		list.forEach(System.out::println);
		
	}

}
