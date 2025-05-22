package br.fiap.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operacao extends _BaseEntity {

    private String nome;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    private List<Aviso> avisos = new ArrayList<>();
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Maquinista> maquinistas = new ArrayList<>();

    public Operacao() {
    }

    public Operacao(int id, boolean deleted) {
        super(id, deleted);
    }

    public Operacao(String nome, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, List<Aviso> avisos, List<Veiculo> veiculos, List<Maquinista> maquinistas) {
        this.nome = nome;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.avisos = avisos;
        this.veiculos = veiculos;
        this.maquinistas = maquinistas;
    }

    public Operacao(int id, boolean deleted, String nome, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, List<Aviso> avisos, List<Veiculo> veiculos, List<Maquinista> maquinistas) {
        super(id, deleted);
        this.nome = nome;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.avisos = avisos;
        this.veiculos = veiculos;
        this.maquinistas = maquinistas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public List<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Maquinista> getMaquinistas() {
        return maquinistas;
    }

    public void setMaquinistas(List<Maquinista> maquinistas) {
        this.maquinistas = maquinistas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Operacao operacao = (Operacao) o;
        return Objects.equals(nome, operacao.nome) && Objects.equals(dataHoraInicio, operacao.dataHoraInicio) && Objects.equals(dataHoraFim, operacao.dataHoraFim) && Objects.equals(avisos, operacao.avisos) && Objects.equals(veiculos, operacao.veiculos) && Objects.equals(maquinistas, operacao.maquinistas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome, dataHoraInicio, dataHoraFim, avisos, veiculos, maquinistas);
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "nome='" + nome + '\'' +
                ", dataHoraInicio=" + dataHoraInicio +
                ", dataHoraFim=" + dataHoraFim +
                ", avisos=" + avisos +
                ", veiculos=" + veiculos +
                ", maquinistas=" + maquinistas +
                '}';
    }
}