package br.com.udemy.app;


import java.util.Date;



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
		
		System.out.println("\nTeste número 04 Teste Insert");
		
		Department departmento = new Department(4,null);
		Seller vendedor = new Seller(null, "VItoria", "VITORIA@EXO.COM.BR", new Date(), 4000.0, departmento);
		sd.insert(vendedor);
		System.out.println("ID: " + vendedor.getId());
		
		System.out.println("\nTeste número 05 Teste Update");
		
		seller = sd.findById(1);
		seller.setName("Joaquim Profanos");
		sd.update(seller);
		System.out.println("Update Concluído");
		
		System.out.println("\nTeste número 06 Teste Update");
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Digite um id para deleção: ");
		int id = sc.nextInt();
		
		sd.deleteById(id);
		
		System.out.println("Finalizaou o delete");
		
		
	}

}
