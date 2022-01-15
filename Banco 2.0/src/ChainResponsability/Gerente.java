package ChainResponsability;

public class Gerente extends ValidarEmprestimo {

	public void validarEmprestimo(Emprestimo emp) {
		if (emp.getQuantia() <= 100000)
            System.out.println("Loan amount of " + emp.getQuantia() + " approved by the Manager"); 
        else
            proximo.validarEmprestimo(emp);
	}

}
