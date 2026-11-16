// index.html: mostra quantos registros foram importados, lendo a API REST

const totalEstados = document.getElementById('totalEstados');
const totalMunicipios = document.getElementById('totalMunicipios');

// GET /api/estados -> lista; usamos o tamanho dela
fetch('/api/estados')
    .then(resposta => resposta.json())
    .then(estados => { totalEstados.textContent = formatar(estados.length); })
    .catch(() => { totalEstados.textContent = '?'; });

// GET /api/municipios/total -> numero
fetch('/api/municipios/total')
    .then(resposta => resposta.json())
    .then(total => { totalMunicipios.textContent = formatar(total); })
    .catch(() => { totalMunicipios.textContent = '?'; });
