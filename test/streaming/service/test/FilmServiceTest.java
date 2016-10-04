/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import streaming.entity.Film;
import streaming.service.FilmService;

/**
 *
 * @author admin
 */
public class FilmServiceTest {

    @BeforeClass
    public static void init() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        //Clean
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + 7L).executeUpdate();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + 8L).executeUpdate();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + 9L).executeUpdate();
        em.getTransaction().commit();

        //DEBUT Ajout
        em.getTransaction().begin();

        Film aSuppr = new Film(8L, "lalala", "kakakak", 1234, 90);
        Film aTrouvEtMod = new Film(9L, "lalala", "kakakak", 1234, 90);

        em.persist(aSuppr);
        em.persist(aTrouvEtMod);

        em.getTransaction().commit();
        //FIN Ajout
        
        List<Film> f = new FilmService().lister();
        Assert.assertEquals(6, f.size());
    }

    @AfterClass
    public static void clean(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + 7L).executeUpdate();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + 8L).executeUpdate();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + 9L).executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    public void ajouterOK() {
        Film f = new Film();
        f.setId(7L);
        f.setDuree(90);
        f.setAnnee(1980);
        f.setTitre("lalala");

        new FilmService().ajouter(f);

        assertEquals((Long) 7L, new FilmService().findByID(7L).getId());

    }

    @Test
    public void supprimer() {

        new FilmService().supprimer(8L);

        Assert.assertNull(new FilmService().findByID(8L));

    }

    @Test
    public void modifier() {

        Film f = new FilmService().findByID(9L);

        f.setTitre("P'tit Beur'");

        new FilmService().modifier(f);

        f = new FilmService().findByID(9L);

        Assert.assertEquals("P'tit Beur'", f.getTitre());
    }

    @Test
    public void find() {
        Assert.assertNotNull(new FilmService().findByID(9L));
    }

}
