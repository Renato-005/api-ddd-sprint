package br.fiap.repositories;

import br.fiap.entities.Usuario;
import br.fiap.infrastructure.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryBD
        implements _CrudRepository<Usuario> {

    @Override
    public void add(Usuario usuario) {
        String sql = "INSERT INTO T_SVIA_USUARIO (id_usuario, nm_usuario, email, senha, nivel_permissao, deleted) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getNivelPermissao());
            ps.setBoolean(6, usuario.isDeleted());

            ps.executeUpdate();
            System.out.println("Usuario inserido com sucesso no banco!");

        } catch (SQLException e) {
            System.out.println(" Erro ao inserir usuário: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM T_SVIA_USUARIO";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getBoolean("deleted"),
                        rs.getString("senha"),
                        rs.getString("nivel_permissao"),
                        rs.getString("nm_usuario"),
                        rs.getString("email")
                );
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários: " + e.getMessage());
        }

        return usuarios;
    }

    @Override
    public Optional<Usuario> getById(int id) {
        String sql = "SELECT * FROM T_SVIA_USUARIO WHERE id_usuario = ?";
        Usuario usuario = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getBoolean("deleted"),
                        rs.getString("senha"),
                        rs.getString("nivel_permissao"),
                        rs.getString("nm_usuario"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
        }

        return Optional.ofNullable(usuario);
    }

    @Override
    public boolean removeById(int id) {
        String sql = "DELETE FROM T_SVIA_USUARIO WHERE id_usuario = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println(" Erro ao remover usuário: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(Usuario usuario) {
        return removeById(usuario.getId());
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "UPDATE T_SVIA_USUARIO SET deleted = 1 WHERE id_usuario = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro na remoção lógica do usuário: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Usuario usuario) {
        return deleteById(usuario.getId());
    }

    @Override
    public List<Usuario> get() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM T_SVIA_USUARIO WHERE deleted = 0";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getBoolean("deleted"),
                        rs.getString("senha"),
                        rs.getString("nivel_permissao"),
                        rs.getString("nm_usuario"),
                        rs.getString("email")
                );
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários não deletados: " + e.getMessage());
        }

        return usuarios;
    }

    @Override
    public void update(Usuario usuario) {
        String sql = "UPDATE T_SVIA_USUARIO SET nm_usuario = ?, email = ?, senha = ?, nivel_permissao = ?, deleted = ? WHERE id_usuario = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getNivelPermissao());
            ps.setBoolean(5, usuario.isDeleted());
            ps.setInt(6, usuario.getId());

            ps.executeUpdate();
            System.out.println("Usuario atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }
}
