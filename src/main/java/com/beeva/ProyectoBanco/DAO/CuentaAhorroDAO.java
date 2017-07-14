package com.beeva.ProyectoBanco.DAO;

import com.beeva.ProyectoBanco.model.Cuenta;

public abstract class CuentaAhorroDAO {
	
	protected double balance;
	public abstract Cuenta Retiro(Cuenta cuenta,double cant);
	public abstract  Cuenta Deposito(Cuenta cuenta,double cant);

}
