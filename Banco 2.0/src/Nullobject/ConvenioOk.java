package Nullobject;

public class ConvenioOk extends Convenios {
	
	public ConvenioOk (String convenio) {
		this.convenio = convenio;
	}

	@Override
	public String getConvenio() {
		return "Para finalizar o acordo já até uma central física de nosso estabelecimento. \n";
	}

}
