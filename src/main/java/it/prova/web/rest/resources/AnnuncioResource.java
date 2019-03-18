package it.prova.web.rest.resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import it.prova.model.Annuncio;
import it.prova.model.Category;
import it.prova.service.AnnuncioService;
import it.prova.web.dto.AnnuncioDTO;

@Component
@Path("/annuncio")
public class AnnuncioResource {

	@Autowired
	AnnuncioService annuncioService;

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnnuncio(@PathParam("id") Long id) {
		return Response.status(200).entity(new AnnuncioDTO(annuncioService.caricaSingoloAnnuncio(id))).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertNuovoAnnuncio(Annuncio annuncioInput) {
		
		HashMap<String, String> listaErrori = new AnnuncioDTO(annuncioInput).validate();

		if (!listaErrori.isEmpty()) {
			return Response.status(Response.Status.FORBIDDEN).entity(listaErrori).build();
		}

		annuncioService.inserisciNuovoAnnuncio(annuncioInput);
		return Response.status(200).entity(annuncioInput).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		return Response.status(200).entity(AnnuncioDTO.listAnnuncioDTO(annuncioService.listAllAnnuncio())).build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchAnnuncio(@QueryParam("aperto") Boolean aperto, @QueryParam("testoAnnuncio") String testoAnnuncio,
			@QueryParam("prezzo") int prezzo) { //, @QueryParam("ListaIdCategorie") Long[] listaIdCategorie) {
		
		Annuncio example = new Annuncio(aperto, testoAnnuncio, prezzo);
		Set<Category> categorieAnnuncio = new HashSet<>();
		example.setCategory(categorieAnnuncio);

//		if (listaIdCategorie != null) {
//
//			for (Long idCategoria : listaIdCategorie) {
//
//				Category categoryTemp = categoryService.caricaSingoloCategory(idCategoria);
//
//				example.getCategory().add(categoryTemp);
//			}
//		}
		
		List<Annuncio> result = annuncioService.findByExample(example);
		return Response.status(200).entity(AnnuncioDTO.listAnnuncioDTO(result)).build();
	}

	@DELETE
	@Path("{id : \\d+}")
	public Response deleteAnnuncio(@PathParam("id") Long id) {
		annuncioService.rimuovi(annuncioService.caricaSingoloAnnuncio(id));
		return Response.status(200).entity("Rimosso Annuncio avente id: " + id).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response aggiornaAnnuncio(Annuncio annuncioInput) {
		annuncioService.aggiorna(annuncioInput);
		return Response.status(200).entity(annuncioInput).build();
	}
}
