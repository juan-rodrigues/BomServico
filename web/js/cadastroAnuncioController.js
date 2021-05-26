function MostrarCategorias()
{
    event.preventDefault(); // evita refresh da tela, mas só pode ser utilizado 
                               // quando a função é chamada a partir de um evento
    const URL_TO_FETCH='TelaCadastrarAnuncio?acao=consultar';
    
    fetch(URL_TO_FETCH, {method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('preview').innerHTML = result;
        });
    }).catch (function(err) {console.error(err);});
}



function GravaAnuncio()
{
    event.preventDefault(); // evita refresh da tela

    const URL_TO_FETCH = 'TelaCadastrarAnuncio';
    
    const data = new URLSearchParams();
    for (const pair of new FormData(document.getElementById('fdados'))) {
        data.append(pair[0], pair[1]);
    }
    data.append('acao', 'confirmar');
    fetch(URL_TO_FETCH, { method: 'post', body: data 
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

