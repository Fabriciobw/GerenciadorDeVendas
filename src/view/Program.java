package view;


import java.util.Scanner;

import model.Evento;
import model.Ingresso;
import model.Local;

public class Program {

	public static void main(String[] args) {
		
		int proximaPosicao = 0;
		int tamanho = -1;
		
		Evento []array = new Evento[100];
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
			if(tamanho == -1) {System.out.println("Crie um novo evento para continuar!");break;}
			
			System.out.println("Escolha qual evento deseja setar o valor do ingresso: ");
			
			
			for(int i = 0; i<=tamanho; i++) {
				
				System.out.println("Digite: "+ i + " para o evento: " + array[i].getNome());
				
			}
			

			int opcaoEvento = menu.nextInt();

			if(array[opcaoEvento] == null) { System.out.println("Selecione um evento válido ou crie um novo evento!");break;}
				System.out.println("Digite o valor do ingresso: ");
				float valor = menu.nextFloat();		
				array[opcaoEvento].setIngresso(new Ingresso(valor));		
				break;
			} catch (NullPointerException e) {

				System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");

			}
		case 2:
			try {	
			if(tamanho == -1) {System.out.println("Crie um novo evento para continuar!");break;}
			System.out.println("Escolha qual evento deseja setar o local: ");
			
			
				for(int i = 0; i<=tamanho; i++) {
				
				System.out.println("Digite: "+ i + " para setar o local do evento: " + array[i].getNome());
				
			}
			
			
			int opcaoLocal = menu.nextInt();
			if(array[opcaoLocal] == null) { System.out.println("Selecione um evento válido ou crie um novo evento!");break;}	
			
				menu.nextLine();
				Local local = new Local();
				System.out.println("Digite o endereço do local: ");
				String endereco = menu.nextLine();
				System.out.println("Digite o capacidade do local: ");
				int capacidade = menu.nextInt();
				local.setCapacidade(capacidade);
				local.setEndereco(endereco);
				
				array[opcaoLocal].setLocal(local);

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
			
	
			for(int i=0; i<array.length; i++) {
				if( i ==  proximaPosicao ) {
				array[i] =evento;
				
			}
			}
			
			proximaPosicao++;
			tamanho++;
			}catch(NullPointerException e) {

				System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");

			}
			break;
			
		
		case 4:
			
			
			try {
			if(tamanho == -1) {System.out.println("Crie um novo evento para continuar!");break;}
			System.out.println("Eventos disponíveis: ");
			System.out.println("Só aparecerão eventos cujos locais e ingressos estão definidos");
			
			for(int i = 0; i<=tamanho; i++) {
	
				if(array[i].getIngresso() == null && array[i].getLocal()==null) {
					continue;		
				}
				else if(array[i].getIngresso().getQuantidadeVendida() < array[i].getLocal().getCapacidade()) {
					System.out.println(array[i]);
				}else {
					System.out.println("Não há eventos disponíveis");	
				}
				
				}
			}catch(NullPointerException e) {

					System.out.println("Erro no processamento, verifique se todos os requisitos estão sendo satisfeitos!");

			}
			break;
			
		
		
		case 5:
			
			
			if(tamanho == -1) {System.out.println("Crie um novo evento para continuar!");break;}
			boolean validarErro = false;
			System.out.println("Eventos disponíveis para compra de ingressos: ");
			System.out.println("Só aparecerão eventos cujos locais e ingressos estiverem definidos");
			for(int i = 0; i<=tamanho; i++) {
				
				if(array[i].getIngresso() == null || array[i].getLocal()==null) {
					continue;
				}else if(array[i].getIngresso().getQuantidadeVendida() < array[i].getLocal().getCapacidade()) {
					System.out.println("Digite " + i + " para comprar um ingresso no evento: " + array[i]);
					validarErro = true;
					
				}
				}
	
			
				try {
					if(validarErro) {
				System.out.println("Digite uma opção: ");
				int option = menu.nextInt();
				
				int disponivel = array[option].getLocal().getCapacidade()-array[option].getIngresso().getQuantidadeVendida();
				array[option].getIngresso().setQuantidadeDisponivel(disponivel);
				System.out.println("Digite a quantidade de ingressos que deseja comprar: ");
				int quantidade = menu.nextInt();
				
				if(quantidade<= array[option].getIngresso().getQuantidadeDisponivel()) {
					array[option].getIngresso().setQuantidadeVendida(quantidade);
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
			if(tamanho == -1) {System.out.println("Crie um novo evento para continuar!");break;}
				float total = 0;

				for(int i = 0; i<=tamanho; i++) {
					if(array[i].getIngresso() == null && array[i].getLocal()==null) {
						continue;
			}
				total += (array[i].getIngresso().getValor() * array[i].getIngresso().getQuantidadeVendida());
			
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
	




	



