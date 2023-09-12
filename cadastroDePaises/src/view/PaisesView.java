package view;

import java.util.List;
import java.util.Scanner;

import model.Paises;

public class PaisesView {
	private Scanner scanner;

	public PaisesView() {
		scanner = new Scanner(System.in);
	}

	public void exibirPaises(List<Paises> paises) {
		System.out.println("------lista de paises------");
		System.out.println("");
		for (Paises pais : paises) {
			System.out.println("Pais: " + pais.getNome() + "\nCapital: " + pais.getCapital());
			System.out.println("---------------------------");
		}
	}

	public int menu() {
		System.out.println();
		System.out.println("--------menu-------");
		System.out.println("1-Adicionar Pais.");
		System.out.println("2-Listar Paises.");
		System.out.println("3-Remover Pais.");
		System.out.println("4-Limpar lista.");
		System.out.println("5-teste de conexao");
		System.out.println("0-Sair.");
		System.out.println();
		System.out.println("Digite sua escolha: ");
		return scanner.nextInt();
	}

	public void saida() {
		System.err.println("FIM");
				
	}

	public String getNome() {
		System.out.println("Digite o nome: ");
		return scanner.next();

	}

	public String getCapital() {
		System.out.println("Digite o Capital: ");
		return scanner.next();
	}

}
