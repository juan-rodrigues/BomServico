function AlterarUsuario(cod,nivel)
{   
    event.preventDefault(); // evita refresh da tela

    const URL_TO_FETCH = 'TelaAlteraDados';
    var formData = new FormData(document.getElementById("fdados"));
    formData.append('codigo', cod);
    formData.append('nivel', nivel);
    fetch(URL_TO_FETCH, { method: 'post', body: formData 
    }).then(function (response) {
        return response.text();
    }).then(function (retorno) {
        // result recebe a resposta do módulo dinâmico
        if (retorno.startsWith('Erro')) // problemas ao alterar/gravar
        {
            alert("erro");
        } else  // tudo OK, limpar o formulário
        {
            alert("sucesso");
            window.location.replace(".");
        }
         
    }).catch(function (error) {
        console.error(error);
    });
}

