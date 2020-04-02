package com.repeteco.teste.Model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anuncio")
public class Anuncio {

    @Id
    @GeneratedValue
    private int idAnuncio;
    private String titulo;
    private String descricao;
    private Date dtInicial;
    private Date dtFinal;
    private String valor;
    private String tamanho;
    private String conservacao;
    private byte[] imagem1;
    private String type;

    private static final int PRAZOEXPIRACAO = 30;

    @Column(name = "id_client")
    private int idClient;


    @Column(name = "id_escola")
    private int idEscola;


    public Anuncio() {}

    public Anuncio(int idClient, int idEscola, String titulo, String descricao, String valor, String tamanho, String conservacao, byte[] imagem1, String type) {
        this.idClient = idClient;
        this.idEscola = idEscola;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dtInicial = Calendar.getInstance().getTime();
        this.dtFinal = Calendar.getInstance().getTime();
        this.valor = valor;
        this.tamanho = tamanho;
        this.conservacao = conservacao;
        this.imagem1 = imagem1;
        this.type = type;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtInicial() {
        return dtInicial;
    }

    public void setDtInicial(Date dtInicial) {
        this.dtInicial = dtInicial;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImagem1() {
        return imagem1;
    }

    public void setImagem1(byte[] imagem1) {
        this.imagem1 = imagem1;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "idAnuncio=" + idAnuncio +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dtInicial=" + dtInicial +
                ", dtFinal=" + dtFinal +
                ", valor='" + valor + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", conservacao='" + conservacao + '\'' +
                ", imagem1=" + Arrays.toString(imagem1) +
                ", type='" + type + '\'' +
                ", idClient=" + idClient +
                ", idEscola=" + idEscola +
                '}';
    }
}
