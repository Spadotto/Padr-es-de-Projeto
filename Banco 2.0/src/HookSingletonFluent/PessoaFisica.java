package HookSingletonFluent;

import StaticFactory.Conta;

public class PessoaFisica extends Pessoa {
	
	public PessoaFisica() {

	}

	public PessoaFisica(String nome, Conta conta) {
		super(nome, conta);
	}

	protected double jurosemprestimo(double valoremprestimo) {
		return valoremprestimo * 0.1;
	}
	
}
