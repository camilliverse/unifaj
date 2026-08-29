package unifaj.com.planoSaude.entity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fisioterapeuta extends ProfissionalSaude {

    private String crefito;
}