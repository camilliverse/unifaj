package unifaj.com.planoSaude.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta implements Agendavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private LocalTime horario;

    private String status;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    @Override
    public void agendar() {
        this.status = "AGENDADA";
    }

    @Override
    public void cancelar() {
        this.status = "CANCELADA";
    }
}