
package servelet;

import dal.DalAnuncio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Anuncio;

@WebServlet(name = "TelaGerenciarAnuncio", urlPatterns = {"/TelaGerenciarAnuncio"})
public class TelaGerenciarAnuncio extends HttpServlet {
    
    public String buscaAnuncio(String filtro) {
        String res = "";
        ArrayList<Anuncio> anuncios = new DalAnuncio().getAnuncioList(filtro);
        for (Anuncio anun : anuncios) {
            res += String.format("<tr>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "<td class='text-center'>"
                    + "<button type='button' onclick='ApagaAnuncio(\"apagar\",%s)' class='btn btn-danger btn-xs'>"
                    + "<span class='glyphicon glyphicon-remove'></span>"
                    + " Del</button></td>"
                    + "</tr>", "" + anun.getId(), anun.getTitulo(),anun.getUsu().getNome(),anun.getCat().getDescricao(), "" + anun.getId(), "" + anun.getId());

        }

        return res;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        String erro = "";
        DalAnuncio ctr = new DalAnuncio();
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
                    filtro = "upper(titulo) like '%" + filtro.toUpperCase() + "%'";
                }
                response.getWriter().print(buscaAnuncio(filtro));
                break;
            case "apagar":
                if (!ctr.apagar(cod)) {
                    erro = "Erro ao apagar o pais";
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
