package com.beeva.ProyectoBanco.model;

public class Reglas {
public boolean depositar(double cant){
	boolean a=false;
	if(cant<0){
		a=false;
	}else{
		a=true;
	}
	return a;
}

public boolean retirar (double cant, double ret){
	boolean a=false;
	if(cant>ret){
		a=true;
	}else{
		a=false;
	}
	return a;
}

}
