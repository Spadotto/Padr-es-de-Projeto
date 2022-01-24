package HookSingletonFluent;

import StaticFactory.Conta;

public class PessoaJuridica extends Pessoa {
	
	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(String nome, Conta conta) {
		super(nome, conta);
	}

	protected double jurosemprestimo(double valoremprestimo) {
		return valoremprestimo * 0.3;
	}

}
