package com.beeva.ProyectoBanco.implementacion;

import java.net.UnknownHostException;

import org.springframework.stereotype.Repository;

import com.beeva.ProyectoBanco.DAO.MongoLogDAO;
import com.beeva.ProyectoBanco.model.MongoLog;

@Repository
public class MongoLogDAOImpl extends MongoLogDAO{

	
	@Override
	public MongoLog addEventLog(MongoLog mongo,String msj, String fecha, int id, String Name,
		String apellido) throws UnknownHostException {
		boolean res=false;
		mongo.conectar();
		mongo.getMongoDocument().put("mensaje", msj);
		mongo.getMongoDocument().put("fecha", fecha);
		mongo.getMongoDocument().put("id", id);
		mongo.getMongoDocument().put("nombre", Name);
		if(apellido.isEmpty()==false){
		mongo.getMongoDocument().put("apellido", apellido);
		}
		mongo.getMongoTable().insert(mongo.getMongoDocument());
			res=true;
		
		return mongo;
	}

	@Override
	public MongoLog mongoDisconnect(MongoLog mongo) {
		boolean res=false;
		mongo.setMongoCollection(null);
		mongo.setMongoDataBase(null);
		mongo.setMongoTable(null);
		mongo.setMongoCollection(null);
		res=true;
		return mongo;
	}

	@Override
	public MongoLog mongoConnect(MongoLog mongo) throws UnknownHostException {
		boolean res=false;
		if(mongo.conectar()==true){
			res=true;
		}else{res=false;}
		return mongo;
	}


}
