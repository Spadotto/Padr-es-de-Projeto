package Strategy;

public class CartaoDebito implements InterfaceMensalidade {
	
	public String valormensalidade(Cartoes cartoes) {
		return "O valor da mensalidade do cart�o de debito � de R$ 0,00 :). \n";
	}

}
