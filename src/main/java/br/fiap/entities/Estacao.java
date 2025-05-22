package br.fiap.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estacao extends _BaseEntity {

    private String nome;
    private String localizacao;
    private String linhaEstacao;
    private int linhaId;

    public Estacao() {
    }

    public Estacao(int id, boolean deleted) {
        super(id, deleted);
    }

    public Estacao(String nome, String localizacao, String linhaEstacao, int linhaId) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.linhaEstacao = linhaEstacao;
        this.linhaId = linhaId;
    }

    public Estacao(int id, boolean deleted, String nome, String localizacao, String linhaEstacao, int linhaId) {
        super(id, deleted);
        this.nome = nome;
        this.localizacao = localizacao;
        this.linhaEstacao = linhaEstacao;
        this.linhaId = linhaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLinhaEstacao() {
        return linhaEstacao;
    }

    public void setLinhaEstacao(String linhaEstacao) {
        this.linhaEstacao = linhaEstacao;
    }

    public int getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(int linhaId) {
        this.linhaId = linhaId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estacao estacao = (Estacao) o;
        return linhaId == estacao.linhaId && Objects.equals(nome, estacao.nome) && Objects.equals(localizacao, estacao.localizacao) && Objects.equals(linhaEstacao, estacao.linhaEstacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome, localizacao, linhaEstacao, linhaId);
    }

    @Override
    public String toString() {
        return "Estacao{" +
                "nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", linhaEstacao='" + linhaEstacao + '\'' +
                ", linhaId=" + linhaId +
                '}';
    }
}
