package State;

import HookSingletonFluent.Pessoa;

public interface AtmState {
	
	AtmState saque(double newsaldo, Pessoa pessoa);
	
	AtmState deposito(double newsaldo, Pessoa pessoa);

}
