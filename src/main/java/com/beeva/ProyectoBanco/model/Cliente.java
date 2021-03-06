package com.beeva.ProyectoBanco.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int idcliente;
	private String nombre;
	private String apellido;

	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	public int getId() {
		return idcliente;
	}
	public void setId(int id) {
		this.idcliente = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
