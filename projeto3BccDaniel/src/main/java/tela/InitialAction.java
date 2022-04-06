package tela;

import java.sql.SQLException;

import classeBase.Carro;
import classeBase.Marca;
import classeBase.Proprietario;
import dao.CarroDAO;
import dao.ConexaoBancoDeDados;
import dao.MarcaDAO;
import dao.ProprietarioDAO;

public class InitialAction extends Initial {

	public static void main(String[] args) {
		try {
			ConexaoBancoDeDados conexao = new ConexaoBancoDeDados();			
			Carro carro = new Carro(9,"TestenomeCarro10");
			CarroDAO carroDAO = new CarroDAO();
			carroDAO.pegaConexao(conexao.getConnection());
		
			//insert 
			carroDAO.ExecutaTransacaoInsert(carro);
			
			//update
			carro.setNomeDoCarro("Montana2");
			carroDAO.ExecutaTransacaoUpdate(carro);
			
			//delete
			carroDAO.ExecutaTransacaoDelete(carro);
			
			//select
			for(Carro c: carroDAO.ExecutaTransacaoASelect(carro)) {
				System.out.println(c.toString());
			}
			
			
		Marca marca = new Marca(4,"TesteNomeMarca2");
		MarcaDAO marcaDAO = new MarcaDAO();
		marcaDAO.pegaConexao(conexao.getConnection());
		
		// insert
		marcaDAO.ExecutaTransacaoInsert(marca);
		
		//update
		marca.setNomeMarca("Bugatti e Ferrari");
		marcaDAO.ExecutaTransacaoUpdate(marca);
		
		//delete
		marca.setNomeMarca("Bugatti e Ferrari");
		marcaDAO.ExecutaTransacaoDelete(marca);
		
		//Select
		for(Object c: marcaDAO.ExecutaTransacaoASelect(marca)) {
			System.out.println(c.toString());
		}
		
		
		Proprietario proprietario = new Proprietario(2,"Pedro Batista Pereira");
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		proprietarioDAO.pegaConexao(conexao.getConnection());
		
		//insert
		proprietarioDAO.ExecutaTransacaoInsert(proprietario);
		
		//update
		proprietarioDAO.ExecutaTransacaoUpdate(proprietario);
		
		//delete
		proprietarioDAO.ExecutaTransacaoDelete(proprietario);
		
		//Select
		for(Object c: proprietarioDAO.ExecutaTransacaoASelect(proprietario)) {
			System.out.println(c.toString());
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
