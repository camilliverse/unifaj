// municipios.html: combo de estados + lista de municipios (com nome do estado)

const selEstado = document.getElementById('estado');
const buscaNome = document.getElementById('busca');
const lista = document.getElementById('lista');
const status = document.getElementById('status');

let municipios = []; // resultado atual do fetch (usado pela busca por nome)

// 1) Preenche o combo com GET /api/estados
function carregarEstados() {
    return fetch('/api/estados')
        .then(resposta => resposta.json())
        .then(estados => {
            estados.forEach(e => {
                const opcao = document.createElement('option');
                opcao.value = e.nome;
                opcao.textContent = e.nome;
                selEstado.appendChild(opcao);
            });
        });
}

// 2) Busca os municipios: GET /api/municipios  ou  GET /api/municipios?estado=NOME
function carregarMunicipios() {
    const estado = selEstado.value;
    const url = estado ? '/api/municipios?estado=' + encodeURIComponent(estado) : '/api/municipios';

    status.classList.remove('erro');
    status.textContent = 'Carregando...';

    fetch(url)
        .then(resposta => {
            if (!resposta.ok) throw new Error('HTTP ' + resposta.status);
            return resposta.json();
        })
        .then(dados => {
            municipios = dados;
            desenhar();
        })
        .catch(erro => {
            status.textContent = 'Não foi possível carregar os municípios (' + erro.message + ').';
            status.classList.add('erro');
        });
}

// 3) Desenha a lista (aplica a busca por nome digitada, sem novo fetch)
function desenhar() {
    const termo = semAcento(buscaNome.value.trim());
    const visiveis = termo
        ? municipios.filter(m => semAcento(m.nome).includes(termo))
        : municipios;

    const onde = selEstado.value ? 'em ' + selEstado.value : 'no Brasil';
    status.textContent = formatar(visiveis.length) + (visiveis.length === 1 ? ' município ' : ' municípios ') + onde +
        (termo ? ' com "' + buscaNome.value.trim() + '"' : '');

    if (visiveis.length === 0) {
        lista.innerHTML = '<li class="vazio">Nenhum município encontrado. Tente outro nome ou outro estado.</li>';
        return;
    }

    lista.innerHTML = visiveis.map(m =>
        '<li>' +
        '<div>' +
        '<span class="m-nome">' + esc(m.nome) + '</span>' +
        '<span class="m-info"><span>' + esc(m.estadoNome) + '</span><span>Código ' + esc(m.id) + '</span></span>' +
        '</div>' +
        '<span class="uf">' + esc(m.estadoSigla) + '</span>' +
        '</li>'
    ).join('');
}

selEstado.addEventListener('change', carregarMunicipios);
buscaNome.addEventListener('input', desenhar);
document.getElementById('limpar').addEventListener('click', () => {
    selEstado.value = '';
    buscaNome.value = '';
    carregarMunicipios();
});

// Ao abrir: carrega o combo e, se a URL tiver ?estado=Nome (vindo de estados.html), ja filtra
carregarEstados()
    .then(() => {
        const doLink = new URLSearchParams(window.location.search).get('estado');
        if (doLink) selEstado.value = doLink;
        carregarMunicipios();
    })
    .catch(erro => {
        status.textContent = 'Não foi possível carregar os estados (' + erro.message + ').';
        status.classList.add('erro');
    });
