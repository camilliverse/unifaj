package unifaj.com.planoSaude.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends ProfissionalSaude {

    private String crm;

    @ManyToOne
    private Especialidade especialidade;

    @ManyToOne
    private Clinica clinica;
}