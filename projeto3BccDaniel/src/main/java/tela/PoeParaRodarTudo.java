package tela;

import java.sql.SQLException;

import dao.ConexaoBancoDeDados;

public class PoeParaRodarTudo {

	public static void main(String[] args) {
		try {
			new ConexaoBancoDeDados();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
