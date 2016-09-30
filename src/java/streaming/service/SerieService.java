/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.dao.SerieDAO;
import streaming.entity.Film;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public class SerieService {
    
    public List<Serie> liste() {
        return new SerieDAO().listerSerie();
    }
    
    public  void ajouter(Serie s){
        new SerieDAO().ajouter(s);
    }
    
    public void supprimer(long id){
        new SerieDAO().supprimer(id);
    }
    
    public Serie findByID(long id){
        return new SerieDAO().findByID(id);
    }
    
    public void modifier(Serie s){
        new SerieDAO().modifier(s);
    }
}
