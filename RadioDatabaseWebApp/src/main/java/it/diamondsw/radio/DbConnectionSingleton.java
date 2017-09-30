package it.diamondsw.radio;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConnectionSingleton {
	private static Connection connection = null;
	private static DbConnectionSingleton single = null;
	
	private Connection createConnection() {
		try {
		    Context ctx = new InitialContext();
		    DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/sqlite");		
			// create a unique database connection
			connection = ds.getConnection();	
		}
	    catch(Exception e) {
	    	System.err.println(e.getMessage());
	    }
		return connection;
	} // createConnection
	
	public static DbConnectionSingleton getInstance() {
		if (single == null) {
			single = new DbConnectionSingleton();
			single.createConnection();
		}
		return single;
	} // DbconnectionSingletonInstance
	
	public Connection getConnection() {
		return connection;
	}
	
	public String toString() {
		if (single == null)
			return ("Not connected to instance db");
		else {
			try { return (connection.isValid(5) ? "true" : "false"); }
			catch (Exception e) { return e.getMessage(); }	
		}	
	}
}
