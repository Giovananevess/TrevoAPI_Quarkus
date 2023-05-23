package org.order.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.order.service.ProposalService;
import org.order.dto.ProposalDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/proposal")
public class ProposalResource {
    @Inject
    ProposalService proposalService;

    @POST
    @Transactional
    public Response register(@RequestBody @Valid ProposalDTO dto) {
        return proposalService.register(dto);
    }

    @GET
    @Path("/list")
    public Response list() {
        return proposalService.list();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, @RequestBody @Valid ProposalDTO dto) {
        return proposalService.update(dto, id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        return proposalService.delete(id);
    }
}
