package unifaj.com.planoSaude.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa {

    private String numeroCarteirinha;

    private LocalDate dataNascimento;

    @ManyToOne
    private PlanoSaude planoSaude;
}