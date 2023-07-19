package com.uce.edu.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Horario;
import com.uce.edu.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HorarioRepositoryImpl implements IHorarioRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		  TypedQuery<Horario> myQuery = this.entityManager.createQuery("SELECT h FROM Horario h", Horario.class);
	      return myQuery.getResultList();
		
	}

	@Override
	public void insertarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
		
	}

	@Override
	public void actualizarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
		
	}

	@Override
	public void borrarHorario(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.borrarHorarioPorId(id));
		
	}

	@Override
	public Horario borrarHorarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public Horario buscarHorarioPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT h FROM Horario h WHERE h.codigo = :datoCodigo";
		TypedQuery<Horario> myQuery = this.entityManager.createQuery(sql, Horario.class);
		myQuery.setParameter("datoCodigo", codigo);

		return myQuery.getSingleResult();
	
	}

	@Override
	public Horario consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

}
