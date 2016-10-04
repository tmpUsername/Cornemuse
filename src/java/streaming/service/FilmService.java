/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmService {
    
    public List<Film> lister(){
        return new FilmDAO().listerFilms();
    }
    
    public  void ajouter(Film f){
        new FilmDAO().ajouter(f);
    }
    
    public void ajouter(List<Film> films){
        FilmDAO dao = new FilmDAO();
        
        films.forEach(film -> {
            if (film.getTitre().length() > 0){
                    dao.ajouter(film);
            }
        });
    }
    
    public void supprimer(long id){
        new FilmDAO().supprimer(id);
    }
    
    public Film findByID(long id){
        return new FilmDAO().findByID(id);
    }
    
    public void modifier(Film f){
        new FilmDAO().modifier(f);
    }
}