const BASE = "/api/planosaude";

async function carregarTotalPacientes() {
    const elemento = document.getElementById("totalPacientes");
    try {
        const resposta = await fetch(`${BASE}/paciente`, { method: "GET" });
        if (!resposta.ok) {
            throw new Error("status " + resposta.status);
        }
        const pacientes = await resposta.json();
        elemento.textContent = pacientes.length;
    } catch (erro) {
        elemento.textContent = "erro";
        console.error("Erro ao buscar pacientes:", erro);
    }
}

async function carregarTotalMedicos() {
    const elemento = document.getElementById("totalMedicos");
    try {
        const resposta = await fetch(`${BASE}/medico`, { method: "GET" });
        if (!resposta.ok) {
            throw new Error("status " + resposta.status);
        }
        const medicos = await resposta.json();
        elemento.textContent = medicos.length;
    } catch (erro) {
        elemento.textContent = "erro";
        console.error("Erro ao buscar medicos:", erro);
    }
}

document.addEventListener("DOMContentLoaded", () => {
    carregarTotalPacientes();
    carregarTotalMedicos();
});