package com.beeva.ProyectoBanco.DAO;

import java.net.UnknownHostException;
import java.util.Date;

import com.beeva.ProyectoBanco.model.MongoLog;
import com.mongodb.BasicDBObject;

public abstract class MongoLogDAO {
	public abstract MongoLog addEventLog(MongoLog mongo,String msj, String fecha, int id, String Name,String apellido) throws UnknownHostException;
	public abstract MongoLog mongoDisconnect(MongoLog mongo);
	public abstract MongoLog mongoConnect(MongoLog mongo) throws UnknownHostException;

}
