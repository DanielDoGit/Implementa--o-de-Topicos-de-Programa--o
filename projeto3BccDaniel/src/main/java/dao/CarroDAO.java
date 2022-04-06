package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import classeBase.Carro;
import classeBase.Marca;

public class CarroDAO {
	
	private Connection c;
	private ArrayList<Carro> listaCarro;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;


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
	
	public void ExecutaTransacaoInsert(Carro carro) throws SQLException {
		
		
//		preparedStatement = c.prepareStatement("select idcarro from carro;");
//		resultSet = preparedStatement.executeQuery();
//		
//		while (resultSet.next()) {
//			carro.setIdCarro(resultSet.getInt("idcarro"));
//		}
//		System.out.println(carro.getIdCarro());
		
		preparedStatement = c.prepareStatement("insert into carro values (?,?)");
		preparedStatement.setInt(1, carro.getIdCarro());
		preparedStatement.setString(2, carro.getNomeDoCarro());
		//preparedStatement.setInt(3, carro.getMarca().getIdMarca());
		preparedStatement.executeUpdate();
				
				
		
	}
	
	public void ExecutaTransacaoUpdate(Carro carro) throws SQLException{
		
//		preparedStatement = c.prepareStatement(
//				
//			"update carro set nomecarro=?, idmarca_fk=? "
//		   +" where (idcarro=?);"
//				
//		);
		
		preparedStatement = c.prepareStatement(
				
				"update carro set nomecarro=? "
			   +" where (idcarro=?);"
					
			);
		preparedStatement.setString(1, carro.getNomeDoCarro());
		//preparedStatement.setInt(2, carro.getMarca().getIdMarca());
		preparedStatement.setInt(2, carro.getIdCarro());
		preparedStatement.executeUpdate();
		
	}
	
	public void ExecutaTransacaoDelete(Carro carro) {
		
		
		try {
			preparedStatement = c.prepareStatement(
					
				"delete carro"
			   +" where (idcarro=? or nomecarro=?);"
					
			);
			preparedStatement.setInt(1, carro.getIdCarro());
			preparedStatement.setString(2, carro.getNomeDoCarro());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "Há proprietários ou marcas que usam esse carro","Erro",2);
//			JOptionPane.showMessageDialog(null, e ,"Exception",0);
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Carro> ExecutaTransacaoASelect(Carro carro)  {
		
		try {
			preparedStatement = c.prepareStatement("select * from carro order by idcarro;");
			resultSet = preparedStatement.executeQuery();
			this.listaCarro = new ArrayList<Carro>();
			while (resultSet.next()) {
				carro = new Carro();
				carro.setIdCarro(resultSet.getInt("idcarro"));
				carro.setNomeDoCarro(resultSet.getString("nomecarro"));
//				carro.getMarca().setIdMarca(resultSet.getInt("idmarca_fk"));
//				carro.getMarca().setNomeMarca(resultSet.getString("nomemarca"));
				this.listaCarro.add(carro);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return this.listaCarro;
	}
	
	



	public CarroDAO() {
		super();
		
		
	}
	
	
	
	
	
}
