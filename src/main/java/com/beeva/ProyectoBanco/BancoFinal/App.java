package com.beeva.ProyectoBanco.BancoFinal;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.ProyectoBanco.DAO.BancoDAO;
import com.beeva.ProyectoBanco.DAO.BancosClientesDAO;
import com.beeva.ProyectoBanco.DAO.ClienteDAO;
import com.beeva.ProyectoBanco.DAO.CuentaDAO;
import com.beeva.ProyectoBanco.DAO.MongoLogDAO;
import com.beeva.ProyectoBanco.DAO.TipoCuentaDAO;
import com.beeva.ProyectoBanco.implementacion.BancoDAOImpl;
import com.beeva.ProyectoBanco.implementacion.ClienteDAOImpl;
import com.beeva.ProyectoBanco.implementacion.CuentaDAOImpl;
import com.beeva.ProyectoBanco.implementacion.MongoLogDAOImpl;
import com.beeva.ProyectoBanco.model.Banco;
import com.beeva.ProyectoBanco.model.BancosClientes;
import com.beeva.ProyectoBanco.model.Cliente;
import com.beeva.ProyectoBanco.model.Cuenta;
import com.beeva.ProyectoBanco.model.CuentaAhorro;
import com.beeva.ProyectoBanco.model.CuentaCheques;
import com.beeva.ProyectoBanco.model.Fecha_Hora;
import com.beeva.ProyectoBanco.model.MongoLog;
import com.beeva.ProyectoBanco.model.Reglas;
import com.beeva.ProyectoBanco.model.TipoCuenta;




/**
 * Hello world!
 *
 */
public class App 
{

	public static int verificaOpc(String parm){
		int opc=0;
		
		if (parm==null){
			opc=0;
		}else if(parm.isEmpty()==true){
			JOptionPane.showMessageDialog(null,"Debe insertar un número", "Error ", JOptionPane.ERROR_MESSAGE);
			opc=99;
		}else{
		try {
			opc=Integer.parseInt(parm);
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(null,"El valor introducido debe ser numérico", "Error de tipo de dato", JOptionPane.ERROR_MESSAGE);
		opc=99;
		}
		}
		return opc;	
	}
	
	public static double verificaCant(String parm){
		double cant=0;
		if (parm==null){
			JOptionPane.showMessageDialog(null,"Debe insertar una cantidad", "Error ", JOptionPane.ERROR_MESSAGE);
		}else{
			if(parm.isEmpty()==true){
				JOptionPane.showMessageDialog(null,"Debe insertar una cantidad", "Error ", JOptionPane.ERROR_MESSAGE);
				cant=0;
			}else{
			try {
				cant=Double.parseDouble(parm);
			} catch (NumberFormatException nfe){
				JOptionPane.showMessageDialog(null,"El valor introducido debe ser numérico", "Error de tipo de dato", JOptionPane.ERROR_MESSAGE);
			cant=0;
		}
			}
			}
		return cant;
	}
    public static void main( String[] args )
    {
    	Scanner lee=new Scanner(System.in);
    	String parm="0";
    	int opc=0;
    	ApplicationContext context=new ClassPathXmlApplicationContext("core-context.xml");
    	BancoDAO bancoDAO= (BancoDAO)context.getBean(BancoDAOImpl.class);
    	Banco banco;
    	ClienteDAO clienteDAO=(ClienteDAO)context.getBean(ClienteDAOImpl.class);
    	Cliente cliente;
    	CuentaDAO cuentaDAO=(CuentaDAO)context.getBean(CuentaDAOImpl.class);
    	Cuenta cuenta;
    	TipoCuentaDAO tipocuentaDAO=(TipoCuentaDAO)context.getBean(TipoCuentaDAO.class);
    	TipoCuenta tipocuenta=new TipoCuenta();
    	BancosClientesDAO bancosclientesDAO=(BancosClientesDAO)context.getBean(BancosClientesDAO.class);
    	BancosClientes bancosclientes;
    	BeanFactory factory = new ClassPathXmlApplicationContext("core-context.xml");
    	MongoLogDAO mongolog=(MongoLogDAO)context.getBean(MongoLogDAOImpl.class);
    	MongoLog mongo=(MongoLog)factory.getBean("mongoConfig");
    	mongo.conectar();
    	Fecha_Hora fecha=new Fecha_Hora();
    	do{
    		
    		parm=(JOptionPane.showInputDialog(("Selecciona una opcion:"+
					"1) crear banco\n2)Entrar al registro de un banco")));
    		opc=verificaOpc(parm);
    		
    		switch(opc){
    		
    		case 1: //Crear banco
    			banco =new Banco();
    			banco.setNombre(JOptionPane.showInputDialog("\nIngresa el nombre del nuevo banco:"));
    			mongo.conectar();
    			banco=bancoDAO.save(banco);
    	 
    				try {
    					mongo=mongolog.addEventLog(mongo, "Se creó el registro de un nuevo banco", fecha.getFechayHora() , banco.getIdbanco(), banco.getNombre(), "");
    				} catch (UnknownHostException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			break;
    			
    		case 2: //entrar al registro
    			parm=(JOptionPane.showInputDialog(("Indica el id del banco:")));
        		opc=verificaOpc(parm);
        		banco= new Banco();
    			banco=bancoDAO.getBanco(opc);
    			
    			parm=(JOptionPane.showInputDialog(("Elije una opcion\n Crear un cliente\nSeleccionar un cliente")));
        		opc=verificaOpc(parm);
        			switch(opc){
        			 	case 1: //Crear cliente
        			 		cliente=new Cliente();
	    	    			cliente.setNombre(JOptionPane.showInputDialog("Ingresa el nombre del cliente"));
	    	    			System.out.println("Ingresa el apellido del cliente");
	    	    			cliente.setApellido(JOptionPane.showInputDialog("Ingresa el apellido del cliente"));
        			 		
        			 		break;
        			 		
        			 	case 2: //Seleccionar cliente
        			 		cliente=new Cliente();
        			 		
        			 		parm=(JOptionPane.showInputDialog("Ingresa el id del cliente"));
        			 		opc=verificaOpc(parm);
        			 		cliente=clienteDAO.getCliente(opc);
        			 		parm=(JOptionPane.showInputDialog("Ingresa una opcion:\n1)Hacer Deposito\n2Hacer Retiro "));
        			 		opc=verificaOpc(parm);
        			 		switch (opc){
        			 		
        			 		case 1: //Ddeposito
        			 			cuenta=new Cuenta();
        			 			parm=(JOptionPane.showInputDialog("Ingresa el id del de la cuenta"));
            			 		opc=verificaOpc(parm);

	 					  		Reglas r=new Reglas();
				    			double cantidad;
				    			parm=JOptionPane.showInputDialog("Ingresa la cantidad a depositar");
				    			cantidad=verificaCant(parm);
            			 		if(r.depositar(cantidad)==true){
            			 			if(cuenta.getId()==1){
            			 				CuentaAhorro c =new CuentaAhorro(cuenta.getBalance());
            			 				if (c.Deposito(cuenta, cantidad)==true){
            			 				cuenta=cuentaDAO.actualiza(cantidad, cuenta);
            			 				}
            			 				JOptionPane.showMessageDialog(null,"No se puede depositar");
            			 				
            			 				}else{
            			 				CuentaCheques c=new CuentaCheques(cuenta.getBalance());
            			 				if (c.Deposito(cuenta, cantidad)==true){
                			 				cuenta=cuentaDAO.actualiza(cantidad, cuenta);
                			 				}
            			 			}
    		    	    			}else{
    		    	    				JOptionPane.showMessageDialog(null, "No se puedeb depositar cantidades negativas");
    		    	    			}
        			 			
        			 			break;
        			 		
        			 		case 2://Retiro
        			 			
        			 			break;
        			 			
        			 		case 3: // Crear cuenta
        	  	    			
		    	    			parm=(JOptionPane.showInputDialog(("¿Que tipo de cuenta deseas asignar al cliente?"+
		    	    																"1) Cuenta de Ahorro\n2)Cuenta de Cheques")));
		    	    			opc=verificaOpc(parm);
		    	    			if(opc==1){
		    	    				tipocuenta=tipocuentaDAO.getTipoCuenta(1);
		    	    			}else{
		    	    				tipocuenta=tipocuentaDAO.getTipoCuenta(2);
		    	    			}
		    	    			clienteDAO.save(cliente);
		    	    			try {
									mongo=mongolog.addEventLog(mongo, "Se creó el registro de un nuevo cliente", fecha.getFechayHora() , cliente.getId(), cliente.getNombre(), cliente.getApellido());
									
								} catch (UnknownHostException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
    	    			
		    	    			cuenta=new Cuenta();
		    	    			cuenta.setIdtipocuenta(tipocuenta.getIdtipocuenta());
		    	    			cuenta.setIdcliente(cliente.getIdcliente());
		    	    			cuenta=cuentaDAO.save(cuenta);
		    	    			bancosclientes=new BancosClientes();
		    	    			bancosclientes.setIdbanco(banco.getIdbanco());
		    	    			bancosclientes.setIdcliente(cliente.getId());
		    	    			bancosclientes=bancosclientesDAO.save(bancosclientes);
		    	    	
        			 			break;
        			 			
        			 		}
        			 		
        			 	break;
        			
        			}
    			
    			break;
    			
    			
    		}
    	
 
    		opc=0;
      	 	
		    	    			
		    	    			
		    	    			
    	}while(opc!=0); 	    			
			    	   
	    	    	     			
	
    }
}
