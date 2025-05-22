package br.fiap.resources;

import br.fiap.entities.Usuario;
import br.fiap.repositories.UsuarioRepositoryBD;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private static final int PAGE_SIZE = 2;

    private UsuarioRepositoryBD usuarioRepository = new UsuarioRepositoryBD();

    @GET
    public Response listarUsuarios(@QueryParam("page") @DefaultValue("1") int page) {
        try {
            List<Usuario> usuarios = usuarioRepository.getAll();

            if (usuarios.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Nenhum usuário encontrado no banco.").build();
            }

            // Lógica de paginação
            int fromIndex = (page - 1) * PAGE_SIZE;
            int toIndex = Math.min(fromIndex + PAGE_SIZE, usuarios.size());

            if (fromIndex >= usuarios.size()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Página não encontrada.").build();
            }

            List<Usuario> usuariosPaginados = usuarios.subList(fromIndex, toIndex);

            return Response.ok(usuariosPaginados).build();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_IMPLEMENTED)
                    .entity("Erro interno ao processar a requisição,rota errada: " + e.getMessage()).build();
        }
    }
}
