package br.fiap.repositories;

import br.fiap.entities.Veiculo;
import br.fiap.infrastructure.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepositoryBD {

    private Connection connection;

    public VeiculoRepositoryBD() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Veiculo veiculo) {
        String sql = "INSERT INTO T_SVIA_VEICULO (id_veiculo, numero_vagoes, hr_operacao, tp_veiculo, T_SVIA_CAPACIDADE_id_capacidade, T_SVIA_LINHA_id_linha, deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, veiculo.getId());
            ps.setInt(2, veiculo.getNumeroVagoes());
            ps.setTimestamp(3, Timestamp.valueOf(veiculo.getHorarioOperacao()));
            ps.setString(4, veiculo.getTipoVeiculo());
            ps.setInt(5, veiculo.getIdCapacidade());
            ps.setInt(6, veiculo.getIdLinha());
            ps.setBoolean(7, veiculo.isDeleted());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM T_SVIA_VEICULO WHERE id_veiculo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Veiculo veiculo) {
        String sql = "UPDATE T_SVIA_VEICULO SET numero_vagoes = ?, hr_operacao = ?, tp_veiculo = ?, T_SVIA_CAPACIDADE_id_capacidade = ?, T_SVIA_LINHA_id_linha = ?, deleted = ? WHERE id_veiculo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, veiculo.getNumeroVagoes());
            ps.setTimestamp(2, Timestamp.valueOf(veiculo.getHorarioOperacao()));
            ps.setString(3, veiculo.getTipoVeiculo());
            ps.setInt(4, veiculo.getIdCapacidade());
            ps.setInt(5, veiculo.getIdLinha());
            ps.setBoolean(6, veiculo.isDeleted());
            ps.setInt(7, veiculo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Veiculo> getAll() {
        String sql = "SELECT * FROM T_SVIA_VEICULO";
        List<Veiculo> veiculos = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getInt("id_veiculo"),
                        rs.getBoolean("deleted"),
                        rs.getInt("numero_vagoes"),
                        rs.getTimestamp("hr_operacao").toLocalDateTime(),
                        rs.getString("tp_veiculo"),
                        rs.getInt("T_SVIA_CAPACIDADE_id_capacidade"),
                        rs.getInt("T_SVIA_LINHA_id_linha")
                );
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculos;
    }

    public Optional<Veiculo> getById(int id) {
        String sql = "SELECT * FROM T_SVIA_VEICULO WHERE id_veiculo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getInt("id_veiculo"),
                        rs.getBoolean("deleted"),
                        rs.getInt("numero_vagoes"),
                        rs.getTimestamp("hr_operacao").toLocalDateTime(),
                        rs.getString("tp_veiculo"),
                        rs.getInt("T_SVIA_CAPACIDADE_id_capacidade"),
                        rs.getInt("T_SVIA_LINHA_id_linha")
                );
                return Optional.of(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
