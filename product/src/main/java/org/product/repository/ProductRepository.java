package org.product.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.product.entity.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    @PersistenceContext
    private EntityManager entityManager;

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

}
