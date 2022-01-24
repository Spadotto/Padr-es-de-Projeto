package State;

import HookSingletonFluent.Pessoa;

public class Deposito implements AtmState {
	
	public AtmState saque(double newsaldo, Pessoa pessoa) {
		pessoa.getConta().setSaldo(pessoa.getConta().getSaldo() - newsaldo);
		System.out.println("O novo saldo é de: " + pessoa.getConta().getSaldo() + " reais.");
		return new Saque();
	}

	public AtmState deposito(double newsaldo, Pessoa pessoa) {
		pessoa.getConta().setSaldo(newsaldo + pessoa.getConta().getSaldo());
		System.out.println("O novo saldo é de: " + pessoa.getConta().getSaldo() + " reais.");
		return this;
	}

}
