package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classeBase.Carro;
import classeBase.Marca;

public class MarcaDAO {

	private Connection c;
	private ArrayList<Marca> listaMarca;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;


	public void pegaConexao(Connection c) {
		this.c = c;
	}
	
	public ArrayList<Marca> getListaCarro() {
		return listaMarca;
	}
	public void setListaCarro(ArrayList<Marca> listaMarca) {
		this.listaMarca = listaMarca;
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
	
	public void ExecutaTransacaoInsert(Marca marca) throws SQLException {
		
		
//		preparedStatement = c.prepareStatement("select idmarca from marca;");
//		resultSet = preparedStatement.executeQuery();
//		
//		while (resultSet.next()) {
//			marca.setIdMarca(resultSet.getInt("idmarca"));
//		}
		
		preparedStatement = c.prepareStatement("insert into marca values (?,?)");
		preparedStatement.setInt(1, marca.getIdMarca());
		preparedStatement.setString(2, marca.getNomeMarca());
		preparedStatement.executeUpdate();
				
				
		
	}
	
	public void ExecutaTransacaoUpdate(Marca marca) throws SQLException{
		
		preparedStatement = c.prepareStatement(
				
			"update marca set nomemarca=?"
		   +" where (idmarca=?);"
				
		);
		preparedStatement.setString(1, marca.getNomeMarca());
		preparedStatement.setInt(2, marca.getIdMarca());
		
		preparedStatement.executeUpdate();
		
	}
	
	public void ExecutaTransacaoDelete(Marca marca) {
		
		
		try {
			preparedStatement = c.prepareStatement(
					
				"delete marca"
			   +" where (idmarca=? or nomemarca=?);"
					
			);
			preparedStatement.setInt(1, marca.getIdMarca());
			preparedStatement.setString(2, marca.getNomeMarca());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "Há proprietários ou marcas que usam esse carro","Erro",2);
//			JOptionPane.showMessageDialog(null, e ,"Exception",0);
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Marca> ExecutaTransacaoASelect(Marca marca)  {
		
		try {
			preparedStatement = c.prepareStatement("select * from marca order by idmarca;");
			resultSet = preparedStatement.executeQuery();
			this.listaMarca = new ArrayList<Marca>();
			while (resultSet.next()) {
				marca = new Marca();
				marca.setIdMarca(resultSet.getInt("idmarca"));
				marca.setNomeMarca(resultSet.getString("nomemarca"));
				this.listaMarca.add(marca);	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return this.listaMarca;
	}
	
		
	

	
}
