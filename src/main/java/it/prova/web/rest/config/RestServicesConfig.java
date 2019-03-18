package it.prova.web.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import it.prova.web.rest.resources.AcquistoResource;
import it.prova.web.rest.resources.AnnuncioResource;
import it.prova.web.rest.resources.UtenteResource;

public class RestServicesConfig extends Application {
	 public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(AcquistoResource.class);
        classes.add(AnnuncioResource.class);
        classes.add(UtenteResource.class);
//        classes.add(AbitanteResource.class);
        return classes;
	}
}