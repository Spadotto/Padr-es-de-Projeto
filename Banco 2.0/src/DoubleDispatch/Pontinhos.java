package DoubleDispatch;

public abstract class Pontinhos {
	
	private int pontos;
	
	public Pontinhos(int pontos) {
		super();
		this.pontos = pontos;
	}
	
	public void addTroca(Troca troca) {
		troca.addProduto(ProdutosTroca.PONTOS, pontos);
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
