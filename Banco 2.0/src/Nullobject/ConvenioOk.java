package Nullobject;

public class ConvenioOk extends Convenios {
	
	public ConvenioOk (String convenio) {
		this.convenio = convenio;
	}

	@Override
	public String getConvenio() {
		return "Para finalizar o acordo j� at� uma central f�sica de nosso estabelecimento. \n";
	}

}
