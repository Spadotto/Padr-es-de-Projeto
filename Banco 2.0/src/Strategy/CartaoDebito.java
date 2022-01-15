package Strategy;

public class CartaoDebito implements InterfaceMensalidade {
	
	public String valormensalidade(Cartoes cartoes) {
		return "O valor da mensalidade do cartão de debito é de R$ 0,00 :). \n";
	}

}
