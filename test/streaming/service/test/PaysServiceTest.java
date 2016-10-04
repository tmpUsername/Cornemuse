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
import streaming.entity.Pays;
import streaming.service.PaysService;

/**
 *
 * @author admin
 */
public class PaysServiceTest {

    @BeforeClass
    public static void initEtList() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM Pays p WHERE p.id=" + 4L).executeUpdate();
        em.createQuery("DELETE FROM Pays p WHERE p.id=" + 5L).executeUpdate();
        em.createQuery("DELETE FROM Pays p WHERE p.id=" + 6L).executeUpdate();

        em.getTransaction().commit();

        //AJOUT
        em.getTransaction().begin();

        Pays aSuppr = new Pays();
        Pays aModifEtFind = new Pays();
        aSuppr.setId(5L);
        aModifEtFind.setId(6L);

        em.persist(aSuppr);
        em.persist(aModifEtFind);

        em.getTransaction().commit();

        //test Lister
        Assert.assertEquals(5, new PaysService().lister().size());
    }

    @AfterClass
    public static void clean() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM Pays p WHERE p.id=" + 4L).executeUpdate();
        em.createQuery("DELETE FROM Pays p WHERE p.id=" + 5L).executeUpdate();
        em.createQuery("DELETE FROM Pays p WHERE p.id=" + 6L).executeUpdate();

        em.getTransaction().commit();
    }

    @Test
    public void ajouterOK() {
        Pays p = new Pays();
        p.setId(4L);
        p.setNom("LALALA");

        new PaysService().ajouter(p);

        Assert.assertEquals((Long) 4L, new PaysService().findByID(4L).getId());
    }

    @Test
    public void modifierOK() {
        Pays p = new PaysService().findByID(6L);

        p.setNom("Canard");

        new PaysService().modifer(p);

        Assert.assertEquals("Canard", new PaysService().findByID(6L).getNom());
    }

    @Test
    public void supprimerOK() {
        new PaysService().supprimer(5L);

        Assert.assertNull(new PaysService().findByID(5L));
    }

    @Test
    public void findByID() {
        Assert.assertNotNull(new PaysService().findByID(6L));
    }

}
