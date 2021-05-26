function Deletar(id) {
    if (confirm("Tem Certeza que deseja deletar?")) {
        var url = "TelaAnuncio?acao=apagar&id=" + id;
        fetch(url, {method: 'get'/*opcional*/}).then(function (response)
        {
            response.text().then(function (result)  //response é um promisse
            {
                if (result.startsWith('Erro')) 
                {
                    alert("Erro ao deletar o anuncio");
                } else 
                {
                    alert("Anuncio deletado com sucesso");
                    window.location.replace(".");
                }
                window.location.replace(".");
            });
        }).catch(function (err) {
            console.error(err);
        });
    } else {
        
    }
}
function Alterar(id) {

}
