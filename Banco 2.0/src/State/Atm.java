package State;

import HookSingletonFluent.Pessoa;
import Observer.Observable;
import Observer.Observer;

public class Atm implements Observer {
	
	protected AtmState state;
	
	public Atm() {
		state = new Saque();
	}
	
	public void saque(double newsaldo, Pessoa pessoa) {
		state = state.saque(newsaldo, pessoa);
	}
	
	public void deposito(double newsaldo, Pessoa pessoa) {
		state = state.deposito(newsaldo, pessoa);
	}
	
	public void notify(Observable observable, String message) {
		System.out.println("Foi notificado um " + observable + " na sua conta: " + message);
	}
	
}
