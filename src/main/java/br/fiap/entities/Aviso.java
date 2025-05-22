package br.fiap.entities;

import java.util.Objects;

public class Aviso extends _BaseEntity {

    private String descricao;
    private String tipo;

    public Aviso() {
    }

    public Aviso(int id, boolean deleted) {
        super(id, deleted);
    }

    public Aviso(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Aviso(int id, boolean deleted, String descricao, String tipo) {
        super(id, deleted);
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aviso aviso = (Aviso) o;
        return Objects.equals(descricao, aviso.descricao) && Objects.equals(tipo, aviso.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descricao, tipo);
    }

    @Override
    public String toString() {
        return "Aviso{" +
                "descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
