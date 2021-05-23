function MostraCategoria(apagou=false)
{   if(!apagou)
       event.preventDefault(); // evita refresh da tela, mas só pode ser utilizado 
                               // quando a função é chamada a partir de um evento

    var filtro=""; // verifica o filtro
    const URL_TO_FETCH='TelaCadastrarCategoria?acao=consultar&filtro='+filtro;
    fetch(URL_TO_FETCH, {method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            // result contém a resposta do módulo dinâmico
            document.getElementById('preview').innerHTML = result;
        });
    }).catch (function(err) {console.error(err);});

}

function ApagaAlteraCategoria(acao, cod)
{   //event.preventDefault(); // evita refresh da tela
    var url = "";
    switch (acao)
    {
        case "apagar":
            url = "TelaCadastrarCategoria?acao=apagar&cod=" + cod;
            break;
        case "alterar":
            url = "TelaCadastrarCategoria?acao=alterar&cod=" + cod;
            break;
    } 
    fetch(url,{method:'get'/*opcional*/}).then(function(response)
    {
        response.text().then(function(result)  //response é um promisse
        {
            if (acao === 'apagar')
            {
                MostraCategoria(true);
            } else
            {  
                var aux = result;
                var cat = aux.split(",");
                var form = document.forms["dados"];
                form.cod.value = cat[0];
                form.nome.value = cat[1];
            }
        });
    }).catch (function(err) {console.error(err);});

}

function GravaCategoria()
{
    event.preventDefault(); // evita refresh da tela
    const URL_TO_FETCH = 'TelaCadastrarCategoria';
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
            alert(retorno);
        } else  // tudo OK, limpar o formulário
        {
            MostraCategoria(true);
            document.getElementById('fdados').reset();
            alert("Sucesso");
        }
         
    }).catch(function (error) {
        console.error(error);
    });
      
}


