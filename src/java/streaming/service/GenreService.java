/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.dao.GenreDAO;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreService {

    public List<Genre> lister() {
        return new GenreDAO().lister();
    }

    public Genre findByID(Long id) {
        return new GenreDAO().findByID(id);
    }

    public void ajouter(Genre g) {
        new GenreDAO().ajouter(g);
    }

    public void supprimer(long id) {
        new GenreDAO().supprimer(id);
    }
    
    public void modifer(Genre g){
        new GenreDAO().modifier(g);
    }
}
