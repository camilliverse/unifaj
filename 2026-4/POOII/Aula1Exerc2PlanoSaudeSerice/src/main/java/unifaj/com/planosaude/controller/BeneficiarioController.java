package unifaj.com.planosaude.controller;

import unifaj.com.planosaude.entity.Beneficiario;
import unifaj.com.planosaude.repository.BeneficiarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planosaude/beneficiario")
public class BeneficiarioController {

    private final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioController(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    @GetMapping
    public List<Beneficiario> obterTodos() {
        return beneficiarioRepository.findAll();
    }

    @GetMapping("/{idBeneficiario}")
    public ResponseEntity<Beneficiario> obterUm(@PathVariable Long idBeneficiario) {
        return beneficiarioRepository.findById(idBeneficiario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Beneficiario> criar(@Valid @RequestBody Beneficiario beneficiario) {
        beneficiario.setId(null); // garante que sera um registro novo
        Beneficiario salvo = beneficiarioRepository.save(beneficiario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping
    public ResponseEntity<Beneficiario> atualizar(@Valid @RequestBody Beneficiario beneficiario) {
        if (beneficiario.getId() == null || !beneficiarioRepository.existsById(beneficiario.getId())) {
            return ResponseEntity.notFound().build();
        }
        Beneficiario atualizado = beneficiarioRepository.save(beneficiario);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{idBeneficiario}")
    public ResponseEntity<Void> excluir(@PathVariable Long idBeneficiario) {
        if (!beneficiarioRepository.existsById(idBeneficiario)) {
            return ResponseEntity.notFound().build();
        }
        beneficiarioRepository.deleteById(idBeneficiario);
        return ResponseEntity.noContent().build();
    }
}
