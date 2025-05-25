package com.mycompany.bdcomjava;

import com.mycompany.bdcomjava.model.BibliotecaDAO;
import com.mycompany.bdcomjava.model.Livros;
import java.sql.SQLException;

public class BdComJava {

    public static void main(String... args) throws SQLException {
        BibliotecaDAO dao = new BibliotecaDAO();

            Livros livro = new Livros();
            livro.setIsbn(9781234567897L);
            livro.setNome("Dom Casmurro");
            livro.setAutor("Machado de Assis");
            livro.setQuantidade(5);
            livro.setCategoria("Romance");
            dao.inserirLivro(livro);
    }
}

