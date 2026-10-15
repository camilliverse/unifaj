package unifaj.com.planosaude.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import unifaj.com.planosaude.entity.Agendavel;
import unifaj.com.planosaude.entity.Paciente;

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
