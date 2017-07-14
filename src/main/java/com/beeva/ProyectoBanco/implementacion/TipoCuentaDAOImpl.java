package com.beeva.ProyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ProyectoBanco.DAO.TipoCuentaDAO;
import com.beeva.ProyectoBanco.model.TipoCuenta;

@Repository
public class TipoCuentaDAOImpl extends TipoCuentaDAO {


	@PersistenceContext
	EntityManager em;

@Override
@Transactional
	public TipoCuenta save(TipoCuenta tipocuenta) {
		em.persist(tipocuenta);
		return tipocuenta;
	}

	@Override
	public TipoCuenta getTipoCuenta(int id) {
		// TODO Auto-generated method stub
		return em.find(TipoCuenta.class,id);
	
}
	
}
