package org.order.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.order.dto.ProposalDTO;

@Path("/product")
@ApplicationScoped
@RegisterRestClient
public interface ProductClient {
    @GET
    @Path("/{id}")
    ProposalDTO getProposalById(@PathParam("id") long id);
}
