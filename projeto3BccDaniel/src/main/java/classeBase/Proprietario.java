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
	
	public Proprietario() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return	
			"ID Empresa: " + this.getIdProprietario() + "\n" +		
			"Nome da empresa: " + this.getNomeDoProprietario()+ "\n\n";
	}
	
	
	
	
	
}
