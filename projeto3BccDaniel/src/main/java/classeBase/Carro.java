package classeBase;

import classeBase.*;

public class Carro {
	
	private Integer idCarro;
	private String nomeDoCarro;
	
	public Integer getIdCarro() {
		return idCarro;
	}
	
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	
	public String getNomeDoCarro() {
		return nomeDoCarro;
	}
	
	public void setNomeDoCarro(String nomeDoCarro) {
		this.nomeDoCarro = nomeDoCarro;
	}
	
	

	public Carro(Integer idCarro, String nomeDoCarro) {
		super();
		this.idCarro = idCarro;
		this.nomeDoCarro = nomeDoCarro;
		
	}

	public Carro() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return	
			"ID Carro: " + this.getIdCarro() + "\n" +		
			"Nome do Carro: " + this.getNomeDoCarro()+ "\n\n";
	}
	
	
	

}
