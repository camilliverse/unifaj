// >>> PREENCHA COM SEUS DADOS (obrigatorio aparecer nas paginas de listagem) <<<
const ALUNO = { nome: "SEU NOME COMPLETO", ra: "SEU RA" };

document.addEventListener("DOMContentLoaded", () => {
    const cab = document.getElementById("cabecalho");
    if (cab) {
        cab.innerHTML =
            '<h1>Plano de Saúde</h1>' +
            '<div class="aluno">Aluno: ' + ALUNO.nome + ' &nbsp;|&nbsp; RA: ' + ALUNO.ra + '</div>' +
            '<nav><a href="index.html">Início</a><a href="pacientes.html">Pacientes</a><a href="medicos.html">Médicos</a></nav>';
    }
});

// Evita injecao de HTML ao montar a tabela
function esc(v) {
    const d = document.createElement("div");
    d.textContent = v == null ? "" : v;
    return d.innerHTML;
}

function mostrarErro(texto) {
    const m = document.getElementById("msg");
    if (m) m.textContent = texto;
}
