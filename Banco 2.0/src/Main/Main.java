package Main;
import java.util.Scanner;

import ChainResponsability.Diretor;
import ChainResponsability.Emprestimo;
import ChainResponsability.Gerente;
import ChainResponsability.ValidarEmprestimo;
import ChainResponsability.VicePresidente;
import Command.AdicionarConvenio;
import Command.ExecutarComandos;
import Composite.ValorConvenios;
import Composite.ValorTotal;
import Composite.ValorUnitario;
import DoubleDispatch.Carros;
import DoubleDispatch.PassagensAereas;
import DoubleDispatch.Troca;
import Facade.CriarConta;
import Flyweight.ListaParcerias;
import Flyweight.ParceriaFactory;
import HookSingletonFluent.Pessoa;
import HookSingletonFluent.PessoaFisica;
import HookSingletonFluent.PessoaJuridica;
import Nullobject.ConvenioDAO;
import Nullobject.Convenios;
import Observer.Service;
import ProxyDecorator.PessoaDAODecorator;
import ProxyDecorator.PessoaDAOInterface;
import ProxyDecorator.PessoaException;
import Strategy.Cartoes;
import State.Atm;
import StaticFactory.Conta;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		Conta conta = new Conta();
		
		Pessoa jobesvaldo = new PessoaFisica().nome("Jobesvaldo").conta(new Conta().addConta(conta, 9999, 25000.00));
		Pessoa waldisney = new PessoaJuridica().nome("Waldisney").conta(new Conta().addCredito(conta, 8888, 50000.00));
		
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
		
		PessoaDAOInterface pessoaDAO = new PessoaDAODecorator();
		
		PassagensAereas pa1 = new PassagensAereas(50000, 100000);
		PassagensAereas pa2 = new PassagensAereas(3000, 1000);
		Carros cr1 = new Carros(10000, 15, 25000);
		Carros cr2 = new Carros(1000, 5, 4500);
		
		do {
			
			System.out.println();
			System.out.println("1. Verificar valor das mensalidades do cartão; \n"); //strategy
			System.out.println("2. Convenios; \n"); //null object
			System.out.println("3. Realizar emprestimo; \n"); //chain of responsibility
			System.out.println("4. Realizar Saque; \n"); //state
			System.out.println("5. Realizar Deposito; \n"); //state
			System.out.println("6. Preço dos convenios; \n"); //composite
			System.out.println("7. Verificar integridade dos cartões; \n"); //proxy decorator
			System.out.println("8. Ver convenios associados; \n"); // commands
			System.out.println("9. Trocar pontinhos; \n"); //double dispatch
			System.out.println("10. Criar Conta; \n"); // facade
			System.out.println("11. Parceiros; \n"); //flyweight
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
					if(jobesvaldo.getConta().getSaldo() < saque) {
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
					
				case 7:
					try {
						pessoaDAO.addCartao(waldisney);
					} catch (PessoaException e) {
						System.err.println("Não consegui verificar os cartões do usuário.");
						System.err.println(e.getMessage());
					}
					
					try {
						pessoaDAO.getCartao(jobesvaldo);
					} catch (PessoaException e) {
						System.err.println("Não consegui verificar os cartões do usuário.");
						System.err.println(e.getMessage());
					}
					break;
					
				case 8:
					String string;
					ExecutarComandos exe = new ExecutarComandos();
					
					System.out.println("Convenios associados: \n");
					
					string = exe.associar(new AdicionarConvenio("Convenio de Viajens", " Associado \n"));
					System.out.println(string);
					
					string = exe.associar(new AdicionarConvenio("Convenio de Aposentados", " Associado \n"));
					System.out.println(string);
					
					string = exe.associar(new AdicionarConvenio("Convenio de Saúde", " Associado \n"));
					System.out.println(string);
					
					System.out.println("Qual convenio gostaria de se desassociar? \n");
					System.out.println("1.Viajens; \n");
					System.out.println("2.Aposentados; \n");
					System.out.println("3.Saúde. \n");
					int aux4 = input.nextInt();
					switch(aux4) {
					
						case 1:
							string = exe.desassociar();
							string = exe.desassociar();
							string = exe.desassociar();
							System.out.println(string);
							break;
							
						case 2:
							string = exe.desassociar();
							string = exe.desassociar();
							System.out.println(string);
							break;
							
						case 3:
							string = exe.desassociar();
							System.out.println(string);
							break;
					
					}									
					break;
					
				case 9:
					boolean loop = true;
					Troca troca = new Troca();
					do {
						System.out.println("Produtos Disponiveis: \n");
						System.out.println("1. Milhas para Orlando - USA: " + pa1.getMilhas() + " milhas, por apenas: " + pa1.getPontos() + " pontinhos.");
						System.out.println("2. Milhas para São Francisco do Sul - BR: " + pa2.getMilhas() + " milhas, por apenas: " + pa2.getPontos() + " pontinhos.");
						System.out.println("3. Corola: " + cr1.getPontos() + " pontinhos, com juros anual de: " + cr1.getJurosanual() + "% apenas, e taxa de: " + cr1.getTaxaextra() + " reais.");
						System.out.println("4. Fusca: " + cr2.getPontos() + " pontinhos, com juros anual de: " + cr2.getJurosanual() + "% apenas, e taxa de: " + cr2.getTaxaextra() + " reais.");
						System.out.println("5. Valor Total.");
						System.out.println("0. Voltar.");
						int aux5 = input.nextInt();
						switch(aux5) {
						
							case 1:
								troca.addTroca(pa1);
								break;
								
							case 2:
								troca.addTroca(pa2);
								break;
								
							case 3:
								troca.addTroca(cr1);
								break;
								
							case 4:
								troca.addTroca(cr2);
								break;
								
							case 5:
								if(troca.getTotal() != 0) {
									System.out.println("Pontinhos necessarios: " + troca.getTotal());
									if(troca.getJuros() != 0) {
										System.out.println("Juros: " + troca.getJuros());
									}
									System.out.println("Para finalizar a troca vá até uma agencia! \n");
								}
								break;
								
							case 0:
								loop = false;
								break;
						
						}
					}while(loop);
					break;
					
				case 10:
					CriarConta cc = new CriarConta();
					System.out.println("1. Conta Corrente;");
					System.out.println("2. Conta Poupança;");
					System.out.println("3. Conta Salário;");
					int aux6 = input.nextInt();
					switch(aux6) {
					
						case 1:
							cc.contaCorrente();
							break;
							
						case 2:
							cc.contaPoupanca();
							break;
							
						case 3:
							cc.contaSalario();
							break;
					
					}
					break;
					
				case 11:
					ListaParcerias lp = new ListaParcerias();
					lp.add(ParceriaFactory.get("MercedesBenz"));
					lp.add(ParceriaFactory.get("Facebook"));
					lp.add(ParceriaFactory.get("Subway"));
					System.out.println(lp.getString());
					break;
					
				case 0:
					System.exit(0);
					break;
			
			}
			
		} while(true);
		
	}

}
