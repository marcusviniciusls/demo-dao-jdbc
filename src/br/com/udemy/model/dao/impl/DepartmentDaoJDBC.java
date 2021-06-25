package br.com.udemy.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.udemy.model.dao.DepartmentDao;
import br.com.udemy.model.entities.Department;
import db.DB;
import db.DbException;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn;	
	
	//CONSTRUTOR
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		
		PreparedStatement st = null;
		
		
		try {
			st = conn.prepareStatement("insert into department (name) values (?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					obj.setId(rs.getInt(1));
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Não foi possível inserir o Departmento");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update department set Name = ? where Id = ?");			
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Registro atualizado com sucesso");
			}
			else {
				throw new DbException("Registro não atualziado com sucesso");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from department where Id = ?");			
			
			st.setInt(1, id);			
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Registro deletado com sucesso");
			}
			else {
				throw new DbException("Registro não deletado com sucesso");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("select * from department where Id = ? order by Name desc");			
			
			st.setInt(1, id);			
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt(1));
				department.setName(rs.getString(2));
				return department;
			}
			else {
				throw new DbException("Não foram encontrados nenhum registro");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Department> findAll() {
		
		PreparedStatement st = null;
		List<Department> listaDepartamento = new ArrayList<Department>();
		
		try {
			st = conn.prepareStatement("select * from department order by Name desc", Statement.NO_GENERATED_KEYS);				
			
			ResultSet rs = st.executeQuery();
			
	
				while(rs.next()) {
					Department department = new Department();
					department.setId(rs.getInt(1));
					department.setName(rs.getString(2));
					listaDepartamento.add(department);
				}
				return listaDepartamento;
					
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}
	
	

}
