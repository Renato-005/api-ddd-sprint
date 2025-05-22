package br.fiap.repositories;

import br.fiap.entities.Estacao;
import br.fiap.infrastructure.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstacaoRepositoryBD {

    private Connection connection;

    public EstacaoRepositoryBD() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    public void add(Estacao estacao) {
        String sql = "INSERT INTO T_SVIA_ESTACAO (id_estacao, nm_estacao, localizacao, ln_estacao, T_SVIA_LINHA_id_linha, deleted) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, estacao.getId());
            ps.setString(2, estacao.getNome());
            ps.setString(3, estacao.getLocalizacao());
            ps.setString(4, estacao.getLinhaEstacao());
            ps.setInt(5, estacao.getLinhaId());
            ps.setBoolean(6, estacao.isDeleted());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM T_SVIA_ESTACAO WHERE id_estacao = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Estacao estacao) {
        String sql = "UPDATE T_SVIA_ESTACAO SET nm_estacao = ?, localizacao = ?, ln_estacao = ?, T_SVIA_LINHA_id_linha = ?, deleted = ? WHERE id_estacao = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, estacao.getNome());
            ps.setString(2, estacao.getLocalizacao());
            ps.setString(3, estacao.getLinhaEstacao());
            ps.setInt(4, estacao.getLinhaId());
            ps.setBoolean(5, estacao.isDeleted());
            ps.setInt(6, estacao.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Estacao> getAll() {
        String sql = "SELECT * FROM T_SVIA_ESTACAO";
        List<Estacao> estacoes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Estacao estacao = new Estacao(
                        rs.getInt("id_estacao"),
                        rs.getBoolean("deleted"),
                        rs.getString("nm_estacao"),
                        rs.getString("localizacao"),
                        rs.getString("ln_estacao"),
                        rs.getInt("T_SVIA_LINHA_id_linha")
                );
                estacoes.add(estacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estacoes;
    }

    public Optional<Estacao> getById(int id) {
        String sql = "SELECT * FROM T_SVIA_ESTACAO WHERE id_estacao = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Estacao estacao = new Estacao(
                        rs.getInt("id_estacao"),
                        rs.getBoolean("deleted"),
                        rs.getString("nm_estacao"),
                        rs.getString("localizacao"),
                        rs.getString("ln_estacao"),
                        rs.getInt("T_SVIA_LINHA_id_linha")
                );
                return Optional.of(estacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}




