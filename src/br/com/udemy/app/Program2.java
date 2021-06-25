package br.com.udemy.app;


import java.util.List;

import br.com.udemy.model.dao.DaoFactory;
import br.com.udemy.model.dao.DepartmentDao;
import br.com.udemy.model.dao.impl.DepartmentDaoJDBC;
import br.com.udemy.model.entities.Department;
import db.DB;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao dd = DaoFactory.createDepartmentDao();

		System.out.println("Teste 1 - Inserir Departamento");
		Department d = new Department(null, "Limpeza");
		dd.insert(d);
		System.out.println("Objeto cadastro com sucesso! Seu código é: " + d.getId());
		
		System.out.println("Teste 2 - Atualizar Departamento");
		Department department = new Department(7, "Financeiro");
		dd.update(department);
		System.out.println("Objeto atualizado com sucesso");
		
		//System.out.println("Teste 3 - Deletar Dados");
		//dd.deleteById(1);
		//System.out.println("Objeto deletado com sucesso");
		
		System.out.println("Teste 4 - Selecionar por ID");
		department = dd.findById(2);
		System.out.println(department);
		
		System.out.println("Teste 5 - Selecionar todos");
		List<Department> listaDepartamentos = dd.findAll();
		listaDepartamentos.forEach(System.out::println);

	}

}
