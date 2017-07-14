package com.beeva.ProyectoBanco.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha_Hora {
	  Date ahora; 
	  SimpleDateFormat formato;
	           
	public String getFechayHora(){
		String fechahora=getFecha()+" "+getHora();
		return fechahora;
	}
	
	public String getHora(){
	   ahora = new Date();
	   formato = new SimpleDateFormat("hh:mm:ss");
	   return formato.format(ahora);
	}   
	 
	    public String getFecha(){
	 
	    Date ahora = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	    return formateador.format(ahora);

	    }
	    
	    public String getFechaYY(){
	     ahora=new Date();
	     formato=new SimpleDateFormat("yyyy-MM-dd"); 
	       return formato.format(ahora);
	    }
	}