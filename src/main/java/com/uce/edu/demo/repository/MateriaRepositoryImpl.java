package com.uce.edu.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		String sql = "SELECT m FROM Materia m WHERE m.codigo = :datoCodigo";
		TypedQuery<Materia> myQuery = this.entityManager.createQuery(sql, Materia.class);
		myQuery.setParameter("datoCodigo", codigo);

		return myQuery.getSingleResult();
	}

	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
		
	}

	@Override
	public void actualizarParcialMateria(String codigoActual, String codigoNueva) {
		// TODO Auto-generated method stub
		String sql ="update Materia SET m.codigo = : datoCodigo WHERE m.cedula = :datoCondicion";
		Query myQuery = this.entityManager.createQuery(sql);
		
		myQuery.setParameter("datoCodigo", codigoActual);
		myQuery.setParameter("datoCondicion", codigoNueva);
		myQuery.executeUpdate();
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.borrarPorIdMateria(id));
		
	}

	@Override
	public Materia borrarPorIdMateria(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public List<Materia> seleccionarTodosMateria() {
		// TODO Auto-generated method stub
		  TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
	        return myQuery.getResultList();
	}

	@Override
	public List<Materia> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQ=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula =: datoEstudiante", Materia.class);
		myQ.setParameter("datoEstudiante", cedula);
		return myQ.getResultList();
	}
	
	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

}
