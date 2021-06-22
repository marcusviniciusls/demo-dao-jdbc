package br.com.udemy.app;

import java.util.Date;

import br.com.udemy.model.entities.Department;
import br.com.udemy.model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		Department obj = new Department(1,"Books");
		Seller s1 = new Seller(1,"Marcus Vinicius","viniciusmls@outlook.com",new Date(),3000.0,obj);
		
		System.out.println(obj);
		System.out.println(s1);
	}

}
