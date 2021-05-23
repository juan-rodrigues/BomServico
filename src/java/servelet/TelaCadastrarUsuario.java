package servelet;

import dal.DalUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Usuario;

@WebServlet(name = "TelaCadastrarUsuario", urlPatterns = {"/TelaCadastrarUsuario"})
public class TelaCadastrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String erro = "";
        int cod = 0;
        

        DalUsuario ctr = new DalUsuario();
        erro = "ok";
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String CEP = request.getParameter("CEP");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String CPF = request.getParameter("CPF");
        String senha = request.getParameter("senha");
        String nivel = "1";
        Usuario usu = new Usuario(cod, nome, email, telefone, CEP, estado,
                cidade, endereco, numero, complemento, CPF, senha, Integer.parseInt(nivel));
        if (!ctr.salvar(usu)) {
            erro = "Erro ao criar conta";
        }
        if(!erro.startsWith("Erro"))
        {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usu);
        }

        response.getWriter().print(erro);

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
