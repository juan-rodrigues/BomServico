<%-- 
    Document   : cadastroCategoria
    Created on : 19/05/2021, 21:39:23
    Author     : pedro
--%>

<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session!=null)
    {
        Usuario usuario=(Usuario)session.getAttribute("usuario");
        if (usuario!=null){
            if(usuario.getNivel()!=2)
                response.sendRedirect("index.jsp");
        }
          else
            response.sendRedirect("index.jsp");
    }
    
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="cadastroCategoria.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/cadastroCategoriaController.js" type="text/javascript"></script>
        <script src="js/sairController.js" type="text/javascript"></script>
        <title>Categorias</title>
    </head>
    <body onload="MostraCategoria()" >
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href=".">BomServiço</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado"
                    aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
                <ul class="navbar-nav mr-auto">
                    <li>
                        <a class="nav-link" href=".">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastroAnuncio.jsp">Anuncie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="alteraUsuario.jsp">Alterar dados</a>
                    </li>
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Gerenciar
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item active" href="cadastroCategoria.jsp">Gerenciar Categoria</a>
                            <a class="dropdown-item" href="gerenciarAnuncios.jsp">Gerenciar Anuncios</a>
                        </div>
                    </li>
                </ul>
                <a class="nav-link" onclick="Logout()" href=".">Sair</a>
            </div>
        </nav>

        <div class="container espaco">
            <form name="dados" id="fdados" onsubmit="GravaCategoria()">
                <div class="col-sm-12">
                    <div class="form-group">
                        <label>Código</label>
                        <input type="text" placeholder="Coloque o código aqui caso queira alterar..." name="cod" value="" class="form-control">
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="form-group">
                        <label>Categoria</label>
                        <input type="text" name="nome" placeholder="Coloque a categoria aqui..." value="" class="form-control" required>
                    </div>
                </div>
                <center>

                    <button type="submit" class="btn btn-primary btn-xs pull-right" ><b>+</b> Add new categories</button>
                </center>
            </form>
            <div class="row  col-md-offset-2 custyle">
                <table class="table table-striped custab">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Categoria</th>
                            <th class="text-center">Ação</th>
                        </tr>
                    </thead>
                    <tbody id="preview">
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
