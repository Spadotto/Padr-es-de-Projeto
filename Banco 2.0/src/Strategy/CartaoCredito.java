package Strategy;

public class CartaoCredito implements InterfaceMensalidade {
	
	public String valormensalidade(Cartoes cartoes) {
		return "O valor da mensalidade do cartão de crédito é de R$ 12,00. \n";
	}

}
