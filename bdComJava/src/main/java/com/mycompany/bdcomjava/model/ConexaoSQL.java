package com.mycompany.bdcomjava.model;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {
       
    private static final String url = "jdbc:mysql://localhost:3306/bancobiblioteca?useSSL=false";
    private static final String user = "root";
    private static final String password = "senha1234";
    
    private static Connection conexao = null;
    
    // Método para obter a conexão
    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(url, user, password);
                System.out.println("Conexao com o MySQL estabelecida com sucesso!");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver JDBC não encontrado: " + e.getMessage());
            }
        }
        return conexao;
    }
    
    // Método para fechar a conexão
    public static void fecharConexao() {
        if (conexao != null) {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexao com o MySQL fechada com sucesso!");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}