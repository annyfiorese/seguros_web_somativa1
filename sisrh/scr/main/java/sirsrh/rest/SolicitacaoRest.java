package sisrh.rest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import io.swagger.annotations.Api;
import sisrh.banco.Banco;
import sisrh.dto.Solicitacao;

@Api
@Path("/solicitacao")
public class SolicitacaoRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSolicitacoes() throws Exception {
        List<Solicitacao> lista = Banco.listarSolicitacoes();
        GenericEntity<List<Solicitacao>> entity = new GenericEntity<List<Solicitacao>>(lista) {};
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterSolicitacao(@PathParam("id") int id) throws Exception {
        Solicitacao solicitacao = Banco.buscarSolicitacaoPorId(id);
        if (solicitacao != null) {
            return Response.ok().entity(solicitacao).build();
        } else {
            return Response.status(Status.NOT_FOUND)
                    .entity("{ \"mensagem\" : \"Solicitacao nao encontrada!\" }").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirSolicitacao(Solicitacao s) {
        try {
            Solicitacao nova = Banco.incluirSolicitacao(s);
            return Response.ok().entity(nova).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na inclusao da solicitacao!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarSolicitacao(@PathParam("id") int id, Solicitacao s) {
        try {
            if (Banco.buscarSolicitacaoPorId(id) == null) {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitacao nao encontrada!\" }").build();
            }
            Solicitacao alterada = Banco.alterarSolicitacao(id, s);
            return Response.ok().entity(alterada).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na alteracao da solicitacao!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirSolicitacao(@PathParam("id") int id) {
        try {
            if (Banco.buscarSolicitacaoPorId(id) == null) {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitacao nao encontrada!\" }").build();
            }
            Banco.excluirSolicitacao(id);
            return Response.ok().entity("{ \"mensagem\" : \"Solicitacao " + id + " excluída!\" }").build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na exclusao da solicitacao!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }
}