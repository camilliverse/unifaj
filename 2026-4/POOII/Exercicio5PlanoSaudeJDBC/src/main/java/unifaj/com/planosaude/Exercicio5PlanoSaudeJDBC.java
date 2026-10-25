package unifaj.com.planosaude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio5PlanoSaudeJDBC {

	public static final String ALUNO_NOME = "Camilli Santos";
	public static final String ALUNO_RA = "12529495";

	public static void main(String[] args) {
		SpringApplication.run(Exercicio5PlanoSaudeJDBC.class, args);

		System.out.println("========================================================");
		System.out.println(" Exercicio5PlanoSaudeJDBC iniciado com sucesso!");
		System.out.println(" Aluna: " + ALUNO_NOME + " | RA: " + ALUNO_RA);
		System.out.println(" Acesse: http://localhost:8080/index.html");
		System.out.println("========================================================");
	}

}