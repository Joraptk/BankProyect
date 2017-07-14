package com.beeva.ProyectoBanco.DAO;

import com.beeva.ProyectoBanco.model.BancosClientes;

public abstract class BancosClientesDAO {
	public abstract BancosClientes save(BancosClientes bancocliente);
	public abstract BancosClientes getBancosClientes(int id);
}
