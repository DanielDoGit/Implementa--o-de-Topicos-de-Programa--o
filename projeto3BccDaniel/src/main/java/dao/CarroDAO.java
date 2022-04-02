package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import classeBase.Carro;

public class CarroDAO {
	
	private Connection c;
	private ArrayList<Carro> listaCarro;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Carro carro;
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public void pegaConexao(Connection c) {
		this.c = c;
	}
	
	public ArrayList<Carro> getListaCarro() {
		return listaCarro;
	}
	public void setListaCarro(ArrayList<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
	public ResultSet getResultSet() {
		return resultSet;
	}
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	public void ExecutaTransacaoInsert() throws SQLException {
		
		setPreparedStatement(
				getConnection().prepareStatement(
				"insert into carro values ("+getCarro().getIdCarro()+",'"+getCarro().getNomeDoCarro()+"')"
				));
		getPreparedStatement().executeUpdate();
		
	}
	
	public void ExecutaTransacaoUpdate() throws SQLException{
		
		setPreparedStatement(
				getConnection().prepareStatement(
				"update carro values ("+getCarro().getIdCarro()+",'"+getCarro().getNomeDoCarro()+"')"
				));
		getPreparedStatement().executeUpdate();
		
	}
	
	
	public Connection getConnection() {
		return c;
	}


	public CarroDAO() {
		super();
		this.listaCarro = new ArrayList<Carro>();
		
	}
	
	
	
	
	
}
