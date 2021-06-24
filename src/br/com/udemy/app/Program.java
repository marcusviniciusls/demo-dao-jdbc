package br.com.udemy.app;

import java.util.Date;

import br.com.udemy.model.dao.DaoFactory;
import br.com.udemy.model.dao.SellerDao;
import br.com.udemy.model.entities.Department;
import br.com.udemy.model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDao sd = DaoFactory.createSellerDao();
		
		Seller seller = sd.findById(3);
		
		System.out.println(seller);
	}

}
