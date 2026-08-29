package unifaj.com.planoSaude.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unifaj.com.planoSaude.entity.Consulta;
import unifaj.com.planoSaude.service.ConsultaService;

@Controller
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("consultas", consultaService.listar());
        return "consultas";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("consulta", new Consulta());
        return "consulta-form";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Consulta consulta) {
        consulta.agendar();
        consultaService.cadastrar(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        consultaService.remover(id);
        return "redirect:/consultas";
    }
}