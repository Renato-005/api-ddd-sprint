package br.fiap.entities;

import java.util.Objects;

public class Maquinista extends _BaseEntity {

    private String nome;
    private String cpf;
    private String endereco;
    private String status; // Ex.: Ativo, Afastado, De férias

    public Maquinista() {
    }

    public Maquinista(int id, boolean deleted) {
        super(id, deleted);
    }

    public Maquinista(String nome, String cpf, String endereco, String status) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.status = status;
    }

    public Maquinista(int id, boolean deleted, String nome, String cpf, String endereco, String status) {
        super(id, deleted);
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Maquinista that = (Maquinista) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && Objects.equals(endereco, that.endereco) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome, cpf, endereco, status);
    }

    @Override
    public String toString() {
        return "Maquinista{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
