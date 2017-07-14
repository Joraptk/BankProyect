package com.beeva.ProyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ProyectoBanco.DAO.ClienteDAO;
import com.beeva.ProyectoBanco.model.Cliente;

@Repository
public class ClienteDAOImpl extends ClienteDAO{
@PersistenceContext
	EntityManager em;

@Transactional
	public Cliente save(Cliente cliente) {
		em.persist(cliente);
		return cliente;
	}

	public Cliente getCliente(int id) {
		// TODO Auto-generated method stub
		
		return em.find(Cliente.class,id);
	}

}
