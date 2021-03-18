package br.edu.cesmac.si.filmes.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "genero")
    private List<Filme> filmes;

    public Genero(){

    }

    public Genero(Long idGenero, String nome, String descricao ){
        this.idGenero = idGenero;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        idGenero = idGenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

