package br.aplication;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.model.Evento;
import br.model.Ingresso;
import br.model.Local;

public class Program {

	public static void main(String[] args) {
		
	
		List<Evento> list = new ArrayList<Evento>();
		Scanner menu = new Scanner (System.in);
		boolean condicao = true;
		
		while(condicao) {
			System.out.println();System.out.println();
		System.out.print("##--Teste Estrutura de Menu--##\n\n");
		System.out.print("|----------------------------------------------------------|\n");
		System.out.print("| Opção 1 - Informar valor do ingresso para os eventos     |\n");
		System.out.print("| Opção 2 - Adicionar os locais ao evento                  |\n");
		System.out.print("| Opção 3 - Cadastrar novo evento                          |\n");
		System.out.print("| Opção 4 - Consultar eventos disponiveis                  |\n");
		System.out.print("| Opção 5 - Comprar ingresso                               |\n");
		System.out.print("| Opção 6 - Valor total da compra                          |\n");
		System.out.print("| Opção 7 - Sair                                           |\n");
		System.out.print("|----------------------------------------------------------|\n");
		System.out.println();
		System.out.print("Digite uma opção: ");
		
		int opcao = menu.nextInt();

		switch (opcao) {
		
		case 1:
			try {
			if(list.size() == 0) {System.out.println("Crie um novo evento para continuar!");break;}
			
			System.out.println("Escolha qual evento deseja setar o valor do ingresso: ");
			
			
			for (Evento evento : list) {
				
				System.out.println("Digite: "+ list.indexOf(evento) + " para o evento: " + evento.getNome());
			
			}
		

			int opcaoEvento = menu.nextInt();

			if(list.get(opcaoEvento) == null) { System.out.println("Selecione um evento válido ou crie um novo evento!");break;}
				System.out.println("Digite o valor do ingresso: ");
				float valor = menu.nextFloat();		
				list.get(opcaoEvento).setIngresso(new Ingresso(valor));		
				break;
			} catch (NullPointerException e) {

				System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");

			}
		case 2:
			try {	
			if(list.size() == 0) {System.out.println("Crie um novo evento para continuar!");break;}
			System.out.println("Escolha qual evento deseja setar o local: ");
			
			
				for(Evento a : list) {
				
				System.out.println("Digite: "+ list.indexOf(a) + " para setar o local do evento: " + a.getNome());
			
			}
		
			
			int opcaoLocal = menu.nextInt();
			if(list.get(opcaoLocal) == null) { System.out.println("Selecione um evento válido ou crie um novo evento!");break;}	
			
				menu.nextLine();
				Local local = new Local();
				System.out.println("Digite o endereço do local: ");
				String endereco = menu.nextLine();
				System.out.println("Digite o capacidade do local: ");
				int capacidade = menu.nextInt();
				local.setCapacidade(capacidade);
				local.setEndereco(endereco);
				
				list.get(opcaoLocal).setLocal(local);

			}catch(NullPointerException e) {

					System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");

				}
		break;
		
		case 3:
			try {
			menu.nextLine();
			Evento evento = new Evento();
			System.out.println("Digite o nome do evento: ");
			evento.setNome(menu.nextLine());
			System.out.println("Digite a data do evento: ");
			evento.setData(menu.nextLine());
			System.out.println("Digite a hora do evento: ");
			evento.setHora(menu.nextLine());
			System.out.println("Digite o(s) artista(s) do evento: ");
			evento.setArtista(menu.nextLine());
			System.out.println("Pressione enter para confirmar");
			menu.nextLine();
			
			list.add(evento);
			
			}catch(NullPointerException e) {

				System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");

			}
			break;
			
		
		case 4:
			
			
			try {
			if(list.size() == 0) {System.out.println("Crie um novo evento para continuar!");break;}
			System.out.println("Eventos disponíveis: ");
			System.out.println("Só aparecerão eventos cujos locais e ingressos estão definidos");
			
			for(Evento b : list) {
		
				if(b.getIngresso() == null && b.getLocal()==null) {
					continue;		
				}
				else if(b.getIngresso().getQuantidadeVendida() < b.getLocal().getCapacidade()) {
					System.out.println(b);
				}else {
					System.out.println("Não há eventos disponíveis");	
				}
	
				}
			}catch(NullPointerException e) {

					System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");

			}
			break;
			
		
		
		case 5:
			
			
			if(list.size() == 0) {System.out.println("Crie um novo evento para continuar!");break;}
			boolean validarErro = false;
			System.out.println("Eventos disponíveis para compra de ingressos: ");
			System.out.println("Só aparecerão eventos cujos locais e ingressos estiverem definidos");
			for(Evento c : list) {
			
				if(c.getIngresso() == null || c.getLocal()==null) {
					continue;
				}else if(c.getIngresso().getQuantidadeVendida() < c.getLocal().getCapacidade()) {
					System.out.println("Digite " + list.indexOf(c) + " para comprar um ingresso no evento: " + c);
					validarErro = true;
					
				}
				
				}
	
			
				try {
					
					if(validarErro) {
				System.out.println("Digite uma opção: ");
				int option = menu.nextInt();
				
				int disponivel = list.get(option).getLocal().getCapacidade()-list.get(option).getIngresso().getQuantidadeVendida();
				list.get(option).getIngresso().setQuantidadeDisponivel(disponivel);
				System.out.println("Digite a quantidade de ingressos que deseja comprar: ");
				int quantidade = menu.nextInt();
				
				if(quantidade<= list.get(option).getIngresso().getQuantidadeDisponivel()) {
					list.get(option).getIngresso().setQuantidadeVendida(quantidade);
				}
				}else {
					System.out.println("Não há eventos disponíveis");
					break;
				}
			
				} catch (NullPointerException e) {
					
					System.out.println("Houve um erro no processamento, verifique se existe eventos\n "
							+ "com ingressos e locais definidos ou digite uma opção válida");
					
				}
			break;

		case 6:
				
			try {
			if(list.size() == 0) {System.out.println("Crie um novo evento para continuar!");break;}
				float total = 0;

				for(Evento d : list) {
					if(d.getIngresso() == null && d.getLocal()==null) {
						continue;
			}
				total += (d.getIngresso().getValor() * d.getIngresso().getQuantidadeVendida());
			
				}
				System.out.println("Valor total da compra: R$" + total + " reais");
			}catch (NullPointerException e) {
				System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");
			}
			break;
		case 7:
			
			condicao = false;
			
		break;
		default:
				
		System.out.println("Opção inválida tente novamente.");
		break;
			
		}
	
		}
		menu.close();
		}		
}
	




	



