// estados.html: lista os estados vindos de GET /api/estados

const lista = document.getElementById('lista');
const status = document.getElementById('status');
const busca = document.getElementById('busca');

let estados = []; // resultado do fetch (usado pela busca)

// Desenha os cartoes (aplica a busca digitada, sem novo fetch)
function desenhar() {
    const termo = semAcento(busca.value.trim());
    const visiveis = termo
        ? estados.filter(e => semAcento(e.nome).includes(termo) || semAcento(e.sigla).includes(termo))
        : estados;

    status.textContent = termo
        ? visiveis.length + ' estado(s) encontrado(s)'
        : estados.length + ' estados importados. Toque em um para ver os municípios.';

    if (visiveis.length === 0) {
        lista.innerHTML = '<li class="vazio">Nenhum estado encontrado. Tente outro nome ou sigla.</li>';
        return;
    }

    lista.innerHTML = visiveis.map(e =>
        '<li><a class="estado" href="municipios.html?estado=' + encodeURIComponent(e.nome) + '">' +
        '<span class="sigla">' + esc(e.sigla) + '</span>' +
        '<span>' +
        '<span class="nome">' + esc(e.nome) + '</span>' +
        '<span class="cod">Código ' + esc(e.id) + '</span>' +
        '</span>' +
        '</a></li>'
    ).join('');
}

// GET /api/estados
fetch('/api/estados')
    .then(resposta => {
        if (!resposta.ok) throw new Error('HTTP ' + resposta.status);
        return resposta.json();
    })
    .then(dados => {
        estados = dados;
        desenhar();
    })
    .catch(erro => {
        status.textContent = 'Não foi possível carregar os estados (' + erro.message + '). Confira se a aplicação está rodando.';
        status.classList.add('erro');
    });

busca.addEventListener('input', desenhar);
