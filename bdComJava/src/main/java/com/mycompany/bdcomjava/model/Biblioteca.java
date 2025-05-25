package com.mycompany.bdcomjava.model;

public class Biblioteca {

    //Atributos:
    private Livros livros;
    private Usuarios usuarios;
    
    //Construtor:
    public Biblioteca(Livros livros, Usuarios usuarios) {
        this.livros = livros;
        this.usuarios = usuarios;
    }

    public Livros getLivros() {
        return livros;
    }

    public void setLivros(Livros livros) {
        this.livros = livros;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
