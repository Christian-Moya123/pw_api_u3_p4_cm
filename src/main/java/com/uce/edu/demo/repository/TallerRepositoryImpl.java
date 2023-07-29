package com.uce.edu.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Taller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TallerRepositoryImpl implements ITallerRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Taller taller) {
		// TODO Auto-generated method stub
		this.entityManager.persist(taller);
	}

	@Override
	public void actualizar(Taller taller) {
		// TODO Auto-generated method stub
		this.entityManager.merge(taller);
	}

	@Override
	public void actualizarParcial(String tallerActual, String tallerNuevo) {

	    String sql = "UPDATE Taller t SET t.codigo = :nuevoCodigo WHERE t.codigo = :actualCodigo";
	    Query myQuery = this.entityManager.createQuery(sql);
	    myQuery.setParameter("nuevoCodigo", tallerNuevo);
	    myQuery.setParameter("actualCodigo", tallerActual);
	    myQuery.executeUpdate();
	}
	
	@Override
	public Taller buscar(String codigo) {
		// TODO Auto-generated method stub
		String sql = "SELECT t FROM Taller t WHERE t.codigo=:datoCodigo";
		TypedQuery<Taller>myQuery=this.entityManager.createQuery(sql, Taller.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Taller> buscarTodos() {
	    String sql = "SELECT t FROM Taller t";
	    TypedQuery<Taller> myQuery = this.entityManager.createQuery(sql, Taller.class);
	    return myQuery.getResultList();
	}

	@Override
	public Taller buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Taller.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarId(id));
	}

}
