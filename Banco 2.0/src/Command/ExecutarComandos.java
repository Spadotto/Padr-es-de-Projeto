package Command;

import java.util.Stack;

public class ExecutarComandos {
	private Stack<Comandos> associar;
	private Stack<Comandos> desassociar;
	
	public ExecutarComandos() {
		super();
		this.associar = new Stack<Comandos>();
		this.desassociar = new Stack<Comandos>();
	}
	
	public String associar(Comandos comandos) {
		associar.push(comandos);
		desassociar.clear();
		return comandos.associar();
	}
	
	public String desassociar() {
		if(associar.isEmpty()) {
			return "";
		}
		Comandos comandos = associar.pop();
		desassociar.push(comandos);
		return comandos.desassociar();
	}

}
