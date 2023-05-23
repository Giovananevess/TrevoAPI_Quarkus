package org.order.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.order.entity.ProposalEntity;

@ApplicationScoped
public class ProposalRepository implements PanacheRepository<ProposalEntity> {
    @PersistenceContext
    private EntityManager entityManager;

    public ProposalEntity findById(Long id) {
        return entityManager.find(ProposalEntity.class, id);
    }
}
