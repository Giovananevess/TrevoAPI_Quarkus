package org.product.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.product.dto.ProductDTO;
import org.product.service.ProductService;

@Path("/product")
public class ProductResource {
    @Inject
    ProductService productService;

    @POST
    @Transactional
    public Response register(@RequestBody @Valid ProductDTO dto) {
        return productService.register(dto);
    }

    @GET
    @Path("/list") // Adicionado o sufixo "/list" ao caminho do endpoint
    public Response list() {
        return productService.list();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, @RequestBody @Valid ProductDTO dto) {
       return productService.update(dto, id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        return productService.delete(id);
    }

}
