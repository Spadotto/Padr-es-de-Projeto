package ChainResponsability;

public abstract class ValidarEmprestimo {
	
	protected ValidarEmprestimo proximo;

	public void proximoValidador(ValidarEmprestimo proximo) {
		this.proximo = proximo;
	}

	public abstract void validarEmprestimo(Emprestimo emp);

}
