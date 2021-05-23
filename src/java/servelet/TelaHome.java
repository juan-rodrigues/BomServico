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

@WebServlet(name = "TelaHome", urlPatterns = {"/TelaHome"})
public class TelaHome extends HttpServlet {
    public String buscaAnuncios(String filtro) {
        String res = "";
        ArrayList<Anuncio> anuncios = new DalAnuncio().getAnuncioList(filtro);
        for (Anuncio anun : anuncios) {
            res += String.format("<div class='block'> <div class='block-img'> <img src='imagens/bom-eletricista.jpg' "
            + "alt='HTML5'></div><div class='block-desc'>%s"
                    + "</div><div class='block-link'>"
                    + "<a href='anuncio.jsp?id=%d'>Ver mais</a></div></div>",anun.getBreveDescri(),anun.getId());
        }

        return res;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String filtro = request.getParameter("filtro");
        if (!filtro.isEmpty()) {
            filtro = "upper(nome) like '%" + filtro.toUpperCase() + "%'";
        }
        response.getWriter().print(buscaAnuncios(filtro));

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
