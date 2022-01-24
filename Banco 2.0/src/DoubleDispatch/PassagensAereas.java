package DoubleDispatch;

public class PassagensAereas extends Pontinhos {
	private int milhas;
	
	public PassagensAereas(int pontos, int milhas) {
		super(pontos);
		this.milhas = milhas;
	}
	
	public void addTroca(Troca troca) {
		super.addTroca(troca);
		troca.addProduto(ProdutosTroca.MILHAS, milhas);
		
	}

	public int getMilhas() {
		return milhas;
	}

	public void setMilhas(int milhas) {
		this.milhas = milhas;
	}

}
