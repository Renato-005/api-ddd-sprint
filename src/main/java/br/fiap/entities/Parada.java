package br.fiap.entities;

import java.util.Objects;

public class Parada extends _BaseEntity {

    private String nome;
    private int numeroDeParadas;

    public Parada() {
    }

    public Parada(int id, boolean deleted) {
        super(id, deleted);
    }

    public Parada(String nome, int numeroDeParadas) {
        this.nome = nome;
        this.numeroDeParadas = numeroDeParadas;
    }

    public Parada(int id, boolean deleted, String nome, int numeroDeParadas) {
        super(id, deleted);
        this.nome = nome;
        this.numeroDeParadas = numeroDeParadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Parada parada = (Parada) o;
        return numeroDeParadas == parada.numeroDeParadas && Objects.equals(nome, parada.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome, numeroDeParadas);
    }

    @Override
    public String toString() {
        return "Parada{" +
                "nome='" + nome + '\'' +
                ", numeroDeParadas=" + numeroDeParadas +
                '}';
    }
}