package ProxyDecorator;

import HookSingletonFluent.Pessoa;

public interface PessoaDAOInterface {
	
	public void addCartao(Pessoa pessoa) throws PessoaException;
	
	public Pessoa getCartao(Pessoa pessoa) throws PessoaException;

}
