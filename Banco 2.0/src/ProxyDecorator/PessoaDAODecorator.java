package ProxyDecorator;

import HookSingletonFluent.Pessoa;

public class PessoaDAODecorator implements PessoaDAOInterface {
	
	private static PessoaDAOInterface pessoaDAO;
	
	private PessoaDAOInterface getDAO() {
		if(pessoaDAO == null) {
			pessoaDAO = new PessoaDAOProxy();
		}
		return pessoaDAO;
	}
	
	public void addCartao(Pessoa pessoa) throws PessoaException {
		if(!pessoa.getConta().isCredito()) {
			throw new PessoaException("Credito: Voce precisa s� desbloquear o cartao pelo caixa eletronico!");
		} else if(!pessoa.getConta().isDebito()) {
			throw new PessoaException("Debito: Voce precisa s� desbloquear o cartao pelo caixa eletronico!");
		} else {
			System.out.println("Tudo certo com os cart�es!");
		}
		getDAO().addCartao(pessoa);
	}
	
	public Pessoa getCartao(Pessoa pessoa) throws PessoaException {
		if(!pessoa.getConta().isCredito()) {
			throw new PessoaException("Credito: Voce precisa solicitar um cartao pelo caixa eletronico!");
		} else if(!pessoa.getConta().isDebito()) {
			throw new PessoaException("Debito: Voce precisa s� desbloquear o cartao pelo caixa eletronico!");
		} else {
			System.out.println("Tudo certo com os cart�es!");
		}
		Pessoa p = getDAO().getCartao(pessoa);
		if(p == null) {
			throw new PessoaException("Usu�rio n�o encontrado!");
		}
		return p;
	}

}
