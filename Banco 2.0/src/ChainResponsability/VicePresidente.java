package ChainResponsability;

public class VicePresidente extends ValidarEmprestimo {
	
	public void validarEmprestimo(Emprestimo emp) {
		System.out.println("Loan amount of " + emp.getQuantia() + " approved by the Vice President");
	}

}
