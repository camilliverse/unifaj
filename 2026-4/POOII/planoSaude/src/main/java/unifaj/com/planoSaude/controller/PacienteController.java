package unifaj.com.planoSaude.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unifaj.com.planoSaude.entity.Paciente;
import unifaj.com.planoSaude.service.PacienteService;

@Controller
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.listar());
        return "pacientes";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente-form";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Paciente paciente) {
        pacienteService.cadastrar(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        pacienteService.remover(id);
        return "redirect:/pacientes";
    }
}