package entities;

import java.time.LocalDate;

import entites.enums.StatusLivro;

public class Livro {
    private Integer id;
    private String titulo;
    private String autor;
    private Integer ano;
    private StatusLivro status;
    private LocalDate dataEmprestimo;

    public Livro(Integer id, String titulo, String autor,Integer ano, LocalDate dataEmprestimo){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.status = StatusLivro.DISPONIVEL;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Integer getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }


    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "entities.Livro{" +
                "ano=" + ano +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", status=" + status +
                ", dataEmprestimo=" + dataEmprestimo +
                '}';
    }
}
