// =======================================================
// Funcoes de comunicacao com o Backend (Spring Boot) via FETCH
// Recurso: /api/medicos
// =======================================================

const MEDICO_URL = `${API_BASE_URL}/medicos`;

// ---------- LISTAR (GET) ----------
async function listarMedicos() {
    const resposta = await fetch(MEDICO_URL, {
        method: "GET"
    });
    if (!resposta.ok) {
        throw new Error("Erro ao listar medicos: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- BUSCAR POR ID (GET) - usado nas telas de Alterar/Excluir ----------
async function buscarMedicoPorId(id) {
    const resposta = await fetch(`${MEDICO_URL}/${id}`, {
        method: "GET"
    });
    if (!resposta.ok) {
        throw new Error("Medico nao encontrado: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- INCLUIR (POST) ----------
async function incluirMedico(medico) {
    const resposta = await fetch(MEDICO_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(medico)
    });
    if (!resposta.ok) {
        throw new Error("Erro ao incluir medico: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- ALTERAR (PUT) ----------
async function alterarMedico(id, medico) {
    const resposta = await fetch(`${MEDICO_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(medico)
    });
    if (!resposta.ok) {
        throw new Error("Erro ao alterar medico: " + resposta.status);
    }
    return await resposta.json();
}

// ---------- EXCLUIR (DELETE) ----------
async function excluirMedico(id) {
    const resposta = await fetch(`${MEDICO_URL}/${id}`, {
        method: "DELETE"
    });
    if (!resposta.ok) {
        throw new Error("Erro ao excluir medico: " + resposta.status);
    }
    return true;
}
