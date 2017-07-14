package com.beeva.ProyectoBanco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cuenta")
public class Cuenta {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
private int idcuenta;
private double balance;
private int idcliente;
private int idtipocuenta;

public int getId() {
	return idcuenta;
}
public void setId(int id) {
	this.idcuenta = id;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public int getIdcliente() {
	return idcliente;
}
public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
}
public int getIdtipocuenta() {
	return idtipocuenta;
}
public void setIdtipocuenta(int idtipocuenta) {
	this.idtipocuenta = idtipocuenta;
}


}
