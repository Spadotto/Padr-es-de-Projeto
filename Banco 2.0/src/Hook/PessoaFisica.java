package Hook;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(String nome, boolean debito, boolean credito, double saldo) {
		super(nome, debito, credito, saldo);
	}

	protected double jurosemprestimo(double valoremprestimo) {
		return valoremprestimo * 0.1;
	}
	
}
