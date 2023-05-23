package org.order.service;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.order.entity.ProposalEntity;
import org.order.client.ProductClient;
import org.order.dto.ProposalDTO;
import org.order.repository.ProposalRepository;
import java.util.List;

public class ProposalService {
    @Inject
    ProposalRepository proposalRepository;

    @Inject

    @RestClient
    private ProductClient productClient;


    public Response register(@RequestBody @Valid ProposalDTO dto) {

        ProposalEntity proposal = new ProposalEntity(dto);
        proposalRepository.persist(proposal);
        return Response.ok(proposal).build();
    }

    public Response list() {
        List<ProposalEntity> productList = proposalRepository.findAll().list();
        return Response.status(200).entity("Lista de produtos recuperada com sucesso.").entity(productList).build();
    }

    public Response update(@RequestBody ProposalDTO dto, @PathParam("id") Long id) {
        ProposalEntity proposal = proposalRepository.findById(id);
        if (proposal != null) {
            proposal.update(dto);
            proposalRepository.persist(proposal);
            return Response.ok("Produto atualizado com sucesso.").build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response delete(@PathParam("id") Long id) {
        ProposalEntity proposal = proposalRepository.findById(id);
        if (proposal != null) {
            proposalRepository.deleteById(id);
            return Response.ok("Produto deletado com sucesso.").build();
        }
        return Response.status(404).entity("Produto não encontrado").build();
    }

}
