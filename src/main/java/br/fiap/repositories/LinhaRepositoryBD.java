package br.fiap.repositories;

import br.fiap.entities.Linha;
import br.fiap.infrastructure.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LinhaRepositoryBD {

    private Connection connection;

    public LinhaRepositoryBD() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Linha linha) {
        String sql = "INSERT INTO T_SVIA_LINHA (id_linha, nm_linha, st_linha, sentido_um, sentido_dois, numero, deleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, linha.getId());
            ps.setString(2, linha.getNome());
            ps.setString(3, linha.getStatusLinha());
            ps.setString(4, linha.getSentidoIda());
            ps.setString(5, linha.getSentidoVolta());
            ps.setInt(6, linha.getNumero());
            ps.setBoolean(7, linha.isDeleted());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM T_SVIA_LINHA WHERE id_linha = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Linha linha) {
        String sql = "UPDATE T_SVIA_LINHA SET nm_linha = ?, st_linha = ?, sentido_um = ?, sentido_dois = ?, numero = ?, deleted = ? WHERE id_linha = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, linha.getNome());
            ps.setString(2, linha.getStatusLinha());
            ps.setString(3, linha.getSentidoIda());
            ps.setString(4, linha.getSentidoVolta());
            ps.setInt(5, linha.getNumero());
            ps.setBoolean(6, linha.isDeleted());
            ps.setInt(7, linha.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Linha> getAll() {
        String sql = "SELECT * FROM T_SVIA_LINHA";
        List<Linha> linhas = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Linha linha = new Linha(
                        rs.getInt("id_linha"),
                        rs.getBoolean("deleted"),
                        rs.getString("nm_linha"),
                        rs.getString("st_linha"),
                        rs.getString("sentido_um"),
                        rs.getString("sentido_dois"),
                        rs.getInt("numero")
                );
                linhas.add(linha);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return linhas;
    }

    public Optional<Linha> getById(int id) {
        String sql = "SELECT * FROM T_SVIA_LINHA WHERE id_linha = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Linha linha = new Linha(
                        rs.getInt("id_linha"),
                        rs.getBoolean("deleted"),
                        rs.getString("nm_linha"),
                        rs.getString("st_linha"),
                        rs.getString("sentido_um"),
                        rs.getString("sentido_dois"),
                        rs.getInt("numero")
                );
                return Optional.of(linha);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
