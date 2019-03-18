
package it.prova.web.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.model.Annuncio;
import it.prova.model.Utente;
import it.prova.service.AcquistoService;
import it.prova.service.AnnuncioService;
import it.prova.service.UtenteService;
import it.prova.web.dto.AcquistoDTO;

@Component
@Path("/acquisto")
public class AcquistoResource {

	@Autowired
	AcquistoService acquistoService;

	@Autowired
	AnnuncioService annuncioService;

	@Autowired
	UtenteService utenteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		return Response.status(200).entity(AcquistoDTO.listAcquistoDTO(acquistoService.listAllAcquisto())).build();
	}
	
	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eseguiAcquisto(@PathParam("id") Long id) {

		Annuncio annuncioTarget = annuncioService.caricaSingoloAnnuncio(id);
		Utente acquirente = utenteService.caricaSingoloUtente(1L);
		
		if (!acquirente.verificaDisponibilita(annuncioTarget.getPrezzo())) {
			return Response.status(Response.Status.FORBIDDEN).entity("NO MONEY").build();
		}
		
		return Response.status(200).entity(new AcquistoDTO(acquistoService.eseguiAcquisto(acquirente, annuncioTarget))).build();
	}
	
}