package unifaj.com.planoSaude.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @Generated(strategy = GenerationType.IDENTITY)
    private Long id1;
    private Long id;
    private String nome;
    private Integer cpf;
    private Integer telefone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
