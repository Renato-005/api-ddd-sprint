package br.fiap.resources;

import br.fiap.entities.Estacao;
import br.fiap.repositories.EstacaoRepositoryBD;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/estacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstacaoResource {

    private static final int PAGE_SIZE = 2;

    private EstacaoRepositoryBD estacaoRepository = new EstacaoRepositoryBD();

    @GET
    @Path("/info")
    public Response listarEstacoes(@QueryParam("page") @DefaultValue("1") int page) {
        try {
            List<Estacao> estacoes = estacaoRepository.getAll();

            if (estacoes.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Nenhuma estação encontrada no banco.").build();
            }

            // Paginação
            int fromIndex = (page - 1) * PAGE_SIZE;
            int toIndex = Math.min(fromIndex + PAGE_SIZE, estacoes.size());

            if (fromIndex >= estacoes.size()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Página não encontrada.").build();
            }

            List<Estacao> estacoesPaginadas = estacoes.subList(fromIndex, toIndex);

            // Extrair nome e linhaId
            List<Map<String, Object>> infoEstacoes = new ArrayList<>();
            for (Estacao estacao : estacoesPaginadas) {
                if (estacao.getNome() != null && !estacao.getNome().isEmpty()) {
                    Map<String, Object> info = new HashMap<>();
                    info.put("nome", estacao.getNome());
                    info.put("linhaId", estacao.getLinhaId());
                    infoEstacoes.add(info);
                }
            }

            if (infoEstacoes.isEmpty()) {
                return Response.status(Response.Status.NO_CONTENT)
                        .entity("Estações encontradas, mas sem nome ou linhaId registrados.").build();
            }

            return Response.ok(infoEstacoes).build();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_IMPLEMENTED)
                    .entity("Erro interno ao processar a requisição, rota errada: " + e.getMessage()).build();
        }
    }
}



