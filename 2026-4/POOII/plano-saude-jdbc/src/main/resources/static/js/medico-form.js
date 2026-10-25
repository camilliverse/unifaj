const URL_MEDICOS = "/medicos";
const id = new URLSearchParams(location.search).get("id");   // se existir -> ALTERAR

document.addEventListener("DOMContentLoaded", async () => {
    if (id) {
        document.getElementById("titulo").textContent = "Alterar médico";
        try {
            const resp = await fetch(URL_MEDICOS + "/" + id);         // GET por id
            if (!resp.ok) throw new Error("Erro " + resp.status);
            const m = await resp.json();
            ["nome", "crm", "especialidade", "telefone"]
                .forEach(c => document.getElementById(c).value = m[c] || "");
        } catch (e) { mostrarErro("Falha ao carregar: " + e.message); }
    }

    document.getElementById("form").addEventListener("submit", async ev => {
        ev.preventDefault();
        const dados = {
            nome: document.getElementById("nome").value,
            crm: document.getElementById("crm").value,
            especialidade: document.getElementById("especialidade").value,
            telefone: document.getElementById("telefone").value
        };
        try {
            const resp = await fetch(id ? URL_MEDICOS + "/" + id : URL_MEDICOS, {
                method: id ? "PUT" : "POST",                           // PUT = alterar, POST = incluir
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(dados)
            });
            if (!resp.ok) throw new Error("Erro " + resp.status);
            location.href = "medicos.html";
        } catch (e) { mostrarErro("Falha ao salvar: " + e.message); }
    });
});
