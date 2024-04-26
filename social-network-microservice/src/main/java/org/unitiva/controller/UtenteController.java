package org.unitiva.controller;

import org.unitiva.bean.Utente;
import org.unitiva.dto.UtenteDTO;
import org.unitiva.exception.ResponseObject;
import org.unitiva.exception.UserNotFoundException;
import org.unitiva.exception.database.DataAccessException;
import org.unitiva.service.UtenteService;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class UtenteController {
    @Inject
    UtenteService service;

    @Inject
    ResponseObject response;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Create")
    @Transactional
    @Valid
    public Response createUtente(UtenteDTO utente) throws JsonProcessingException{
        try{
            response.setMessage("Creazione Avvenuta con successo");
            service.addUtente(utente);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(response).build();
        }catch(DataAccessException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            String methodName = stackTrace[1].getMethodName();
            Log.error("Errore in" +methodName+ "errore ad accedere al dato " + e);
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(response)
            .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Update")
    @Transactional
    @Valid
    public Response updateUtente(@QueryParam("id") Long idUtente, UtenteDTO utente) throws JsonProcessingException{
        try{
            service.updateUtente(idUtente, utente);
            response.setMessage("Update avvenuto con successo");
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(response).build();
        }catch(DataAccessException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            String methodName = stackTrace[1].getMethodName();
            Log.error("Errore in" +methodName+ "errore ad accedere al dato " + e);
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(response)
            .build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Delete")
    @Transactional
    @Valid
    public Response deleteUtente(@QueryParam("id") Long idUtente) throws JsonProcessingException{
        try{
            service.deleteById(idUtente);
            response.setMessage("Delete Avvenuta con successo");
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(response).build();
        }catch(DataAccessException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            String methodName = stackTrace[1].getMethodName();  // Get method name from stack trace (index 1)
            Log.error("Errore in " +methodName+ " errore ad accedere al dato " + e);
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.NOT_MODIFIED)
            .entity(response)
            .build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/GetUtenteById")
    @Transactional
    @Valid
    public Response getUtenteById(@QueryParam("id") Long idUtente) throws JsonProcessingException, DataAccessException{
        try{
            Utente utente = service.retrieveById(idUtente);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(utente).build();
        }catch(UserNotFoundException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            String methodName = stackTrace[1].getMethodName();
            Log.error("Errore in " +methodName+ " utente non trovato" + e);
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
            .entity(response)
            .build();
        }
        catch(DataAccessException e){
            Log.error("Errore in getUtenteById errore ad accedere al dato " + e);
            response.setMessage(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(response)
            .build();
        }
    }
}
