// =========================================================
// ATENCAO: troque os valores abaixo pelo SEU nome e SEU RA.
// Esse arquivo e usado por TODAS as paginas (index + listagens)
// para exibir o nome e o RA, conforme exigido no enunciado.
// =========================================================
const ALUNO = {
    nome: "SEU NOME COMPLETO AQUI",
    ra: "SEU RA AQUI"
};

// Insere automaticamente "Nome - RA" em qualquer elemento
// com id="dados-aluno" presente na pagina.
document.addEventListener("DOMContentLoaded", () => {
    const alvo = document.getElementById("dados-aluno");
    if (alvo) {
        alvo.textContent = `Aluno: ${ALUNO.nome}  |  RA: ${ALUNO.ra}`;
    }
});
