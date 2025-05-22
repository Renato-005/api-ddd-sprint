package br.fiap.resources;

import br.fiap.entities.Linha;
import br.fiap.repositories.LinhaRepositoryBD;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/linhas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LinhaResource {

    private static final int PAGE_SIZE = 2;

    private LinhaRepositoryBD linhaRepository = new LinhaRepositoryBD();

    @GET
    @Path("/status")
    public Response listarStatusLinha(@QueryParam("page") @DefaultValue("1") int page) {
        try {
            List<Linha> linhas = linhaRepository.getAll();

            if (linhas.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Nenhuma linha encontrada no banco.").build();
            }

            // Paginação
            int fromIndex = (page - 1) * PAGE_SIZE;
            int toIndex = Math.min(fromIndex + PAGE_SIZE, linhas.size());

            if (fromIndex >= linhas.size()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Página não encontrada.").build();
            }

            List<Linha> linhasPaginadas = linhas.subList(fromIndex, toIndex);

            // Extrair apenas os status das linhas
            List<String> statusLinhas = new ArrayList<>();
            for (Linha linha : linhasPaginadas) {
                if (linha.getStatusLinha() != null && !linha.getStatusLinha().isEmpty()) {
                    statusLinhas.add(linha.getStatusLinha());
                }
            }

            if (statusLinhas.isEmpty()) {
                return Response.status(Response.Status.NO_CONTENT)
                        .entity("As linhas foram encontradas, mas não possuem status registrado.").build();
            }

            return Response.ok(statusLinhas).build();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_IMPLEMENTED)
                    .entity("Erro interno ao processar a requisição, rota errada: " + e.getMessage()).build();
        }
    }
}



