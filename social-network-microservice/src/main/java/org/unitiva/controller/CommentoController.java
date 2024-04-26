package org.unitiva.controller;


import org.unitiva.bean.Commento;
import org.unitiva.dto.CommentoDTO;
import org.unitiva.service.CommentoService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/commento")
public class CommentoController{

    @Inject
    CommentoService commentoService;

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newCommento (CommentoDTO commentoDTO) {
        try{
            commentoService.newCommento(commentoDTO);
            String message = "{\"message\": "+"\"Create eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        } catch (Exception e){
            String message = "{\"errorCode\":1,\"message\": "+"\"Errore nell'operazione di creazione\"}";
            return Response.status(Response.Status.NOT_MODIFIED).entity(message).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateCommento (CommentoDTO commentoDTO) {
        try{
            commentoService.updateCommento(commentoDTO);
            String message = "{\"message\": "+"\"Update eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        } catch (Exception e){
            return Response.status(Response.Status.NOT_MODIFIED).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteCommento (@QueryParam("idCommento") Long idCommento, @QueryParam("idUtente") Long idUtente){
        try{
            commentoService.deleteById(idCommento, idUtente);
            String message = "{\"message\": "+"\"Delete eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();                
        } catch (Exception e){
            String message = "{\"errorCode\":3,\"message\": "+"\"Errore nell'operazione di Delete\"}";
            return Response.status(Response.Status.NOT_MODIFIED).entity(message).build();
        }

    }


    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findCommento (@QueryParam("id") Long id){
        try{
            Commento commento = commentoService.retrieveById(id);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(commento).build();
        } catch (Exception e){
            String message = "{\"errorCode\":5,\"message\": "+"\"Errore nell'operazione di Delete\"}";
            return Response.status(Response.Status.NOT_MODIFIED).entity(message).build();
        }
    }


}