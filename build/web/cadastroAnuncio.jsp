<%-- 
    Document   : cadastroAnuncio
    Created on : 19/05/2021, 21:39:30
    Author     : pedro
--%>

<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    boolean logado=false;
    if (session!=null)
    {
        Usuario usuario=(Usuario)session.getAttribute("usuario");
        if (usuario!=null)
            logado=true;
    }
    if (!logado)
       response.sendRedirect("login.jsp");
%>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="cadastroAnuncio.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/cadastroAnuncioController.js" type="text/javascript"></script>
        <script src="js/sairController.js" type="text/javascript"></script>
        <title>Anunciar</title>
    </head>

    <body onload="MostrarCategorias()">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href=".">BomServiço</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado"
                    aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
                <ul class="navbar-nav mr-auto">
                    <li >
                        <a class="nav-link" href=".">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="cadastroAnuncio.jsp">Anuncie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="alteraUsuario.jsp">Alterar dados</a>
                    </li>
                    
                    <%if (logado == true){
                            Usuario usuario = (Usuario) session.getAttribute("usuario");
                            if(usuario.getNivel()==2){
                        %>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Gerenciar
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="cadastroCategoria.jsp">Gerenciar Categoria</a>
                            <a class="dropdown-item" href="gerenciarAnuncios.jsp">Gerenciar Anuncios</a>
                        </div>
                    </li>
                    <%}}%>
                </ul>
                <a class="nav-link" onclick="Logout()" href=".">Sair</a>
            </div>
        </nav>



        <div class="container">
            <h1 class="well">Novo Anuncio</h1>
            <div class="col-lg-12 well">
                <div class="row">
                    <form name="dados"  method="POST" id="fdados" onsubmit="GravaAnuncio()" enctype="multipart/form-data">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label>Título</label>
                                <input type="text" name="titulo" placeholder="Coloque o título aqui..." class="form-control" required>
                            </div>
                            <div id="preview" class="form-group">
                            </div>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label for="exampleFormControlSelect1">Estado</label>
                                    <select name="estado"  class="selectteste form-control" id="exampleFormControlSelect1">
                                        <option>AC</option>
                                        <option>AL</option>
                                        <option>AP</option>
                                        <option>AM</option>
                                        <option>BA</option>
                                        <option>CE</option>
                                        <option>DF</option>
                                        <option>ES</option>
                                        <option>Go</option>
                                        <option>MA</option>
                                        <option>MT</option>
                                        <option>MS</option>
                                        <option>MG</option>
                                        <option>PA</option>
                                        <option>PB</option>
                                        <option>PR</option>
                                        <option>PE</option>
                                        <option>PI</option>
                                        <option>RJ</option>
                                        <option>RN</option>
                                        <option>RS</option>
                                        <option>RO</option>
                                        <option>RR</option>
                                        <option>SC</option>
                                        <option>SP</option>
                                        <option>SE</option>
                                        <option>TO</option>
                                    </select>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label>Cidade</label>
                                    <input type="text" name="cidade"  placeholder="Santos" class="form-control" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4 form-group">
                                    <label>Dia da Semana</label>
                                    <input type="text" name="dia"  placeholder="Segunda a sexta" class="form-control" required>
                                </div>
                                <div class="col-sm-4 form-group">
                                    <label>Hórario</label>
                                    <input type="text" name="horario"  placeholder="00:00 a 23:59" class="form-control" required>
                                </div>
                                <div class="col-sm-4 form-group">
                                    <label>Preço</label>
                                    <input type="text" name="preco"  placeholder="100R$" class="form-control" required>
                                </div>
                            </div>
                            <label>Imagens</label>
                            <div class="form-group">
                                    <input type="file" id="imagem1" name="imagem1" accept="image/*">
                            </div>
                            <div class="form-group">
                                    <input type="file" id="imagem2" name="imagem2" accept="image/*">
                            </div>
                            <div class="form-group">
                                    <input type="file" id="imagem3" name="imagem3" accept="image/*">
                            </div>
                            <div class="form-group">
                                <label>Breve Descrição</label>
                                <textarea name="brevedesc" placeholder="Breve Descrição..." maxlength="199" rows="3" class="form-control"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Descrição</label>
                                <textarea name="descricao" placeholder="Descrição..." maxlength="1001" rows="6" class="form-control"></textarea>
                            </div>
                            <button type="submit" class="btn btn-lg btn-info">Finalizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>

</html>
