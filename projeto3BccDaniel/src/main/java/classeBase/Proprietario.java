package classeBase;

public class Proprietario {

	private Integer idProprietario;
	private String nomeDoProprietario;
	
	public Integer getIdProprietario() {
		return idProprietario;
	}
	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}
	public String getNomeDoProprietario() {
		return nomeDoProprietario;
	}
	public void setNomeDoProprietario(String nomeDoProprietario) {
		this.nomeDoProprietario = nomeDoProprietario;
	}
	
	public Proprietario(Integer idProprietario, String nomeDoProprietario) {
		super();
		this.idProprietario = idProprietario;
		this.nomeDoProprietario = nomeDoProprietario;
	}
	
	
	
}
