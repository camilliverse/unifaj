package unifaj.com.planosaude.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends ProfissionalSaude {

    private String crm;

    @ManyToOne
    private Especialidade especialidade;

    @ManyToOne
    private Clinica clinica;
}
