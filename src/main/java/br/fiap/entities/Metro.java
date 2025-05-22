package br.fiap.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Metro extends Veiculo{

    private int numeroVagoes;
    private List<Vagao> vagoes = new ArrayList<>();

    public Metro() {
    }

    public Metro(int id, boolean deleted) {
        super(id, deleted);
    }

    public Metro(int numeroVagoes, LocalDateTime horarioOperacao, String tipoVeiculo, int idCapacidade, int idLinha) {
        super(numeroVagoes, horarioOperacao, tipoVeiculo, idCapacidade, idLinha);
    }

    public Metro(int id, boolean deleted, int numeroVagoes, LocalDateTime horarioOperacao, String tipoVeiculo, int idCapacidade, int idLinha) {
        super(id, deleted, numeroVagoes, horarioOperacao, tipoVeiculo, idCapacidade, idLinha);
    }

    public Metro(int numeroVagoes, List<Vagao> vagoes) {
        this.numeroVagoes = numeroVagoes;
        this.vagoes = vagoes;
    }

    public Metro(int id, boolean deleted, int numeroVagoes, List<Vagao> vagoes) {
        super(id, deleted);
        this.numeroVagoes = numeroVagoes;
        this.vagoes = vagoes;
    }

    public Metro(int numeroVagoes, LocalDateTime horarioOperacao, String tipoVeiculo, int idCapacidade, int idLinha, int numeroVagoes1, List<Vagao> vagoes) {
        super(numeroVagoes, horarioOperacao, tipoVeiculo, idCapacidade, idLinha);
        this.numeroVagoes = numeroVagoes1;
        this.vagoes = vagoes;
    }

    public Metro(int id, boolean deleted, int numeroVagoes, LocalDateTime horarioOperacao, String tipoVeiculo, int idCapacidade, int idLinha, int numeroVagoes1, List<Vagao> vagoes) {
        super(id, deleted, numeroVagoes, horarioOperacao, tipoVeiculo, idCapacidade, idLinha);
        this.numeroVagoes = numeroVagoes1;
        this.vagoes = vagoes;
    }

    @Override
    public int getNumeroVagoes() {
        return numeroVagoes;
    }

    @Override
    public void setNumeroVagoes(int numeroVagoes) {
        this.numeroVagoes = numeroVagoes;
    }

    public List<Vagao> getVagoes() {
        return vagoes;
    }

    public void setVagoes(List<Vagao> vagoes) {
        this.vagoes = vagoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Metro metro = (Metro) o;
        return numeroVagoes == metro.numeroVagoes && Objects.equals(vagoes, metro.vagoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroVagoes, vagoes);
    }

    @Override
    public String toString() {
        return "Metro{" +
                "numeroVagoes=" + numeroVagoes +
                ", vagoes=" + vagoes +
                '}';
    }
}
