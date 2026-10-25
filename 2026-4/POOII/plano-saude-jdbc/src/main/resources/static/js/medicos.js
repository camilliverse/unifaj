const URL_MEDICOS = "/medicos";

async function carregar() {
    try {
        const resp = await fetch(URL_MEDICOS);                 // GET -> lista
        if (!resp.ok) throw new Error("Erro " + resp.status);
        const lista = await resp.json();
        const tb = document.getElementById("lista");
        tb.innerHTML = "";
        lista.forEach(m => {
            const tr = document.createElement("tr");
            tr.innerHTML =
                "<td>" + m.id + "</td><td>" + esc(m.nome) + "</td><td>" + esc(m.crm) + "</td>" +
                "<td>" + esc(m.especialidade) + "</td><td>" + esc(m.telefone) + "</td>" +
                '<td><a class="btn" href="medico-form.html?id=' + m.id + '">Alterar</a> ' +
                '<button class="btn danger" onclick="excluir(' + m.id + ')">Excluir</button></td>';
            tb.appendChild(tr);
        });
    } catch (e) { mostrarErro("Falha ao listar: " + e.message); }
}

async function excluir(id) {
    if (!confirm("Excluir o médico " + id + "?")) return;
    try {
        const resp = await fetch(URL_MEDICOS + "/" + id, { method: "DELETE" });     // DELETE
        if (!resp.ok) throw new Error("Erro " + resp.status);
        carregar();
    } catch (e) { mostrarErro("Falha ao excluir: " + e.message); }
}

document.addEventListener("DOMContentLoaded", carregar);
