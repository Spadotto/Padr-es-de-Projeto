package Hook;

public class PessoaJuridica extends Pessoa {

	public PessoaJuridica(String nome, boolean debito, boolean credito, double saldo) {
		super(nome, debito, credito, saldo);
	}

	protected double jurosemprestimo(double valoremprestimo) {
		return valoremprestimo * 0.3;
	}

}
