package DoubleDispatch;

public class Carros extends Pontinhos {
	private int jurosanual;
	private int taxaextra;
	
	public Carros(int pontos, int jurosanual, int taxaextra) {
		super(pontos);
		this.jurosanual = jurosanual;
		this.taxaextra = taxaextra;
	}
	
	public void addTroca(Troca troca) {
		super.addTroca(troca);
		troca.addProduto(ProdutosTroca.JUROS, jurosanual);
		troca.addProduto(ProdutosTroca.TAXA, taxaextra);
	}
	
	public int getJurosanual() {
		return jurosanual;
	}

	public void setJurosanual(int jurosanual) {
		this.jurosanual = jurosanual;
	}

	public int getTaxaextra() {
		return taxaextra;
	}

	public void setTaxaextra(int taxaextra) {
		this.taxaextra = taxaextra;
	}
	
}
