/**
 * 
 */
package com.beeva.ProyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ProyectoBanco.DAO.BancosClientesDAO;
import com.beeva.ProyectoBanco.model.BancosClientes;

/**
 * @author administradorcito
 *
 */
@Repository
public class BancosClientesDAOImpl extends BancosClientesDAO {
	@PersistenceContext
	EntityManager em;

@Override
@Transactional
	public BancosClientes save(BancosClientes bancosclientes) {
		em.persist(bancosclientes);
		return bancosclientes;
	}

	@Override
	public BancosClientes getBancosClientes(int id) {
		// TODO Auto-generated method stub
		return em.find(BancosClientes.class,id);
	}
}
