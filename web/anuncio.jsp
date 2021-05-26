<%-- 
    Document   : anuncio
    Created on : 21/05/2021, 17:13:22
    Author     : pedro
--%>

<%@page import="dal.DalAnuncio"%>
<%@page import="models.Anuncio"%>
<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    boolean logado = false;
    Anuncio anun = new DalAnuncio().getAnuncio(Integer.parseInt(request.getParameter("id")));
    if (session != null) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            logado = true;
        }
    }
%>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="anuncio.css">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="js/sairController.js" type="text/javascript"></script>
        <script src="js/anuncioController.js" type="text/javascript"></script>

        <title>Anuncio</title>
    </head>

    <body>
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href=".">BomServiço</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado"
                    aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href=".">Home <span class="sr-only">(página atual)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastroAnuncio.jsp">Anuncie</a>
                    </li>
                    <%if (logado == true) {%>
                    <li class="nav-item">
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
        <div class="pd-wrap">
            <div class="container">
                <div class="heading-section">
                    <h2><%out.println(anun.getTitulo());%></h2>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div id="slider" class="owl-carousel product-slider espaco">
                            <div class="item">
                                <img
                                    src="imagens/<%out.println(anun.getImagen1());%>" />
                            </div>
                            <div class="item">
                                <img src="imagens/<%out.println(anun.getImagen2());%>" />
                            </div>
                            <div class="item">
                                <img
                                    src="imagens/<%out.println(anun.getImagen3());%>" />
                            </div>
                        </div>
                        <div id="thumb" class="owl-carousel product-thumb">
                            <div class="item">
                                <img
                                    src="imagens/<%out.println(anun.getImagen1());%>" />
                            </div>
                            <div class="item">
                                <img src="imagens/<%out.println(anun.getImagen2());%>" />
                            </div>
                            <div class="item">
                                <img
                                    src="imagens/<%out.println(anun.getImagen3());%>" />
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="product-dtl">
                            <div class="product-info">
                                <div class="product-name">Prestador:<%out.println(anun.getUsu().getNome());%></div>

                                <div class="product-price-discount"><span><%out.println(anun.getPreco());%></span></div>
                            </div>
                            <p><%out.println(anun.getBreveDescri());%></p>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Estado</label>
                                    <p><%out.println(anun.getEstado());%></p>
                                </div>
                                <div class="col-md-6">
                                    <label>Cidade</label>
                                    <p><%out.println(anun.getCidade());%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Dias da semana</label>
                                    <p><%out.println(anun.getDia());%></p>
                                </div>
                                <div class="col-md-6">
                                    <label>Horário</label>
                                    <p><%out.println(anun.getHorario());%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Telefone</label>
                                    <p><%out.println(anun.getUsu().getTelefone());%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product-info-tabs">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="description-tab" data-toggle="tab" href="#description" role="tab"
                               aria-controls="description" aria-selected="true">Descrição</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="review-tab" data-toggle="tab" href="#duvida" role="tab"
                               aria-controls="review" aria-selected="false">Dúvidas (0)</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="description" role="tabpanel"
                             aria-labelledby="description-tab">
                            <%out.println(anun.getDescricao());%>
                        </div>
                        <div class="tab-pane fade" id="duvida" role="tabpanel" aria-labelledby="review-tab">
                            <div class="review-heading">Duvidas</div>
                            <p class="mb-20">Seja o primeiro a perguntar.</p>
                            <form class="review-form">
                                <div class="form-group">
                                    <label>Sua Mensagem</label>
                                    <textarea class="form-control" rows="10"></textarea>
                                </div>
                                <button type="submit" class="round-black-btn">Enviar</button>
                            </form>
                        </div>
                    </div>
                </div>
                <%if (logado) {
                        Usuario usuario = (Usuario) session.getAttribute("usuario");
                        if (usuario.getId() == anun.getUsu().getId()) {
                %>
                <button type="button" onclick="Alterar(<%out.println(anun.getId());%>)" class="btn btn-warning btn_alterar">Editar</button>
                <button type="button" onclick="Deletar(<%out.println(anun.getId());%>)" class="btn btn-danger btn_deletar">Deletar</button>
                <%}
                    }%>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/anuncio.js"></script>
    </body>

</html>