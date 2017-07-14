package com.beeva.ProyectoBanco.model;

import java.net.UnknownHostException;
import java.util.Date;

import javax.persistence.Entity;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoLog {
private int port;
private String dataBaseName;
private  String serverName;
private String mongoCollection;

private String mongotable;
private MongoClient mongoConnection;
private DB mongoDataBase;
private DBCollection mongoTable;
private BasicDBObject mongoDocument;
 

public boolean conectar() {
	try {
		mongoConnection= new MongoClient (this.getServerName(),this.getPort());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		System.out.println("No se pudo conectar con Mongo SERVER\n " +e.getMessage());
		e.printStackTrace();
	}
	System.out.println("el nombre de la base es: "+this.getDataBaseName());
	mongoDataBase=mongoConnection.getDB(this.getDataBaseName());
	mongoTable=mongoDataBase.getCollection(this.mongotable);
	mongoDocument = new BasicDBObject();
	return true;
}

public void desconectar(){
	mongoConnection.close();
}
public String getMongotable() {
	return mongotable;
}

public void setMongotable(String mongotable) {
	this.mongotable = mongotable;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}
public String getDataBaseName() {
	return dataBaseName;
}
public void setDataBaseName(String dataBaseName) {
	this.dataBaseName = dataBaseName;
}
public String getServerName() {
	return serverName;
}
public void setServerName(String serverName) {
	this.serverName = serverName;
}
public String getMongoCollection() {
	return mongoCollection;
}
public void setMongoCollection(String mongoCollection) {
	this.mongoCollection = mongoCollection;
}
public MongoClient getMongoConnection() {
	return mongoConnection;
}
public void setMongoConnection(MongoClient mongoConnection) {
	this.mongoConnection = mongoConnection;
}
public DB getMongoDataBase() {
	return mongoDataBase;
}
public void setMongoDataBase(DB mongoDataBase) {
	this.mongoDataBase = mongoDataBase;
}
public DBCollection getMongoTable() {
	return mongoTable;
}
public void setMongoTable(DBCollection mongoTable) {
	this.mongoTable = mongoTable;
}
public BasicDBObject getMongoDocument() {
	return mongoDocument;
}
public void setMongoDocument(BasicDBObject mongoDocument) {
	this.mongoDocument = mongoDocument;
} 


}
