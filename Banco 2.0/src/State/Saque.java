package State;

import Hook.Pessoa;

public class Saque implements AtmState {
	
	public AtmState saque(double newsaldo, Pessoa pessoa) {
		pessoa.setSaldo(pessoa.getSaldo() - newsaldo);
		System.out.println("O novo saldo é de: " + pessoa.getSaldo() + " reais.");
		return this;
	}

	public AtmState deposito(double newsaldo, Pessoa pessoa) {
		pessoa.setSaldo(newsaldo + pessoa.getSaldo());
		System.out.println("O novo saldo é de: " + pessoa.getSaldo() + " reais.");
		return new Deposito();
	}

}
