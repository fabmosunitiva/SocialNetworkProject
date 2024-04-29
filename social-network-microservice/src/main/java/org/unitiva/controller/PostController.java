package org.unitiva.controller;

import org.unitiva.bean.Post;
import org.unitiva.dto.PostDTO;
import org.unitiva.exception.ResponseObject;
import org.unitiva.exception.UserNotAllowed;
import org.unitiva.exception.database.DataAccessException;
import org.unitiva.service.PostService;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/post")
public class PostController {

    @Inject
    PostService postService;

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newPost (PostDTO postDTO){
        try{
            postService.save(postDTO);
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
    public Response updateCommento (PostDTO postDTO) {
        try{
            postService.updatePost(postDTO);
            String message = "{\"message\": "+"\"Update eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        } catch (Exception e){
            return Response.status(Response.Status.NOT_MODIFIED).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deletePost (@QueryParam("idPost") Long idPost, @QueryParam("idUtente") Long idUtente) throws UserNotAllowed,DataAccessException{
        try{
            postService.deleteById(idPost, idUtente);
            String message = "{\"message\": "+"\"Delete eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();                
        } catch (UserNotAllowed e){
            Log.info(e.getMessage());
            ResponseObject res = new ResponseObject(e.getMessage());
            // String message = "{\"errorCode\":3,\"message\": "+"\"Errore nell'operazione di Delete\"}";
            return Response.status(Response.Status.FORBIDDEN).entity(res).type(MediaType.APPLICATION_JSON).build();
        }
        catch (DataAccessException e){
            ResponseObject res = new ResponseObject(e.getMessage());
            // String message = "{\"errorCode\":3,\"message\": "+"\"Errore nell'operazione di Delete\"}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findCommento (@QueryParam("id") Long id){
        try{
            Post post = postService.retrieveById(id);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(post).build();
        } catch (Exception e){
            String message = "{\"errorCode\":5,\"message\": "+"\"Errore nell'operazione di Delete\"}";
            return Response.status(Response.Status.NOT_MODIFIED).entity(message).build();
        }
    }


}
