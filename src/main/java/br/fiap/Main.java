package br.fiap;

import br.fiap.entities.Usuario;
import br.fiap.entities.Linha;
import br.fiap.entities.Estacao;

public class Main {

    public static void main(String[] args) {

        //Criando um objeto Usuario
        Usuario usuario = new Usuario(
                1,
                false,
                "senha123",
                "passageiro",
                "Jhon Torrez",
                "jhon.q.torrez@email.com"
        );

        //Criando um objeto Linha
        Linha linha = new Linha(
                10,
                false,
                "Linha Zafira",
                "Ativa",
                "Sentido Leste",
                "Sentido Centro",
                100
        );

        //Criando um objeto Estacao
        Estacao estacao = new Estacao(
                1,
                false,
                "Jardim Romano",
                "Av. Marechal Tito, 123",
                "Linha Zafira",
                10
        );

        // Exibindo os objetos criados no console
        System.out.println("======= USUARIO =======");
        System.out.println(usuario);

        System.out.println("\n======= LINHA =======");
        System.out.println(linha);

        System.out.println("\n======= ESTACAO =======");
        System.out.println(estacao);
    }
}
