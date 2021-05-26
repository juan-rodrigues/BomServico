<%-- 
    Document   : cadastroUsuario
    Created on : 19/05/2021, 21:39:13
    Author     : pedro
--%>

<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    boolean logado = false;
    Usuario usu = null;
    if (session != null) {
        usu = (Usuario) session.getAttribute("usuario");
        if (usu != null) {
            logado = true;
        }
    }
    if (!logado) {
        response.sendRedirect(".");
    }
%>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="cadastroUsuario.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/alteraDadosController.js" type="text/javascript"></script>
        <script src="js/sairController.js" type="text/javascript"></script>
        <title>Criar Conta</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href=".">BomServiço</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado"
                    aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href=".">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastroAnuncio.jsp">Anuncie</a>
                    </li>
                    <%if (logado == true) {%>
                    <li class="nav-item active">
                        <a class="nav-link" href="alteraUsuario.jsp">Alterar dados</a>
                    </li>
                    <%}%>
                    <%if (logado == true) {
                            Usuario usuario = (Usuario) session.getAttribute("usuario");
                            if (usuario.getNivel() == 2) {
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
                    <%}
                        }%>
                </ul>
                <%if (logado == true) {%>
                <a class="nav-link" onclick="Logout()" href=".">Sair</a>
                <%}%>
                <%if (logado == false) {%>
                <a class="nav-link" href="login.jsp">Logar</a>
                <%}%>
            </div>
        </nav>
        <div class="container">

            <article class="card-body mx-auto" style="max-width: 400px;">
                <h4 class="card-title mt-3 text-center">Alterar Dados</h4>
                <form name="dados" id="fdados" onsubmit="AlterarUsuario(<%out.println(usu.getId());%>,<%out.println(usu.getNivel());%>)" >
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        </div>
                        <input name="nome" class="form-control" value="<%out.println(usu.getNome());%>" placeholder="Nome Completo" type="text" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="email" class="form-control" value="<%out.println(usu.getEmail());%>" placeholder="E-mail" type="email" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="CPF" class="form-control" value="<%out.println(usu.getCPF());%>" placeholder="CPF" type="text" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="telefone" class="form-control" value="<%out.println(usu.getTelefone());%>" placeholder="Telefone" type="tel" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="CEP" class="form-control" value="<%out.println(usu.getCEP());%>" placeholder="CEP" type="text" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-building"></i> </span>
                        </div>
                        <select name="estado" class="form-control">
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
                    </div> <!-- form-group end.// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="cidade" class="form-control" value="<%out.println(usu.getCidade());%>" placeholder="Cidade" type="text" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="endereco" class="form-control" value="<%out.println(usu.getEndereco());%>" placeholder="endereco" type="text" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="numero" class="form-control" value="<%out.println(usu.getNumero());%>" placeholder="numero" type="text" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="complemento" class="form-control" value="<%out.println(usu.getComplemento());%>"  placeholder="complemento" type="text" required>
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <input name="senha" class="form-control" value="<%out.println(usu.getSenha());%>" placeholder="Nova Senha" type="password" required>
                    </div> <!-- form-group// -->
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block"> Alterar dados </button>
                    </div> <!-- form-group// -->
                </form>
            </article>

        </div>

    </body>

</html>
