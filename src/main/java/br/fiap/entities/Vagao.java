package br.fiap.entities;


import java.util.Objects;

public class Vagao extends _BaseEntity{

    private String identificacao;
    private int lotacao;
    private int idVeiculo;

    public Vagao() {
    }

    public Vagao(int id, boolean deleted) {
        super(id, deleted);
    }

    public Vagao(String identificacao, int lotacao, int idVeiculo) {
        this.identificacao = identificacao;
        this.lotacao = lotacao;
        this.idVeiculo = idVeiculo;
    }

    public Vagao(int id, boolean deleted, String identificacao, int lotacao, int idVeiculo) {
        super(id, deleted);
        this.identificacao = identificacao;
        this.lotacao = lotacao;
        this.idVeiculo = idVeiculo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vagao vagao = (Vagao) o;
        return lotacao == vagao.lotacao && idVeiculo == vagao.idVeiculo && Objects.equals(identificacao, vagao.identificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identificacao, lotacao, idVeiculo);
    }

    @Override
    public String toString() {
        return "Vagao{" +
                "identificacao='" + identificacao + '\'' +
                ", lotacao=" + lotacao +
                ", idVeiculo=" + idVeiculo +
                '}';
    }
}
