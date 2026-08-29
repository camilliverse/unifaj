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
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private LocalDate data;

    private String resultado;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Laboratorio laboratorio;
}