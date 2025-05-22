package br.fiap.repositories;

import br.fiap.entities.Vagao;
import br.fiap.infrastructure.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VagaoRepositoryBD {

    private Connection connection;

    public VagaoRepositoryBD() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Vagao vagao) {
        String sql = "INSERT INTO T_SVIA_VAGAO (id_vagao, identificacao, lotacao, T_SVIA_VEICULO_id_veiculo, deleted) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, vagao.getId());
            ps.setString(2, vagao.getIdentificacao());
            ps.setInt(3, vagao.getLotacao());
            ps.setInt(4, vagao.getIdVeiculo());
            ps.setBoolean(5, vagao.isDeleted());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM T_SVIA_VAGAO WHERE id_vagao = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Vagao vagao) {
        String sql = "UPDATE T_SVIA_VAGAO SET identificacao = ?, lotacao = ?, T_SVIA_VEICULO_id_veiculo = ?, deleted = ? WHERE id_vagao = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, vagao.getIdentificacao());
            ps.setInt(2, vagao.getLotacao());
            ps.setInt(3, vagao.getIdVeiculo());
            ps.setBoolean(4, vagao.isDeleted());
            ps.setInt(5, vagao.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Vagao> getAll() {
        String sql = "SELECT * FROM T_SVIA_VAGAO";
        List<Vagao> vagoes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vagao vagao = new Vagao(
                        rs.getInt("id_vagao"),
                        rs.getBoolean("deleted"),
                        rs.getString("identificacao"),
                        rs.getInt("lotacao"),
                        rs.getInt("T_SVIA_VEICULO_id_veiculo")
                );
                vagoes.add(vagao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vagoes;
    }

    public Optional<Vagao> getById(int id) {
        String sql = "SELECT * FROM T_SVIA_VAGAO WHERE id_vagao = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vagao vagao = new Vagao(
                        rs.getInt("id_vagao"),
                        rs.getBoolean("deleted"),
                        rs.getString("identificacao"),
                        rs.getInt("lotacao"),
                        rs.getInt("T_SVIA_VEICULO_id_veiculo")
                );
                return Optional.of(vagao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}



