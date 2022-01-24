package ChainResponsability;

public class Diretor extends ValidarEmprestimo {
	
	public void validarEmprestimo(Emprestimo emp) {
		if (emp.getQuantia() <= 250000)
			System.out.println("Loan amount of " + emp.getQuantia() + " approved by the Director");
        else
            proximo.validarEmprestimo(emp);
	}

}
