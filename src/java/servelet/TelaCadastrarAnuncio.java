package servelet;

import dal.DalAnuncio;
import dal.DalCategoria;
import dal.DalUsuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.Anuncio;
import models.Categoria;
import models.Usuario;

@MultipartConfig(
    location="/",
    fileSizeThreshold=1024*1024,    // 1MB *      
    maxFileSize=1024*1024*100,      // 100MB **
    maxRequestSize=1024*1024*10*10  // 100MB ***
)

@WebServlet(name = "TelaCadastrarAnuncio", urlPatterns = {"/TelaCadastrarAnuncio"})
public class TelaCadastrarAnuncio extends HttpServlet {

    public String buscaCategoria() {
        String res = "";
        res += String.format("<label for='exampleFormControlSelect1'>Categoria</label>"
                    + "<select name='categoria' class='form-control' id='exampleFormControlSelect1'>"
            );
        ArrayList<Categoria> categorias = new DalCategoria().getCategoriaList("");
        for (Categoria cat : categorias) {
            res += String.format("<option>%s</option>",cat.getDescricao());
        }
        res += String.format("</select>");
        return res;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String erro = "";
        String acao = request.getParameter("acao");
        int cod = 0;

        DalAnuncio ctr = new DalAnuncio();
        switch (acao.toLowerCase()) {
            case "consultar":
                response.getWriter().print(buscaCategoria());
                break;
            case "confirmar": //novo e alteração
                erro = "ok";
                String titulo = request.getParameter("titulo");
                String descricao = request.getParameter("descricao");
                String brevedesc = request.getParameter("brevedesc");
                String estado = request.getParameter("estado");
                String cidade = request.getParameter("cidade");
                String dia = request.getParameter("dia");
                String horario = request.getParameter("horario");
                String preco = request.getParameter("preco");
                Part foto1 = request.getPart("imagem1");
                Part foto2 = request.getPart("imagem2");
                Part foto3 = request.getPart("imagem3");
                byte[] imagem1=new byte[(int)foto1.getSize()];
                byte[] imagem2=new byte[(int)foto2.getSize()];
                byte[] imagem3=new byte[(int)foto3.getSize()];
                foto1.getInputStream().read(imagem1);
                foto2.getInputStream().read(imagem2);
                foto3.getInputStream().read(imagem3);
                String imagem1name = foto1.getSubmittedFileName();
                String imagem2name = foto2.getSubmittedFileName();
                String imagem3name = foto3.getSubmittedFileName();
                FileOutputStream arquivo1 = new FileOutputStream(new File(getServletContext().getRealPath("/") + "imagens/" + foto1.getSubmittedFileName()));
                arquivo1.write(imagem1);
                arquivo1.close();
                FileOutputStream arquivo2 = new FileOutputStream(new File(getServletContext().getRealPath("/") + "imagens/" + foto2.getSubmittedFileName()));
                arquivo2.write(imagem2);
                arquivo2.close();
                FileOutputStream arquivo3 = new FileOutputStream(new File(getServletContext().getRealPath("/") + "imagens/" + foto3.getSubmittedFileName()));
                arquivo3.write(imagem3);
                arquivo3.close();

                
                Usuario usu = (Usuario)request.getSession().getAttribute("usuario");
                DalCategoria ctrcat= new DalCategoria();
                String categoria = request.getParameter("categoria");
                Categoria cat = ctrcat.getCategoriaNome(categoria);
                Anuncio anun = new Anuncio(cod, usu, cat, titulo, descricao, brevedesc,
                        estado, cidade, dia, horario, preco, imagem1name, imagem2name, imagem3name);
                if (!ctr.salvar(anun)) {
                    erro = "Erro ao gravar o anuncio";
                }

                response.getWriter().print(erro);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
