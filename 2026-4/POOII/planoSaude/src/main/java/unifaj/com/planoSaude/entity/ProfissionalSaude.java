package unifaj.com.planoSaude.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalSaude extends Pessoa {

    private String registroProfissional;
}