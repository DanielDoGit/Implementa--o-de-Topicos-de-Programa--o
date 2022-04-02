package classeBase;

import classeBase.*;

public class Carro {
	
	private Integer idCarro;
	private String nomeDoCarro;
	private Marca marca;
	private Proprietario proprietario;
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
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
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Carro(Integer idCarro, String nomeDoCarro, Marca marca, Proprietario proprietario) {
		super();
		this.idCarro = idCarro;
		this.nomeDoCarro = nomeDoCarro;
		this.marca = marca;
		this.proprietario = proprietario;
	}
	
	
	

}
