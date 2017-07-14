package com.beeva.ProyectoBanco.DAO;

import com.beeva.ProyectoBanco.model.TipoCuenta;


public abstract class TipoCuentaDAO {
	public abstract TipoCuenta save(TipoCuenta tipocuenta);
	public abstract TipoCuenta getTipoCuenta(int id);
}
