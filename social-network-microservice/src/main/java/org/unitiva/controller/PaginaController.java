package org.unitiva.controller;

import org.unitiva.dto.PaginaDTO;

import org.unitiva.bean.Pagina;
import org.unitiva.bean.Post;
import org.unitiva.service.PaginaService;
import org.unitiva.service.PostService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pagina")
public class PaginaController {

   
    PaginaService paginaService = new PaginaService();

    PostService postService = new PostService();

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newPost (PaginaDTO paginaDTO){
        try{
            paginaService.save(paginaDTO);;
            String message = "{\"message\": "+"\"Create eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        } catch (Exception e){
            String message = "{\"errorCode\":1,\"message\": "+"\"Errore nell'operazione di creazione\"}";
            return Response.status(Response.Status.NOT_MODIFIED).entity(message).build();
        }
    }

    @POST
    @Path("/addpost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response postPagina (@QueryParam("idpagina") Long idpagina,@QueryParam("idpost") Long idpost){
        try{
            Pagina pagina = paginaService.findById(idpagina);
            Post post = postService.retrieveById(idpost);

            pagina.getListaPost().add(post);
            String message = "{\"message\": "+"\"Collegamento eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        } catch (Exception e) {
            String message = "{\"errorCode\":3,\"message\": "+"\"Errore nell'operazione di collegamento\"}";
            return Response.status(Response.Status.NOT_MODIFIED).entity(message).build();
        }
    }


}
