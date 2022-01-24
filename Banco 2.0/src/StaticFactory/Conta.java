package StaticFactory;

public class Conta {
	
	private int numconta;
	private boolean credito;
	private boolean debito;
	private double saldo;
	
	public Conta() {
		super();
	}
	
	private Conta(int numconta) {
		this.numconta = numconta;
		this.credito = false;
		this.debito = false;
		this.saldo = 0.0;
	}
	
	private Conta(int numconta, double saldo) {
		this.numconta = numconta;
		this.saldo = saldo;
		this.credito = false;
		this.debito = false;
	}
	
	private Conta(int numconta, double saldo, boolean credito) {
		this.numconta = numconta;
		this.saldo = saldo;
		this.credito = true;
		this.debito = false;
	}
	
	private Conta(int numconta, double saldo, boolean credito, boolean debito) {
		this.numconta = numconta;
		this.saldo = saldo;
		this.credito = true;
		this.debito = true;
	}
	
	public static Conta criarConta(Conta conta, int numconta) {
		if(conta != null) {
			conta.setNumconta(numconta);
			return conta;
		}
		
		if(numconta == 0) {
			return null;
		}
		
		return new Conta(numconta);
	}
	
	public static Conta addSaldo(Conta conta, int numconta, double saldo) {
		if(conta != null) {
			conta.setNumconta(numconta);
			conta.setSaldo(saldo);
			return conta;
		}
		
		if(numconta == 0) {
			return null;
		}
		
		return new Conta(numconta, saldo);
	}
	
	public static Conta addCredito(Conta conta, int numconta, double saldo) {
		if(conta != null) {
			conta.setNumconta(numconta);
			conta.setSaldo(saldo);
			conta.setCredito(true);
			conta.setDebito(false);
			return conta;
		}
		
		if(numconta == 0) {
			return null;
		}
		
		return new Conta(numconta, saldo, true);
	}
	
	public static Conta addDebito(Conta conta, int numconta, double saldo) {
		if(conta != null) {
			conta.setNumconta(numconta);
			conta.setSaldo(saldo);
			conta.setDebito(true);
			return conta;
		}
		
		if(numconta == 0) {
			return null;
		}
		
		Conta c = new Conta(numconta, saldo);
		c.setDebito(true);
		return c;
	}
	
	public static Conta addConta(Conta conta, int numconta, double saldo) {
		if(conta != null) {
			conta.setNumconta(numconta);
			conta.setSaldo(saldo);
			conta.setCredito(true);
			conta.setDebito(true);
			return conta;
		}
		
		if(numconta == 0) {
			return null;
		}
		
		return new Conta(numconta, saldo, true, true);
	}

	public int getNumconta() {
		return numconta;
	}

	public void setNumconta(int numconta) {
		this.numconta = numconta;
	}

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
