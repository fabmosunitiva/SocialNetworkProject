package org.unitiva.controller;

import org.unitiva.bean.Post;
import org.unitiva.dto.PostDTO;
import org.unitiva.exception.NotFoundException;
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

    public ResponseObject response = new ResponseObject();

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response newPost (PostDTO postDTO){
        try{
            postService.save(postDTO);
            response.setMessage("Post inserito con successo");
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(response).build();
        }
        catch (DataAccessException e){
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(response).build();
        }
        catch (Exception e){
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(response).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateCommento (PostDTO postDTO) {
        try{
            postService.updatePost(postDTO);
            response.setMessage("Post aggioranto con successo");
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(response).build();
        }catch (DataAccessException e){
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.NOT_MODIFIED).entity(response).build();
        }catch(UserNotAllowed userNotAllowed){
            response.setMessage(userNotAllowed.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(response).build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deletePost (@QueryParam("idPost") Long idPost, @QueryParam("idUtente") Long idUtente) throws UserNotAllowed,DataAccessException{
        try{
            postService.deleteById(idPost, idUtente);
            response.setMessage("Post eliminato con successo");
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(response).build();                
        } catch (UserNotAllowed e){
            Log.info(e.getMessage());
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.FORBIDDEN).entity(response).type(MediaType.APPLICATION_JSON).build();
        }
        catch (DataAccessException e){
            response.setMessage(e.getMessage());
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findPost (@QueryParam("id") Long id) throws NotFoundException,DataAccessException{
        try{
            Post post = postService.retrieveById(id);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(post).build();
        }catch (NotFoundException e){
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }catch (DataAccessException e){
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }


}
