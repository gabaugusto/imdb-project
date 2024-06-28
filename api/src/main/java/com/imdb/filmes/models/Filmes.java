package com.imdb.filmes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // Diz ao SPRING que é uma entidade do banco de dados
public class Filmes {

    @Id // Diz ao SPRING que é uma chave primária
    @Column(name = "id_filme") // Dá nome a coluna
    public int idFilme;

    @Column(name = "titulo")
    public String titulo;

    @Column(name = "avaliacao")
    public double avaliacao;

    @Column(name = "ano")
    public int ano;

    @Column(name = "faixa_etaria")
    public String faixaEtaria;

    public String genero;

    public String diretor;

    public String elenco;

    @Column(name = "meta_score")
    public double metaScore;

    @Column(name = "poster_src")
    public String posterSrc;

    public double duracao;

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public double getMetaScore() {
        return metaScore;
    }

    public void setMetaScore(double metaScore) {
        this.metaScore = metaScore;
    }

    public String getPosterSrc() {
        return posterSrc;
    }

    public void setPosterSrc(String posterSrc) {
        this.posterSrc = posterSrc;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
}

