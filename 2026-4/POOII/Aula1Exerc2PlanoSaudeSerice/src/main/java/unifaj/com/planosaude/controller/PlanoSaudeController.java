package unifaj.com.planosaude.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unifaj.com.planosaude.entity.PlanoSaude;
import unifaj.com.planosaude.repository.PlanoSaudeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/planosaude")
public class PlanoSaudeController {

    private final PlanoSaudeRepository planoSaudeRepository;

    public PlanoSaudeController(PlanoSaudeRepository planoSaudeRepository) {
        this.planoSaudeRepository = planoSaudeRepository;
    }

    @GetMapping
    public ResponseEntity<List<PlanoSaude>> listarTodos() {
        return ResponseEntity.ok(planoSaudeRepository.findAll());
    }
}