package Nullobject;

public class ConvenioDAO {
	
	public static final String[] convenios = { "Aposentados", "Viajens", "Saúde", "Produtores rurais" };

	public static Convenios getConvenio(String convenio) {
		for (int i = 0; i < convenios.length; i++) 
			if (convenios[i].equalsIgnoreCase(convenio)) 
				return new ConvenioOk(convenio);			
		
		return new NullConvenio();
	}

}
