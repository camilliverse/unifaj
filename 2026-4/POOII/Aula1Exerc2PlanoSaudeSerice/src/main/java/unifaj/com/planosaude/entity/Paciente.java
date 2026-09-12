package unifaj.com.planosaude.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa {

    private String numeroCarteirinha;

    private LocalDate dataNascimento;

    @ManyToOne
    private PlanoSaude planoSaude;
}
