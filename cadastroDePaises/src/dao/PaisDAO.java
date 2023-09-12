package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Paises;

public class PaisDAO {
	private String url = "jdbc:mysql://localhost:3306/MeuBanquinho";
	private String usuario = "root";
	private String senha = "aluno";
	private Connection connection;

	private ArrayList<Paises> listaDePaises;

	public PaisDAO() {
		listaDePaises = new ArrayList<Paises>();
	}

	public void adicionarPais(String nome, String capital) {
		Paises pais = new Paises(nome, capital);
		listaDePaises.add(pais);
	}

	/*
	 * metodo para remover um pais da lista, com o for para percorer a lista. o
	 * comando equalsIgnoreCase serve para ignorar se o usuario escrevel em
	 * maiusculo ou minusculo na hora da verificação.
	 */
	public boolean removerPais(String nome) {
		for (Paises i : this.listaDePaises) {
			if (i.getNome().equalsIgnoreCase(nome)) {
				listaDePaises.remove(i);
				return true;
			}
		}
		return false;
	}

	public void limparLista() {
		listaDePaises.clear();
	}

	public ArrayList<Paises> exibirLista() {
		ArrayList<Paises> lista = new ArrayList<>();

		if (abreConexao()) {
			try {
				String sql = "SELECT * FROM pais;";
				PreparedStatement ps = connection.prepareStatement(sql);

				ResultSet resultSet = ps.executeQuery();

				while (resultSet.next()) {
					String nome = resultSet.getString("nome");
					String capital = resultSet.getString("capital");
					Paises pais = new Paises(nome, capital);
					lista.add(pais);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public void testaConexao() {
		boolean conectou = abreConexao();
		if (conectou) {
			System.out.println("Banco conectado!!");

		} else {
			System.err.println("Banco nao conectado!!");
		}
		fechaConexao();
	}

	public boolean abreConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, usuario, senha);

			if (connection != null) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void fechaConexao() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
