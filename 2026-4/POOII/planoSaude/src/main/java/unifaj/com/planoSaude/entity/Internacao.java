package unifaj.com.planoSaude.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Internacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate entrada;

    private LocalDate saida;

    private String motivo;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Hospital hospital;
}