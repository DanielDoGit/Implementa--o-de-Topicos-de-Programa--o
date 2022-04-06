package classeBase;

public class Marca {

	private Integer idMarca;
	private String nomeMarca;
	
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	
	@Override
	public String toString() {
		return	
			"ID Empresa: " + this.getIdMarca() + "\n" +		
			"Nome da empresa: " + this.getNomeMarca()+ "\n\n";
	}
	
	public Marca(Integer idMarca, String nomeMarca) {
		super();
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}
	
	public Marca() {}
	
	
	
	
	
	
	
}
