package Facade;

public class CriarConta {
	private ContaCorrente cc;
	private ContaPoupanca cp;
	private ContaSalario cs;
	
	public CriarConta() {
		cc = new ContaCorrente();
		cp = new ContaPoupanca();
		cs = new ContaSalario();
	}
	
	public void contaCorrente() {
		cc.criarConta();
	}
	
	public void contaPoupanca() {
		cp.criarConta();
	}
	
	public void contaSalario() {
		cs.criarConta();
	}

}
