/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;
import streaming.entity.Genre;
import streaming.service.GenreService;

/**
 *
 * @author admin
 */
public class GenreServiceTest {

    @BeforeClass
    public static void initEtList() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM Genre g WHERE g.id=" + 6L).executeUpdate();
        em.createQuery("DELETE FROM Genre g WHERE g.id=" + 7L).executeUpdate();
        em.createQuery("DELETE FROM Genre g WHERE g.id=" + 8L).executeUpdate();

        em.getTransaction().commit();

        //AJOUT
        em.getTransaction().begin();

        Genre aSuppr = new Genre();
        Genre aModifEtFind = new Genre();
        aSuppr.setId(7L);
        aModifEtFind.setId(8L);

        em.persist(aSuppr);
        em.persist(aModifEtFind);

        em.getTransaction().commit();

        //test Lister
        Assert.assertEquals(7, new GenreService().lister().size());
    }

    @AfterClass
    public static void clean() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM Genre g WHERE g.id=" + 6L).executeUpdate();
        em.createQuery("DELETE FROM Genre g WHERE g.id=" + 7L).executeUpdate();
        em.createQuery("DELETE FROM Genre g WHERE g.id=" + 8L).executeUpdate();

        em.getTransaction().commit();
    }

    @Test
    public void ajouterOK() {
        Genre g = new Genre();
        g.setId(6L);
        g.setNom("LALALA");

        new GenreService().ajouter(g);

        Assert.assertEquals((Long) 6L, new GenreService().findByID(6L).getId());
    }

    @Test
    public void modifierOK() {
        Genre g = new GenreService().findByID(8L);

        g.setNom("Canard");

        new GenreService().modifer(g);

        Assert.assertEquals("Canard", new GenreService().findByID(8L).getNom());
    }

    @Test
    public void supprimerOK() {
        new GenreService().supprimer(7L);

        Assert.assertNull(new GenreService().findByID(7L));
    }

    @Test
    public void findByID() {
        Assert.assertNotNull(new GenreService().findByID(8L));
    }

}
