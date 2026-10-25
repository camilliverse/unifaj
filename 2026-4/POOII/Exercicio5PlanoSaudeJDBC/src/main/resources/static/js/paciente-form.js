const URL_PACIENTES = "/pacientes";
const id = new URLSearchParams(location.search).get("id");   // se existir -> ALTERAR

document.addEventListener("DOMContentLoaded", async () => {
    if (id) {
        document.getElementById("titulo").textContent = "Alterar paciente";
        try {
            const resp = await fetch(URL_PACIENTES + "/" + id);       // GET por id
            if (!resp.ok) throw new Error("Erro " + resp.status);
            const p = await resp.json();
            ["nome", "cpf", "dataNascimento", "telefone", "numeroCarteirinha"]
                .forEach(c => document.getElementById(c).value = p[c] || "");
        } catch (e) { mostrarErro("Falha ao carregar: " + e.message); }
    }

    document.getElementById("form").addEventListener("submit", async ev => {
        ev.preventDefault();
        const dados = {
            nome: document.getElementById("nome").value,
            cpf: document.getElementById("cpf").value,
            dataNascimento: document.getElementById("dataNascimento").value || null,
            telefone: document.getElementById("telefone").value,
            numeroCarteirinha: document.getElementById("numeroCarteirinha").value
        };
        try {
            const resp = await fetch(id ? URL_PACIENTES + "/" + id : URL_PACIENTES, {
                method: id ? "PUT" : "POST",                           // PUT = alterar, POST = incluir
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(dados)
            });
            if (!resp.ok) throw new Error("Erro " + resp.status);
            location.href = "pacientes.html";
        } catch (e) { mostrarErro("Falha ao salvar: " + e.message); }
    });
});
