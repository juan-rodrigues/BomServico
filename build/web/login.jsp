<%-- 
    Document   : login
    Created on : 19/05/2021, 21:39:52
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
    if (logado)
       response.sendRedirect(".");
%>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="cadastroUsuario.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/loginController.js" type="text/javascript"></script>
        <title>Entrar</title>
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
                    <li >
                        <a class="nav-link" href="/BomServico">Home</a>
                    </li>

            </div>
        </nav>
        <div class="container">

            <article class="card-body mx-auto" style="max-width: 400px;">
                <h4 class="card-title mt-3 text-center">Entrar</h4>
                <form name="dados" id="fdados" onsubmit="Login()">
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input name="email" class="form-control" placeholder="E-mail" type="email" required >
                    </div> <!-- form-group// -->
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        </div>
                        <input name="senha" class="form-control" placeholder="Senha" type="password" required>
                    </div> <!-- form-group// -->
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block"> Entrar </button>
                    </div> <!-- form-group// -->
                    <p class="text-center">Não possui conta? <a href="cadastroUsuario.jsp">Criar conta</a> </p>
                </form>
            </article>

        </div>
        <!--container end.//-->

    </body>

</html>
