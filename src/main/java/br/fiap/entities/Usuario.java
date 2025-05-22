package br.fiap.entities;

import java.util.Objects;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Usuario extends _BaseEntity {

    private String senha;
    private String nivelPermissao;
    private String nome;
    private String email;

    public Usuario() {
    }
    public Usuario(int id, boolean deleted) {
        super(id, deleted);
    }

    public Usuario(String senha, String nivelPermissao, String nome, String email) {
        this.senha = senha;
        this.nivelPermissao = nivelPermissao;
        this.nome = nome;
        this.email = email;
    }

    public Usuario(int id, boolean deleted, String senha, String nivelPermissao, String nome, String email) {
        super(id, deleted);
        this.senha = senha;
        this.nivelPermissao = nivelPermissao;
        this.nome = nome;
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(String nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(senha, usuario.senha) && Objects.equals(nivelPermissao, usuario.nivelPermissao) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), senha, nivelPermissao, nome, email);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "senha='" + senha + '\'' +
                ", nivelPermissao='" + nivelPermissao + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    // Validação básica de email
//    public void setEmail(String email) {
//        if (email == null || !email.contains("@")) {
//            throw new IllegalArgumentException("Email inválido.");
//        }
//        this.email = email;
//    }
}
