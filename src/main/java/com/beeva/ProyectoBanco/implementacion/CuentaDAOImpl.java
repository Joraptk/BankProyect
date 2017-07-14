package com.beeva.ProyectoBanco.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.ProyectoBanco.DAO.CuentaDAO;
import com.beeva.ProyectoBanco.model.Cliente;
import com.beeva.ProyectoBanco.model.Cuenta;

@Repository
public class CuentaDAOImpl extends CuentaDAO{

	@PersistenceContext
	EntityManager em;

@Override
@Transactional
	public Cuenta save(Cuenta cuenta) {
		em.persist(cuenta);
		return cuenta;
	}

	@Override
	public Cuenta getCuenta(int id) {
		// TODO Auto-generated method stub
		return em.find(Cuenta.class,id);
	
}

	@Override
	public Cuenta actualiza(double cant, Cuenta c) {
		// TODO Auto-generated method stub
		Cuenta cuenta= em.find(Cuenta.class,c.getId());
		cuenta.setBalance(cant);
		em.merge(cuenta);
		return cuenta;
	}

	@Override
	public Cuenta Retiro(double cant, Cuenta c) {
		// TODO Auto-generated method stub
		return null;
	}


	
}