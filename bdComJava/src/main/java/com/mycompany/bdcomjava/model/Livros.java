package com.mycompany.bdcomjava.model;

public class Livros {
 
    //atributos:
    private String nome;
    private Long isbn;
    private String autor;
    private Integer quantidade;
    private String categoria;

    //Construtor:

    public Livros(String nome, Long isbn, String autor, Integer quantidade, String categoria) {
        this.nome = nome;
        this.isbn = isbn;
        this.autor = autor;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    

}
