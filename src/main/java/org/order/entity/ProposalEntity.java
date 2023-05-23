package org.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.order.dto.ProposalDTO;


@Entity
@Table(name = "tb_proposal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProposalEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Email
    private String email;

    private String telefone;

    public ProposalEntity(ProposalDTO dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.telefone = dto.getTelefone();
    }
    public void update(ProposalDTO dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
    }

}
