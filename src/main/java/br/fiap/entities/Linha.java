package br.fiap.entities;

import java.util.Objects;

public class Linha extends _BaseEntity {

    private String nome;
    private String statusLinha;
    private String sentidoIda;
    private String sentidoVolta;
    private int numero;

    public Linha() {
    }

    public Linha(int id, boolean deleted) {
        super(id, deleted);
    }

    public Linha(String nome, String statusLinha, String sentidoIda, String sentidoVolta, int numero) {
        this.nome = nome;
        this.statusLinha = statusLinha;
        this.sentidoIda = sentidoIda;
        this.sentidoVolta = sentidoVolta;
        this.numero = numero;
    }

    public Linha(int id, boolean deleted, String nome, String statusLinha, String sentidoIda, String sentidoVolta, int numero) {
        super(id, deleted);
        this.nome = nome;
        this.statusLinha = statusLinha;
        this.sentidoIda = sentidoIda;
        this.sentidoVolta = sentidoVolta;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatusLinha() {
        return statusLinha;
    }

    public void setStatusLinha(String statusLinha) {
        this.statusLinha = statusLinha;
    }

    public String getSentidoIda() {
        return sentidoIda;
    }

    public void setSentidoIda(String sentidoIda) {
        this.sentidoIda = sentidoIda;
    }

    public String getSentidoVolta() {
        return sentidoVolta;
    }

    public void setSentidoVolta(String sentidoVolta) {
        this.sentidoVolta = sentidoVolta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Linha linha = (Linha) o;
        return numero == linha.numero && Objects.equals(nome, linha.nome) && Objects.equals(statusLinha, linha.statusLinha) && Objects.equals(sentidoIda, linha.sentidoIda) && Objects.equals(sentidoVolta, linha.sentidoVolta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome, statusLinha, sentidoIda, sentidoVolta, numero);
    }

    @Override
    public String toString() {
        return "Linha{" +
                "nome='" + nome + '\'' +
                ", statusLinha='" + statusLinha + '\'' +
                ", sentidoIda='" + sentidoIda + '\'' +
                ", sentidoVolta='" + sentidoVolta + '\'' +
                ", numero=" + numero +
                '}';
    }
}