/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Serie;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ModifierSerieServlet", urlPatterns = {"/modifier_serie"})
public class ModifierSerieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Serie s = new SerieService().findByID(Long.valueOf(req.getParameter("id")));
        
        req.setAttribute("maSerie", s);
        
        req.getRequestDispatcher("modifier_serie.jsp").forward(req, resp);
    }
    
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ////on crée le film
        Serie s = new SerieService().findByID(Long.valueOf(req.getParameter("id")));
        s.setTitre(req.getParameter("titre"));
        s.setSynopsis(req.getParameter("synopsis"));
        new SerieService().modifier(s);

        //On redirige l'utilisateur
        resp.sendRedirect("lister_series");
    }

}
