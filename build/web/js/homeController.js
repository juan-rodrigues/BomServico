function MostraAnuncios()
{   //if(!apagou)
       event.preventDefault(); // evita refresh da tela, mas só pode ser utilizado 
                               // quando a função é chamada a partir de um evento
    var filtro=""; // verifica o filtro
    const URL_TO_FETCH='TelaHome?acao=consultar&filtro='+filtro;
    
    fetch(URL_TO_FETCH, {method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('preview').innerHTML = result;
        });
    }).catch (function(err) {console.error(err);});

}
