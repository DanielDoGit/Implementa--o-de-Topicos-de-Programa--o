package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classeBase.Carro;
import classeBase.Proprietario;

public class ProprietarioDAO {

	private Connection c;
	private ArrayList<Proprietario> listaProprietario;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;


	public void pegaConexao(Connection c) {
		this.c = c;
	}
	
	public ArrayList<Proprietario> getListaCarro() {
		return listaProprietario;
	}
	public void setListaCarro(ArrayList<Proprietario> listaProprietario) {
		this.listaProprietario = listaProprietario;
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
	
	public void ExecutaTransacaoInsert(Proprietario proprietario) throws SQLException {
		
		
//		preparedStatement = c.prepareStatement("select idproprietario from proprietario;");
//		resultSet = preparedStatement.executeQuery();
//		
//		while (resultSet.next()) {
//			proprietario.setIdProprietario(resultSet.getInt("idproprietario"));
//		}
//		
		preparedStatement = c.prepareStatement("insert into proprietario values (?,?)");
		preparedStatement.setInt(1, proprietario.getIdProprietario()+1);
		preparedStatement.setString(2, proprietario.getNomeDoProprietario());
		//preparedStatement.setInt(3, carro.getMarca().getIdMarca());
		preparedStatement.executeUpdate();
				
				
		
	}
	
	public void ExecutaTransacaoUpdate(Proprietario proprietario) throws SQLException{
		
//		preparedStatement = c.prepareStatement(
//				
//			"update carro set nomecarro=?, idmarca_fk=? "
//		   +" where (idcarro=?);"
//				
//		);
		
		preparedStatement = c.prepareStatement(
				
				"update proprietario set nomeproprietario=? "
			   +" where (idproprietario=?);"
					
			);
		preparedStatement.setString(1, proprietario.getNomeDoProprietario());
		//preparedStatement.setInt(2, carro.getMarca().getIdMarca());
		preparedStatement.setInt(2, proprietario.getIdProprietario());
		preparedStatement.executeUpdate();
		
	}
	
	public void ExecutaTransacaoDelete(Proprietario proprietario) {
		
		
		try {
			preparedStatement = c.prepareStatement(
					
				"delete proprietario"
			   +" where (idproprietario=? or nomeproprietario=?);"
					
			);
			preparedStatement.setInt(1, proprietario.getIdProprietario());
			preparedStatement.setString(2, proprietario.getNomeDoProprietario());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "Há proprietários ou marcas que usam esse carro","Erro",2);
//			JOptionPane.showMessageDialog(null, e ,"Exception",0);
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Proprietario> ExecutaTransacaoASelect(Proprietario proprietario)  {
		
		try {
			preparedStatement = c.prepareStatement("select * from proprietario order by idproprietario;");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				proprietario = new Proprietario();
				proprietario.setIdProprietario(resultSet.getInt("idproprietario"));
				proprietario.setNomeDoProprietario(resultSet.getString("nomeproprietario"));
//				carro.getMarca().setIdMarca(resultSet.getInt("idmarca_fk"));
//				carro.getMarca().setNomeMarca(resultSet.getString("nomemarca"));
				this.listaProprietario.add(proprietario);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return this.listaProprietario;
	}
	
	



	 public ProprietarioDAO() {
		// TODO Auto-generated constructor stub
		this.listaProprietario = new ArrayList<Proprietario>();
	};
	
	
}
