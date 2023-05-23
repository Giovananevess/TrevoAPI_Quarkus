package org.product.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.product.dto.ProductDTO;
import org.product.entity.Product;
import org.product.repository.ProductRepository;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;


    public Response register(@RequestBody @Valid ProductDTO dto) {
        Product product = new Product(dto);
        productRepository.persist(product);
        return Response.ok(product).build();
    }

    public Response list() {
        List<Product> productList = productRepository.findAll().list();
        return Response.status(200).entity("Lista de produtos recuperada com sucesso.").entity(productList).build();
    }

    public Response update(@RequestBody ProductDTO dto, @PathParam("id") Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            product.update(dto);
            productRepository.persist(product);
            return Response.ok("Produto atualizado com sucesso.").build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response delete(@PathParam("id") Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            productRepository.deleteById(id);
            return Response.ok("Produto deletado com sucesso.").build();
        }
        return Response.status(404).entity("Produto não encontrado").build();
    }
}

