package HookSingletonFluent;

import StaticFactory.Conta;

public abstract class Pessoa {
	
	private String nome;
	private Conta conta;
	
	public Pessoa() {
		
	}
	
	public Pessoa nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Pessoa conta(Conta conta) {
		this.conta = conta;
		return this;
	}
	
	public Pessoa (String nome, Conta conta) {
		super();
		this.nome = nome;
		this.conta = conta;
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
