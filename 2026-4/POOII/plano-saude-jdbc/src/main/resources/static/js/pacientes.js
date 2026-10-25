const URL_PACIENTES = "/pacientes";

async function carregar() {
    try {
        const resp = await fetch(URL_PACIENTES);               // GET -> lista
        if (!resp.ok) throw new Error("Erro " + resp.status);
        const lista = await resp.json();
        const tb = document.getElementById("lista");
        tb.innerHTML = "";
        lista.forEach(p => {
            const tr = document.createElement("tr");
            tr.innerHTML =
                "<td>" + p.id + "</td><td>" + esc(p.nome) + "</td><td>" + esc(p.cpf) + "</td>" +
                "<td>" + esc(p.dataNascimento) + "</td><td>" + esc(p.telefone) + "</td>" +
                "<td>" + esc(p.numeroCarteirinha) + "</td>" +
                '<td><a class="btn" href="paciente-form.html?id=' + p.id + '">Alterar</a> ' +
                '<button class="btn danger" onclick="excluir(' + p.id + ')">Excluir</button></td>';
            tb.appendChild(tr);
        });
    } catch (e) { mostrarErro("Falha ao listar: " + e.message); }
}

async function excluir(id) {
    if (!confirm("Excluir o paciente " + id + "?")) return;
    try {
        const resp = await fetch(URL_PACIENTES + "/" + id, { method: "DELETE" });   // DELETE
        if (!resp.ok) throw new Error("Erro " + resp.status);
        carregar();
    } catch (e) { mostrarErro("Falha ao excluir: " + e.message); }
}

document.addEventListener("DOMContentLoaded", carregar);
