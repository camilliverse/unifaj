// =======================================================
// Funcoes de comunicacao com o Backend (Spring Boot) via FETCH
// Recurso: /api/pacientes
// =======================================================

const PACIENTE_URL = `${API_BASE_URL}/pacientes`;

// ---------- LISTAR (GET) ----------
async function listarPacientes() {
    const resposta = await fetch(PACIENTE_URL, {
        method: "GET"
    });
    if (!resposta.ok) {
        throw new Error("Erro ao listar pacientes: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- BUSCAR POR ID (GET) - usado nas telas de Alterar/Excluir ----------
async function buscarPacientePorId(id) {
    const resposta = await fetch(`${PACIENTE_URL}/${id}`, {
        method: "GET"
    });
    if (!resposta.ok) {
        throw new Error("Paciente nao encontrado: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- INCLUIR (POST) ----------
async function incluirPaciente(paciente) {
    const resposta = await fetch(PACIENTE_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(paciente)
    });
    if (!resposta.ok) {
        throw new Error("Erro ao incluir paciente: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- ALTERAR (PUT) ----------
async function alterarPaciente(id, paciente) {
    const resposta = await fetch(`${PACIENTE_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(paciente)
    });
    if (!resposta.ok) {
        throw new Error("Erro ao alterar paciente: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- EXCLUIR (DELETE) ----------
async function excluirPaciente(id) {
    const resposta = await fetch(`${PACIENTE_URL}/${id}`, {
        method: "DELETE"
    });
    if (!resposta.ok) {
        throw new Error("Erro ao excluir paciente: " + resposta.status);
    }
    return true;
}
