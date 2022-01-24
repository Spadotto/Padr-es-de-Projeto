package Command;

public class AdicionarConvenio implements Comandos {
	
	private String convenio;
	private String associado;
	
	public AdicionarConvenio(String convenio, String associado) {
		super();
		this.associado = associado;
		this.convenio = convenio;
	}
	
	public String associar() {
		return convenio.concat(associado);
	}
	
	public String desassociar() {
		return convenio.concat(" não associado! \n");
	}
	
}
