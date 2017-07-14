package com.beeva.ProyectoBanco.model;

import com.beeva.ProyectoBanco.DAO.CuentaAhorroDAO;

public class CuentaAhorro  {

protected double Balance;

	public CuentaAhorro(double ini){
	Balance=ini;
	}
	
	
	public boolean Retiro(Cuenta cuenta,double cant){
		boolean r=false;
		if (cuenta.getBalance() >=5000){
		Balance=cuenta.getBalance();
		Balance=Balance-cant;	
		cuenta.setBalance(Balance);
		r=true;
		}else{r=false;}
		return r;
	}
	
	public boolean Deposito(Cuenta cuenta,double cant){
		boolean r=false;
		
		Balance=cuenta.getBalance();
		Balance=Balance+cant;	
		cuenta.setBalance(Balance);
	r=true;
		return r;
	}


	



	

}



