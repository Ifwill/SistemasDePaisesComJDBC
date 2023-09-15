package Controller;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Paises;
import view.PaisesView;

public class PaisesController {
	private PaisesView paisesView;
	private PaisDAO paisDao;

	public PaisesController() {
		paisesView = new PaisesView();
		paisDao = new PaisDAO();
	}

	public void start() {
		int op = 0;
		do {
			switch (op = paisesView.menu()) {

			case 1:
				adicionarPaises();
				break;
			case 2:
				exibirLista();
				break;
			case 3:
				removerPaises();
				break;
			case 4:
				limparLista();
				break;
			case 5:
				testaConexao();
				break;
			case 6:
				exibirPrimeiroDaLista();
				break;
			case 7:
				exibirTerceiroDaLista();
				break;
			}

		} while (op != 0);
		paisesView.saida();
	}

	public void adicionarPaises() {
		String nome = paisesView.getNome();
		String capital = paisesView.getCapital();
		Paises pais = new Paises(nome,capital);
		paisDao.adicionarPais(pais);
	}

	public void removerPaises() {
		paisDao.removerPais(paisesView.getNome());
	}

	public void limparLista() {
		paisDao.limparLista();
	}

	public void exibirLista() {
		ArrayList<Paises> listaDePaises = paisDao.exibirLista();
		paisesView.exibirPaises(listaDePaises);
	}
	
	public void exibirPrimeiroDaLista() {
		ArrayList<Paises> listaDePaises = paisDao.exibirPrimeiroDaLista();
		paisesView.exibirPaises(listaDePaises);
	}
	
	public void exibirTerceiroDaLista() {
		ArrayList<Paises> listaDePaises = paisDao.exibirTerceiroDaLista();
		paisesView.exibirPaises(listaDePaises);
	}

	public int menu() {
		return paisesView.menu();
	}
	
	public void testaConexao() {
		paisDao.testaConexao();
	}

}
