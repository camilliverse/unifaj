// CRUD generico via FETCH. Cada pagina define window.CFG = {url, campos:[{nome,rotulo,tipo}]}
const cfg = window.CFG;
const form = document.getElementById('form');
const tbody = document.getElementById('tbody');
let editandoId = null;

document.getElementById('thead').innerHTML =
  '<tr><th>ID</th>' + cfg.campos.map(c => `<th>${c.rotulo}</th>`).join('') + '<th>Ações</th></tr>';

form.innerHTML = cfg.campos.map(c =>
  `<label>${c.rotulo}<input id="f_${c.nome}" type="${c.tipo || 'text'}" required></label>`).join('') +
  '<button type="submit" id="btnSalvar">Incluir</button> <button type="button" id="btnCancelar" hidden>Cancelar</button>';

async function listar() {
  const resp = await fetch(cfg.url);
  const dados = await resp.json();
  tbody.innerHTML = dados.map(d => `<tr><td>${d.id}</td>` +
    cfg.campos.map(c => `<td>${d[c.nome] ?? ''}</td>`).join('') +
    `<td><button onclick="editar(${d.id})">Alterar</button> <button onclick="excluir(${d.id})">Excluir</button></td></tr>`).join('');
}

async function editar(id) {
  const d = await (await fetch(`${cfg.url}/${id}`)).json();
  cfg.campos.forEach(c => document.getElementById('f_' + c.nome).value = d[c.nome] ?? '');
  editandoId = id;
  document.getElementById('btnSalvar').textContent = 'Salvar alteração';
  document.getElementById('btnCancelar').hidden = false;
}

function limpar() {
  form.reset(); editandoId = null;
  document.getElementById('btnSalvar').textContent = 'Incluir';
  document.getElementById('btnCancelar').hidden = true;
}

async function excluir(id) {
  if (!confirm('Excluir o registro ' + id + '?')) return;
  await fetch(`${cfg.url}/${id}`, { method: 'DELETE' });
  listar();
}

form.addEventListener('submit', async e => {
  e.preventDefault();
  const obj = {};
  cfg.campos.forEach(c => obj[c.nome] = document.getElementById('f_' + c.nome).value);
  await fetch(editandoId ? `${cfg.url}/${editandoId}` : cfg.url, {
    method: editandoId ? 'PUT' : 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(obj)
  });
  limpar(); listar();
});

document.getElementById('btnCancelar').addEventListener('click', limpar);
listar();
