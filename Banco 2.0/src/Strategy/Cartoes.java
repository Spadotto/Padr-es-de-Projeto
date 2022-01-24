package Strategy;

public class Cartoes {
	private boolean credito;
	private boolean debito;
	protected InterfaceMensalidade mensal;
	
	public Cartoes(boolean credito, boolean debito) {
		if (debito) {
			mensal = new CartaoDebito();
		}
		else if (credito) {
			mensal = new CartaoCredito();
		}
	}
	
	public String ValorMensalidade() {
		return mensal.valormensalidade(this);
	}

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

}
