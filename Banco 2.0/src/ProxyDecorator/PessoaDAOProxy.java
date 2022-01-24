package ProxyDecorator;

import java.util.HashMap;
import java.util.Map;

import HookSingletonFluent.Pessoa;

public class PessoaDAOProxy implements PessoaDAOInterface {
	private Map<String, Pessoa> cartoes;
	
	public PessoaDAOProxy() {
		super();
		this.cartoes = new HashMap<String, Pessoa>();
	}

	public void addCartao(Pessoa pessoa) throws PessoaException {
		this.cartoes.put(pessoa.getNome(), pessoa);
		
	}

	public Pessoa getCartao(Pessoa pessoa) throws PessoaException {
		return pessoa;
	}
	
	

}
