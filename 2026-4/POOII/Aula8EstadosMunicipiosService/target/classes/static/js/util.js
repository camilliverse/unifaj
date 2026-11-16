// Funcoes auxiliares usadas pelas paginas (o fetch fica em cada pagina)

// Evita que texto vindo do JSON seja interpretado como HTML
function esc(texto) {
    return String(texto).replace(/[&<>"']/g, function (c) {
        return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' }[c];
    });
}

// 5570 -> "5.570"
function formatar(numero) {
    return Number(numero).toLocaleString('pt-BR');
}

// "São Paulo" -> "sao paulo" (busca sem se preocupar com acento e maiuscula)
function semAcento(texto) {
    return String(texto).normalize('NFD').replace(/[\u0300-\u036f]/g, '').toLowerCase();
}

// Se a pagina foi aberta clicando no arquivo (file://) ou pela previa da IDE (porta 63342),
// a API do Spring nao responde. Mostra um aviso com o endereco correto.
(function avisarSeForaDoServidor() {
    const foraDoServidor = location.protocol === 'file:' || location.port === '63342';
    if (!foraDoServidor) return;
    const aviso = document.createElement('div');
    aviso.className = 'aviso-servidor';
    aviso.textContent = 'Abra esta página pelo servidor Spring: http://localhost:8080/' +
        (location.pathname.split('/').pop() || 'index.html');
    document.body.prepend(aviso);
})();
