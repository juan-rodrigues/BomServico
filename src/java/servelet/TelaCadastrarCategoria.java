package servelet;

import dal.DalCategoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categoria;

@WebServlet(name = "TelaCadastrarCategoria", urlPatterns = {"/TelaCadastrarCategoria"})
public class TelaCadastrarCategoria extends HttpServlet {

    public String buscaCategoria(String filtro) {
        String res = "";
        ArrayList<Categoria> categorias = new DalCategoria().getCategoriaList(filtro);
        for (Categoria cat : categorias) {
            res += String.format("<tr>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "<td class='text-center'>"
                    + "<button type='button' onclick='ApagaAlteraCategoria(\"alterar\",%s)' class='btn btn-info btn-xs' >"
                    + "<span class='glyphicon glyphicon-edit'></span> Edit</button> "
                    + "<button type='button' onclick='ApagaAlteraCategoria(\"apagar\",%s)' class='btn btn-danger btn-xs'>"
                    + "<span class='glyphicon glyphicon-remove'></span>"
                    + " Del</button></td>"
                    + "</tr>", "" + cat.getId(), cat.getDescricao(), "" + cat.getId(), "" + cat.getId());

        }

        return res;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        String erro = "";
        DalCategoria ctr = new DalCategoria();
        erro = "ok";
        int cod;
        try {
            cod = Integer.parseInt(request.getParameter("cod"));
        } catch (Exception e) {
            cod = 0;
        }
        switch (acao.toLowerCase()) {
            case "consultar":
                String filtro = request.getParameter("filtro");
                if (!filtro.isEmpty()) {
                    filtro = "upper(nome) like '%" + filtro.toUpperCase() + "%'";
                }
                response.getWriter().print(buscaCategoria(filtro));
                break;
            case "apagar":
                if (!ctr.apagar(cod)) {
                    erro = "Erro ao apagar o pais";
                }
                response.getWriter().print(erro);
                break;
            case "alterar":
                Categoria p = ctr.getCategoria(cod);
                response.getWriter().print(p); // retorna todos os dados na forma de lista (,,,)
                break;
            case "confirmar": //novo e alteração
                erro = "ok";
                String nome = request.getParameter("nome");
                Categoria cat = new Categoria(cod, nome);
                if (cod == 0) {
                    if (!ctr.salvar(cat)) {
                        erro = "Erro ao gravar a categoria";
                    }
                } else {
                    if (!ctr.alterar(cat)) {
                        erro = "Erro ao alterar a categoria";
                    }
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
