package com.beeva.ProyectoBanco.DAO;

import com.beeva.ProyectoBanco.model.Cliente;
import com.beeva.ProyectoBanco.model.Cuenta;


public abstract class CuentaDAO {
	public abstract Cuenta save(Cuenta cuenta);
	public abstract Cuenta getCuenta(int id);
	public abstract Cuenta actualiza(double cant, Cuenta c);
	public abstract Cuenta Retiro(double cant, Cuenta c);
	
}
