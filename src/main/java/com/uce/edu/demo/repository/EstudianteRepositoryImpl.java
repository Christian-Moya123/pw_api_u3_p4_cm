package com.uce.edu.demo.repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.uce.edu.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EstudianteRepositoryImpl  implements IEstudianteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		String sql = "SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula";
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery(sql, Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);

		return myQuery.getSingleResult();
	}

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void actualizarParcialEstudiante(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		String sql ="update Estudiante SET e.cedula = : datoCedula WHERE e.cedula = :datoCondicion";
			Query myQuery = this.entityManager.createQuery(sql);
			
			myQuery.setParameter("datoCedula", cedulaActual);
			myQuery.setParameter("datoCondicion", cedulaNueva);
			myQuery.executeUpdate();
			
	}
	
	
	public  void borrar(Integer id) {
		this.entityManager.remove(this.borrarPorId(id));
	}

	@Override
	public Estudiante borrarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> seleccionarTodos() {
		// TODO Auto-generated method stub
		  TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
	        return myQuery.getResultList();
	}

}
