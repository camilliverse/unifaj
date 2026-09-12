package unifaj.com.planosaude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aula1Exerc2PlanoSaudeSericeApplication {

	public static final String ALUNO_NOME = "Camilli Santos";
	public static final String ALUNO_RA = "12529495";

	public static void main(String[] args) {
		SpringApplication.run(Aula1Exerc2PlanoSaudeSericeApplication.class, args);

		System.out.println("========================================================");
		System.out.println(" Aula1Exerc2PlanoSaudeSerice iniciado com sucesso!");
		System.out.println(" Aluna: " + ALUNO_NOME + " | RA: " + ALUNO_RA);
		System.out.println(" API base: http://localhost:8080/api/planosaude");
		System.out.println("========================================================");
	}

}
