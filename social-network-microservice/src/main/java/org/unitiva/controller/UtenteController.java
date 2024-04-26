package org.unitiva.controller;

import org.unitiva.bean.Utente;
import org.unitiva.dto.UtenteDTO;
import org.unitiva.service.UtenteService;

import com.fasterxml.jackson.core.JsonProcessingException;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Create")
    @Transactional
    @Valid
    public Response createUtente(UtenteDTO utente) throws JsonProcessingException{
        try{
            String message = "{\"message\": "+"\"Create eseguita con successo\"}";
            service.addUtente(utente);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        }catch(Exception e){
            String message = "{\"errorCode\":1,\"message\": "+"\"Errore nell'operazione di creazione\"}";
            return Response.status(Response.Status.NOT_MODIFIED)
            .entity(message)
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
            String message = "{\"message\": "+"\"Update eseguita con successo\"}";
            service.updateUtente(idUtente, utente);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        }catch(Exception e){
            String message = "{\"errorCode\":2,\"message\": "+"\"Errore nell'operazione di update\"}";
            return Response.status(Response.Status.NOT_MODIFIED)
            .entity(message)
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
            String message = "{\"message\": "+"\"Delete eseguita con successo\"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        }catch(Exception e){
            String message = "{\"errorCode\":3,\"message\": "+"\"Errore nell'operazione di deelet\"}";
            return Response.status(Response.Status.NOT_MODIFIED)
            .entity(message)
            .build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/GetUtenteById")
    @Transactional
    @Valid
    public Response getUtenteById(@QueryParam("id") Long idUtente) throws JsonProcessingException{
        try{
            Utente utente = service.retrieveById(idUtente);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(utente).build();
        }catch(Exception e){
            String message = "{\"errorCode\":5,\"message\": "+"\"Errore nell'operazione di update\"}";
            return Response.status(Response.Status.NOT_MODIFIED)
            .entity(message)
            .build();
        }
    }
}
