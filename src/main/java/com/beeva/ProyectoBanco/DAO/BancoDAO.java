package com.beeva.ProyectoBanco.DAO;



import java.util.List;

import com.beeva.ProyectoBanco.model.Banco;



public abstract class BancoDAO {
	public abstract Banco save(Banco banco);
	public abstract Banco getBanco(int id);	
	public abstract List <Banco> getBancos();
	public abstract List<Banco> findWithName(String name);
	public abstract List <Banco> getNumBancos();
}
