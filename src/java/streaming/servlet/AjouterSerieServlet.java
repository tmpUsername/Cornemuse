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
import streaming.entity.Genre;
import streaming.entity.Serie;
import streaming.service.GenreService;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterSerieServlet", urlPatterns = {"/ajouter_series"})
public class AjouterSerieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listeGenres", new GenreService().lister());
        req.getRequestDispatcher("ajouter_series.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ////on crée le film
        Serie s = new Serie();
        Genre g = new GenreService().findByID(Long.valueOf(req.getParameter("genreID")));
        s.setTitre(req.getParameter("titre"));
        s.setSynopsis(req.getParameter("synopsis"));
        s.setGenre(g);
        g.getSeries().add(s);
        new SerieService().ajouter(s);

        //On redirige l'utilisateur
        resp.sendRedirect("lister_series");
    }

}
