package org.udla.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.search.mapper.orm.Search;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import io.quarkus.runtime.StartupEvent;
import org.udla.data.Clientes;
import org.udla.data.Contratos;

@Path("/contratos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratosServices {

    @Inject
    EntityManager em;

    @Transactional
    void onStart(@Observes StartupEvent ev) throws InterruptedException {
        if (Contratos.count() > 0) {
            Search.session(em)
                    .massIndexer()
                    .startAndWait();
        }
    }

    @GET
    @Transactional
    public List<Contratos> get() {
        try {
            return Contratos.listAll();
        } catch (Exception e) {
            return new ArrayList<Contratos>();
        }
    }

    @POST
    @Path("insert")
    @Transactional
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void insert(@FormParam String descripcion, @FormParam BigDecimal monto) {

        try {
            Contratos contrato = new Contratos();
            contrato.descripcion = descripcion;
            contrato.monto = monto;
            contrato.persist();
        } catch (Exception e) {
            return;
        }
    }

}
