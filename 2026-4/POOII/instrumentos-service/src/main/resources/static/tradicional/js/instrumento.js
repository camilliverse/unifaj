/** JavaScripts utilizados */

const url = "http://localhost:8081/instrumento";

const headers = {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
              mode: 'no-cors'
          };

/** GET da lista de instrumentos. */
function buscarInstrumentos() {
	fetch(url)
    .then(res => res.json())
    .then(res => exibirInstrumentos(res.object))
    .catch(err => alert(err.message));
}

function exibirInstrumentos(instList) {
	var tabela = "<table>"
	   + "<tr><th>Instrumento</th><th>Tipo</th><th>Valor</th>"
	   + "<th colSpan=3>Ações</th></tr>";
	for (var i = 0; i < instList.length; i++) {
		var inst = instList[i];
		var linha = "<tr>" +
			           "<td>"+ inst.nome + "</td>" +
					   "<td>" + inst.tipo + "</td>" +
					   "<td>" + inst.preco + "</td>" +
				       '<td><a href="InstrumentoVisualizar.html?id='+ inst.id + '">Detalhes</a></td>' +
				       '<td><a href="InstrumentoAlterar.html?id='+ inst.id + '">Alterar</a></td>' +
			           '<td><button onclick="excluirInstrumento(' + inst.id + ')">Excluir</button></td>' +
					"</tr>";

		tabela += linha;
	}
	tabela +="</table>";
	document.getElementById("divPrincipal").innerHTML = tabela;
}


/** GET de 01 instrumento obtido do parêmetro da URL da página. */
function buscarInstrumento() {
	//Recuperar o ID do Instrumento
	var urlLocal = new URL(window.location.href);
	var id = urlLocal.searchParams.get("id");
	if (id == null) {
		alert("ID não encontrado.");
		return;
	}

	//Busca dos dados no servidor para o ID
	fetch(url + "/" + id)
        .then(res => res.json())
        .then(res => exibirInstrumento(res.object))
        .catch(err => alert(err.message));
}

function exibirInstrumento(inst) {
	document.getElementById("nome").value = inst.nome;
	document.getElementById("tipo").value = inst.tipo;
	document.getElementById("preco").value = inst.preco;
	document.getElementById("descricao").value = inst.descricao;
}


function cadastrarInstrumento() {
	var inst = {};
	inst.nome = document.getElementById("nome").value;
	inst.tipo = document.getElementById("tipo").value;
	inst.preco = document.getElementById("preco").value;
	inst.descricao = document.getElementById("descricao").value;

    fetch(url, {
        headers: headers,
        method: "POST",
        body: JSON.stringify(inst)
    })
    .then(res => res.json())
    .then(res => alert("Inserido com id:" + res.object.id))
    .then(res => window.location.replace("InstrumentoListar.html"))
    .catch(err => alert("Erro:" + err.message))
}


function atualizarInstrumento() {
	//Recuperar o ID do Instrumento
    	var urlLocal = new URL(window.location.href);
    	var id = urlLocal.searchParams.get("id");
    	if (id == null) {
    		alert("ID não encontrado.");
    		return;
    	}

	var inst = {};
	inst.id = id;
	inst.nome = document.getElementById("nome").value;
	inst.tipo = document.getElementById("tipo").value;
	inst.preco = document.getElementById("preco").value;
	inst.descricao = document.getElementById("descricao").value;

    fetch(url + "/" + id, {
        headers: headers,
        method: "PUT",
        body: JSON.stringify(inst)
    })
    .then(res => res.json())
    .then(res => alert("Atualizado com sucesso"))
    .then(res => window.location.replace("InstrumentoListar.html"))
    .catch(err => alert("Erro:" + err.message))
}

function excluirInstrumento(id) {
	fetch(url + "/" + id, {
            headers: headers,
            method: "DELETE"
        })
        .then(res => res.json())
        .then(res => alert("Excluído com sucesso"))
        .then(res => window.location.replace("InstrumentoListar.html"))
        .catch(err => alert("Erro:" + err.message))
}