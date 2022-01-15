package Main;
import java.util.Scanner;

import ChainResponsability.Diretor;
import ChainResponsability.Emprestimo;
import ChainResponsability.Gerente;
import ChainResponsability.ValidarEmprestimo;
import ChainResponsability.VicePresidente;
import Composite.ValorConvenios;
import Composite.ValorTotal;
import Composite.ValorUnitario;
import Hook.Pessoa;
import Hook.PessoaFisica;
import Hook.PessoaJuridica;
import Nullobject.ConvenioDAO;
import Nullobject.Convenios;
import Observer.Service;
import Strategy.Cartoes;
import State.Atm;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		Pessoa jobesvaldo = new PessoaFisica("Jobesvaldo", true, true, 25000.00);
		Pessoa waldisney = new PessoaJuridica("Waldisney", false, true, 50000.00);
		
		Convenios conv1 = ConvenioDAO.getConvenio("Aposentados");
		Convenios conv2 = ConvenioDAO.getConvenio("Viajens");
		Convenios conv3 = ConvenioDAO.getConvenio("Saúde");
		Convenios conv4 = ConvenioDAO.getConvenio("Produtores rurais");
		Convenios conv5 = ConvenioDAO.getConvenio("Veterinário");
		Convenios conv6 = ConvenioDAO.getConvenio("Fidelidade");
		
		Atm atm = new Atm();
		Service saquen = new Service("saque");
		Service depositon = new Service("deposito");
		
		saquen.addObserver(atm);
		depositon.addObserver(atm);
		
		ValorConvenios unico1 = new ValorUnitario(150.00, 0);
		ValorConvenios unico2 = new ValorUnitario(350.00, 0);
		ValorConvenios composto = new ValorTotal(unico1, unico2);
		
		ValidarEmprestimo a = new Gerente();
		ValidarEmprestimo b = new Diretor();
		ValidarEmprestimo c = new VicePresidente();
		
		a.proximoValidador(b);
		b.proximoValidador(c);
		
		do {
			
			System.out.println();
			System.out.println("1. Verificar valor das mensalidades do cartão; \n");
			System.out.println("2. Convenios; \n");
			System.out.println("3. Realizar emprestimo; \n");
			System.out.println("4. Realizar Saque; \n");
			System.out.println("5. Realizar Deposito; \n");
			System.out.println("6. Preço dos convenios; \n");
			System.out.println("0. Sair. \n");
			int aux = input.nextInt();
			switch (aux) {
			
				case 1:
					System.out.println("Qual dos cartões deseja verificar a cobrança de mensalidade? \n");
					System.out.println("1. Crédito; \n");
					System.out.println("2. Débito; \n");
					System.out.println("0. Voltar. \n");
					int aux1 = input.nextInt();
					switch (aux1) {
						
						case 1:
							Cartoes credito = new Cartoes(true, false);
							System.out.println(credito.ValorMensalidade());
							break;
							
						case 2:
							Cartoes debito = new Cartoes(false, true);
							System.out.println(debito.ValorMensalidade());
							break;
							
						case 3:
							break;
					
					}
					break;
				
				case 2:
					System.out.println("Digite o numero do convenio ao qual deseja assosciar-se: \n");
					System.out.println("1. Convenio para aposentados; \n");
					System.out.println("2. Convenio de viajens; \n");
					System.out.println("3. Convenio para saúde; \n");
					System.out.println("4. Convenio para produtores rurais; \n");
					System.out.println("5. Convenio veterinário; \n");
					System.out.println("6. Convenio fidelidade; \n");
					System.out.println("0. Voltar. \n");
					int aux2 = input.nextInt();
					switch (aux2) {
					
						case 1:
							System.out.println(conv1.getConvenio());
							break;
						
						case 2:
							System.out.println(conv2.getConvenio());
							break;
						
						case 3:
							System.out.println(conv3.getConvenio());
							break;
							
						case 4:
							System.out.println(conv4.getConvenio());
							break;
							
						case 5:
							System.out.println(conv5.getConvenio());
							break;
							
						case 6:
							System.out.println(conv6.getConvenio());
							break;
							
						case 0:
							break;
						
					}
					break;
					
					
				case 3:
					System.out.println("Em qual conta será o emprestimo? \n");
					System.out.println("1. Jobesvaldo; \n");
					System.out.println("2. Waldisney; \n");
					System.out.println("0. Voltar. \n");
					int aux3 = input.nextInt();
					switch (aux3) {
						
						case 1:
							System.out.println("Valor do emprestimo: \n");
							double emprestimo = input.nextDouble();
							System.out.println("Juros total do emprestimo é de " + jobesvaldo.jurostotaldoimprestimo(emprestimo));
							a.validarEmprestimo(new Emprestimo(emprestimo));
							b.validarEmprestimo(new Emprestimo(emprestimo));
							c.validarEmprestimo(new Emprestimo(emprestimo));
							break;
							
						case 2:
							System.out.println("Valor do emprestimo: \n");
							double emprestimo2 = input.nextDouble();
							System.out.println("Juros total do emprestimo é de " + waldisney.jurostotaldoimprestimo(emprestimo2));
							break;
							
						case 3:
							break;
					
					}
					break;
					
				case 4:					
					System.out.println("Valor do saque: \n");
					double saque = input.nextDouble();
					if(jobesvaldo.getSaldo() < saque) {
						System.out.println("Não é possível realizar operação, saldo insuficiente. \n");
					} else {
						atm.saque(saque, jobesvaldo);
					}
					saquen.notify("Saque no valor de: " + saque + " realizado na conta de Jobesvaldo. \n");
					break;
					
				case 5:
					System.out.println("Valor do deposito: \n");
					double deposito = input.nextDouble();
					atm.deposito(deposito, jobesvaldo);
					depositon.notify("Deposito no valor de: " + deposito + " realizado na conta de Jobesvaldo. \n");
					break;
					
				case 6:
					System.out.println("Valor mensal mais barato de apenas um convenio: " + unico1.precomensal() + "reais.");
					System.out.println("Gasto anual desse convenio: " + unico1.precoanual() + " reais. \n");
					System.out.println("Valor mensal mais caro de apenas um convenio: " + unico2.precomensal() + " reais.");
					System.out.println("Gasto anual desse convenio: " + unico2.precoanual() + " reais. \n");
					System.out.println("Nosso desconto a associados a estes dois convenios: ");
					System.out.println("Valor mensal: " + composto.precomensal() + " reais.");
					System.out.println("Valor anual: " + composto.precoanual() + " reais. \n");
					break;
					
				case 0:
					System.exit(0);
					break;
			
			}
			
		} while(true);
		
	}

}
