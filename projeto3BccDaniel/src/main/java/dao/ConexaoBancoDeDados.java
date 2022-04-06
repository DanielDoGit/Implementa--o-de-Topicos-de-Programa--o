package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConexaoBancoDeDados {
	
	private Connection connection;
	private String user, password, urlBanco;
	
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public ConexaoBancoDeDados() throws SQLException, ClassNotFoundException {
			
		//Class.forName("com.h2database");
		this.user = "throwsException";
		this.password = "throwsException";
		//linux
		//this.urlBanco = "jdbc:h2:/home/limalinux/eclipse-workspace2020/projeto3BccDaniel/banco";
		//windows
		this.urlBanco = "jdbc:h2:C:\\bancoh2\\banco";
		
		connection = DriverManager.getConnection(this.urlBanco,this.user,this.password);
	
	}

}
