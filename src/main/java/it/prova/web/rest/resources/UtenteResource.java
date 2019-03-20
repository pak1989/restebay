package it.prova.web.rest.resources;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.model.Utente;
import it.prova.service.UtenteService;
import it.prova.web.dto.UtenteDTO;

@Component
@Path("/utente")
public class UtenteResource {

	@Autowired
	UtenteService utenteService;

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtente(@PathParam("id") Long id) {
		return Response.status(200).entity(new UtenteDTO(utenteService.caricaSingoloUtente(id))).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertNuovoUtente(Utente utenteInput) {

		HashMap<String, String> listaErrori = new UtenteDTO(utenteInput).validate();

		if (!listaErrori.isEmpty()) {
			return Response.status(Response.Status.FORBIDDEN).entity(listaErrori).build();
		}

		utenteService.inserisciNuovo(utenteInput);
		return Response.status(200).entity(utenteInput).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		return Response.status(200).entity(UtenteDTO.listUtenteDTO(utenteService.listAllUtenti())).build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchUtente(@QueryParam("nome") String nome, @QueryParam("cognome") String cognome,
			@QueryParam("username") String username, @QueryParam("password") String password) {
		List<Utente> result = utenteService.findByExample(new Utente(nome, cognome, username, password));
		return Response.status(200).entity(UtenteDTO.listUtenteDTO(result)).build();
	}

	@DELETE
	@Path("{id : \\d+}")
	public Response deleteUtente(@PathParam("id") Long id) {
		utenteService.rimuovi(utenteService.caricaSingoloUtente(id));
		return Response.status(200).entity("Rimosso Utente avente id: " + id).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response aggiornaUtente(Utente utenteInput) {
		utenteService.aggiorna(utenteInput);
		return Response.status(200).entity(utenteInput).build();
	}
	
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eseguiAccesso(@QueryParam("username") String username, @QueryParam("password") String password) {
		
		System.out.println(username + ' ' + password);
		
		Utente utenteInAccesso = utenteService.eseguiAccesso(username, password);
		
		if ( utenteInAccesso != null ) {
			return Response.status(200).entity(new UtenteDTO(utenteService.caricaSingoloUtente(utenteInAccesso.getId()))).build();			
		} else {
			return Response.status(Response.Status.FORBIDDEN).entity("Utente non trovato!").build();
		}
	}
	
	
}
