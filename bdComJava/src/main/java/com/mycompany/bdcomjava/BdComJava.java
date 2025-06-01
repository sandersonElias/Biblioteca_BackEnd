package com.mycompany.bdcomjava;

import com.mycompany.bdcomjava.model.BibliotecaDAO;
import com.mycompany.bdcomjava.model.ConexaoSQL;
import com.mycompany.bdcomjava.model.Usuarios;
import java.sql.SQLException;
import java.util.Scanner;

public class BdComJava {

    public static void main(String... args) throws SQLException {

        // Criação do objeto Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Solicita os dados do usuário
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();

        System.out.println("Digite a senha do usuário:");
        String senha = scanner.nextLine();

        System.out.println("Digite a turma do usuário:");
        String turma = scanner.nextLine();

        System.out.println("Digite o ano do usuário:");
        int ano = scanner.nextInt();

        // Cria uma instância de Usuarios
        // O id é passado como 0 (ou qualquer valor, já que não é usado na query)
        // livroEmprestado é passado como null, já que não é usado na inserção
        Usuarios usuario = new Usuarios(0, nome, turma, ano, senha, null);

        // Cria uma instância de BibliotecaDAO
        BibliotecaDAO dao = new BibliotecaDAO();

        // Insere o usuário no banco
        try {
            dao.insertUsuario(usuario);
            System.out.println("Usuário inserido com sucesso!");
        } catch (RuntimeException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        }

        // Fecha o scanner e a conexão
        scanner.close();
        ConexaoSQL.fecharConexao();
    }
}