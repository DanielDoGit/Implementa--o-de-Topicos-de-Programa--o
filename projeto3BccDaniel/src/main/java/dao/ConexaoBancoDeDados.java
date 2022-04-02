package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.command.Prepared;

public class ConexaoBancoDeDados {
	
	private static Connection connection;
	private String user, password, urlBanco;
	
	
	public ConexaoBancoDeDados() throws SQLException {
			
		this.user = "throwsException";
		this.password = "throwsException";
		this.urlBanco = "jdbc:h2:./banco/banco";
		connection = DriverManager.getConnection(this.urlBanco,this.user,this.password);
	}

}
