package Hook;

public abstract class Pessoa {
	
	private String nome;
	private boolean debito;
	private boolean credito;
	private double saldo;
	
	public Pessoa (String nome, boolean debito, boolean credito, double saldo) {
		super();
		this.nome = nome;
		this.debito = debito;
		this.credito = credito;
		this.saldo = saldo;
	}
	
	public double jurostotaldoimprestimo(double valoremprestimo) {
		return jurosemprestimo(valoremprestimo) * 12;
	}

	protected abstract double jurosemprestimo(double valoremprestimo);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
