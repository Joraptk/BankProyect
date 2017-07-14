package com.beeva.ProyectoBanco.DAO;

import com.beeva.ProyectoBanco.model.Cliente;




public abstract class ClienteDAO {
	public abstract Cliente save(Cliente cliente);
	public abstract Cliente getCliente(int id);
}
