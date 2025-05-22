package br.fiap.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Veiculo extends _BaseEntity{

    private int numeroVagoes;
    private LocalDateTime horarioOperacao;
    private String tipoVeiculo;
    private int idCapacidade;
    private int idLinha;

    public Veiculo() {
    }

    public Veiculo(int id, boolean deleted) {
        super(id, deleted);
    }

    public Veiculo(int numeroVagoes, LocalDateTime horarioOperacao, String tipoVeiculo, int idCapacidade, int idLinha) {
        this.numeroVagoes = numeroVagoes;
        this.horarioOperacao = horarioOperacao;
        this.tipoVeiculo = tipoVeiculo;
        this.idCapacidade = idCapacidade;
        this.idLinha = idLinha;
    }

    public Veiculo(int id, boolean deleted, int numeroVagoes, LocalDateTime horarioOperacao, String tipoVeiculo, int idCapacidade, int idLinha) {
        super(id, deleted);
        this.numeroVagoes = numeroVagoes;
        this.horarioOperacao = horarioOperacao;
        this.tipoVeiculo = tipoVeiculo;
        this.idCapacidade = idCapacidade;
        this.idLinha = idLinha;
    }

    public int getNumeroVagoes() {
        return numeroVagoes;
    }

    public void setNumeroVagoes(int numeroVagoes) {
        this.numeroVagoes = numeroVagoes;
    }

    public LocalDateTime getHorarioOperacao() {
        return horarioOperacao;
    }

    public void setHorarioOperacao(LocalDateTime horarioOperacao) {
        this.horarioOperacao = horarioOperacao;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getIdCapacidade() {
        return idCapacidade;
    }

    public void setIdCapacidade(int idCapacidade) {
        this.idCapacidade = idCapacidade;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Veiculo veiculo = (Veiculo) o;
        return numeroVagoes == veiculo.numeroVagoes && idCapacidade == veiculo.idCapacidade && idLinha == veiculo.idLinha && Objects.equals(horarioOperacao, veiculo.horarioOperacao) && Objects.equals(tipoVeiculo, veiculo.tipoVeiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroVagoes, horarioOperacao, tipoVeiculo, idCapacidade, idLinha);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "numeroVagoes=" + numeroVagoes +
                ", horarioOperacao=" + horarioOperacao +
                ", tipoVeiculo='" + tipoVeiculo + '\'' +
                ", idCapacidade=" + idCapacidade +
                ", idLinha=" + idLinha +
                '}';
    }
}
