
const url = "http://localhost:8081/instrumento";

const headers = {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
              mode: 'no-cors'
          };

var pages = ['page_introducao', 'page_instrumento',
             'page_instrumento_exibir', 'page_instrumento_novo',
             'page_instrumento_atualizar', 'page_upload_image'];

function showPage(currPage){
    var found = false;
    for (var i = 0; i < pages.length; i++) {
        if (pages[i] == currPage) {
            document.getElementById(pages[i]).style.display = 'block';
            found = true;
        } else {
            document.getElementById(pages[i]).style.display = 'none';
        }
    }
    if (!found) {
        document.getElementById('loginPage').style.display = 'block';
        alert('Página não encontrada:' + currPage);
    }
}

/** GET da lista de instrumentos. */
function buscarInstrumentos() {
	fetch(url)
    .then(res => res.json())
    .then(res => exibirInstrumentos(res.object))
    .catch(err => alert(err.message));
}

function exibirInstrumentos(instList) {
	var tabela = '<table class="table">';
	for (var i = 0; i < instList.length; i++) {
		var inst = instList[i];
		var linha = "<tr>" +
			"<td>"+ inst.nome + "</td>" +
			"<td>" + inst.tipo + "</td>" +
			"<td>" + inst.preco + "</td>" +
			'<td><a href="javascript:void(0)" onclick="showPage(\'page_instrumento_exibir\'); buscarInstrumento(' + inst.id + ', false)">Detalhes</button></td>' +
			'<td><a href="javascript:void(0)" onclick="showPage(\'page_instrumento_atualizar\'); buscarInstrumento(' + inst.id + ', true)">Atualizar</button></td>' +
			'<td><a href="javascript:void(0)" onclick="excluirInstrumento(' + inst.id + ')">Excluir</a></td>' +
		  "<tr>";

		tabela += linha;
	}
	tabela +="</table>";
	document.getElementById("divPrincipal").innerHTML = tabela;
}

function buscarInstrumento(id, atualizar) {
	//Busca dos dados no servidor para o ID
	fetch(url + "/" + id)
        .then(res => res.json())
        .then(res => exibirInstrumento(res.object, atualizar))
        .catch(err => alert(err.message));
}

function exibirInstrumento(inst, atualizar) {
	if (atualizar != null && atualizar) {
	    document.getElementById("atualizar_id").value = inst.id;
	    document.getElementById("atualizar_nome").value = inst.nome;
    	document.getElementById("atualizar_tipo").value = inst.tipo;
    	document.getElementById("atualizar_preco").value = inst.preco;
    	document.getElementById("atualizar_descricao").value = inst.descricao;
	} else {
        document.getElementById("exibir_nome").value = inst.nome;
        document.getElementById("exibir_tipo").value = inst.tipo;
        document.getElementById("exibir_preco").value = inst.preco;
        document.getElementById("exibir_descricao").value = inst.descricao;
	}

}


function cadastrarInstrumento() {
	var inst = {};
	inst.nome = document.getElementById("novo_nome").value;
	inst.tipo = document.getElementById("novo_tipo").value;
	inst.preco = document.getElementById("novo_preco").value;
	inst.descricao = document.getElementById("novo_descricao").value;


    fetch(url, {
        headers: headers,
        method: "POST",
        body: JSON.stringify(inst)
    })
    .then(res => res.json())
    .then(res => alert("Inserido com id:" + res.object.id))
    .then(res => {showPage('page_instrumento'); buscarInstrumentos();})
    .catch(err => alert("Erro:" + err.message))
}


function excluirInstrumento(id) {

    fetch(url + "/" + id, {
            headers: headers,
            method: "DELETE"
        })
        .then(res => res.json())
        .then(res => alert("Excluído com sucesso"))
        .then(res => { showPage('page_instrumento'); buscarInstrumentos();})
        .catch(err => alert("Erro:" + err.message))
}

function atualizarInstrumento() {
	var inst = {};
	inst.id = document.getElementById("atualizar_id").value;
	inst.nome = document.getElementById("atualizar_nome").value;
	inst.tipo = document.getElementById("atualizar_tipo").value;
	inst.preco = document.getElementById("atualizar_preco").value;
	inst.descricao = document.getElementById("atualizar_descricao").value;

    fetch(url + "/" + inst.id, {
        headers: headers,
        method: "PUT",
        body: JSON.stringify(inst)
    })
    .then(res => res.json())
    .then(res => alert("Atualizado com sucesso"))
    .then(res => {showPage('page_instrumento'); buscarInstrumentos();})
    .catch(err => alert("Erro:" + err.message))
}


function enviarNovaImagem() {
    //var form = document.getElementById("formNovaImagen");
    var singleFileUploadInput = document.getElementById("newFileId");
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
        alert("Não há arquivo selecionado");
        return;
    }
    var formData = new FormData();
    formData.append("file", files[0]);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //Voltar a página inicial.
            showPage('page_instrumento');
            buscarInstrumentos();
        }
    };
    xhttp.open('POST', '/dbimagens', true);

    var boundary = "AJAX--------------" + (new Date).getTime();
    var contentType = "multipart/form-data; boundary=" + boundary;
    xhttp.setRequestHeader("Content-Type", contentType);
    //xhttp.sendAsBinary(formData);
    xhttp.send(formData);
}


function enviarNovaImagemJQuery() {
    var singleFileUploadInput = document.getElementById("newFileId");
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
        alert("Não há arquivo selecionado");
        return;
    }


 $.ajax({
    url: "/dbimagens",
    type: "POST",
    data: new FormData($("#formNovaImagen")[0]),
    enctype: 'multipart/form-data',
    processData: false,
    contentType: false,
    cache: false,
    success: function () {
      showPage('page_instrumento');
                  buscarInstrumentos();
    },
    error: function () {
      alert("Erro no envio");
    }
  });

}