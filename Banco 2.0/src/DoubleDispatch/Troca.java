package DoubleDispatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Troca {
	private List<Pontinhos> pontinhos;
	private Map<ProdutosTroca, Integer> produtos;
	
	public void addTroca(Pontinhos pontos) {
		getPontinhos().add(pontos);
		pontos.addTroca(this);
	}

	public void addProduto(ProdutosTroca troca, int pontos) {
		getProdutos().put(troca, getProdutos().get(troca) + pontos);
	}

	public int getTotal() {
		if (pontinhos.isEmpty())
			return 0;

		int total = 0;
		total += getProdutos().get(ProdutosTroca.PONTOS);
		total += getProdutos().get(ProdutosTroca.MILHAS);
		total += getProdutos().get(ProdutosTroca.TAXA);

		return total;
	}

	public int getJuros() {
		return getProdutos().get(ProdutosTroca.JUROS);
	}

	private List<Pontinhos> getPontinhos() {
		if (pontinhos == null)
			pontinhos = new ArrayList<Pontinhos>();
		return pontinhos;
	}

	private Map<ProdutosTroca, Integer> getProdutos() {
		if (produtos == null) {
			produtos = new HashMap<ProdutosTroca, Integer>();
			for (ProdutosTroca tipo : ProdutosTroca.values())
				produtos.put(tipo, 0);
		}
		return produtos;
	}

}
