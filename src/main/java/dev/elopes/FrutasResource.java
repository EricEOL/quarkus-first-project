package dev.elopes;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.elopes.dto.InserirFrutaDTO;

@Path("/frutas")
public class FrutasResource {

    @Inject
    FrutaService frutaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list() {
        return frutaService.list();
    }

    @POST
    public void createFruit(InserirFrutaDTO dto) {
        frutaService.create(dto);
    }
}