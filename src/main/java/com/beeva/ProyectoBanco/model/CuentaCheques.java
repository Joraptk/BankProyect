package com.beeva.ProyectoBanco.model;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class CuentaCheques {


protected double Balance;

	public CuentaCheques(double ini){
	Balance=ini;
	}
	
	
	public boolean Retiro(Cuenta cuenta,double cant){
		boolean r=false;
		Calendar dia=Calendar.getInstance();
		
		if(dia.get(Calendar.DAY_OF_WEEK)==1 | dia.get(Calendar.DAY_OF_WEEK)==7){
			JOptionPane.showMessageDialog(null, "No se puede depositar en fines de semana");
			r=false;
		}else{
		if (cuenta.getBalance() >=5000){
		Balance=cuenta.getBalance();
		Balance=Balance-cant;	
		cuenta.setBalance(Balance);
		r=true;
		}
		}
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



