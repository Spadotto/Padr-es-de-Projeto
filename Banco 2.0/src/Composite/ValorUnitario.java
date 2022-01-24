package Composite;

public class ValorUnitario implements ValorConvenios {
	
	private double precomensal;
	private double precoanual;
	
	public ValorUnitario(double precomensal, double precoanual) {
		this.precomensal = precomensal;
		this.precoanual = precoanual;
	}

	@Override
	public double precomensal() {
		return precomensal;
	}

	@Override
	public double precoanual() {
		precoanual = precomensal * 12;
		return precoanual;
	}
	
	@Override
	public String toString() {
		return "[Preço mensal:" + precomensal + ", Preco anual:" + precoanual + "]";
	}

}
