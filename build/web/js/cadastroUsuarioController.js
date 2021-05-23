function GravaUsuario()
{
    event.preventDefault(); // evita refresh da tela
    const URL_TO_FETCH = 'TelaCadastrarUsuario';
    const data = new URLSearchParams();
    for (const pair of new FormData(document.getElementById('fdados'))) {
        data.append(pair[0], pair[1]);
    }
    fetch(URL_TO_FETCH, { method: 'post', body: data 
    }).then(function (response) {
        return response.text();
    }).then(function (retorno) {
        // result recebe a resposta do módulo dinâmico
        
        if (retorno.startsWith('Erro')) // problemas ao alterar/gravar
        {
            alert("Erro ao criar conta");
        } else  // tudo OK, limpar o formulário
        {
            window.location.replace(".");
        }
         
    }).catch(function (error) {
        console.error(error);
    });
      
}

