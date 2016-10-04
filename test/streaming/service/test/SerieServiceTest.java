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
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import streaming.entity.Serie;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
public class SerieServiceTest {

    @BeforeClass
    public static void initEtList() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM Serie s WHERE s.id=" + 3L).executeUpdate();
        em.createQuery("DELETE FROM Serie s WHERE s.id=" + 4L).executeUpdate();
        em.createQuery("DELETE FROM Serie s WHERE s.id=" + 5L).executeUpdate();

        em.getTransaction().commit();
        
        //AJOUT
        em.getTransaction().begin();
        
        Serie aSuppr = new Serie();
        Serie aModifEtFind   = new Serie();
        aSuppr.setId(4L);
        aModifEtFind.setId(5L);
        
        em.persist(aSuppr);
        em.persist(aModifEtFind);
        
        em.getTransaction().commit();
        
        //test Lister
        Assert.assertEquals(4, new SerieService().liste().size());
    }

    @AfterClass
    public static void clean() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM Serie s WHERE s.id=" + 3L).executeUpdate();
        em.createQuery("DELETE FROM Serie s WHERE s.id=" + 4L).executeUpdate();
        em.createQuery("DELETE FROM Serie s WHERE s.id=" + 5L).executeUpdate();

        em.getTransaction().commit();
    }
    
    @Test
    public void ajouterOK(){
        Serie s = new Serie();
        s.setId(3L);
        s.setTitre("lalala");
        
        new SerieService().ajouter(s);
        
        Assert.assertEquals((Long) 3L, new SerieService().findByID(3L).getId());
    }
    
    @Test
    public void modifierOK(){
        Serie s = new SerieService().findByID(5L);
        
        s.setTitre("Canard");
        
        new SerieService().modifier(s);
        
        Assert.assertEquals("Canard", new SerieService().findByID(5L).getTitre());
    }
    
    @Test
    public void supprimerOK(){
        new SerieService().supprimer(4L);
        
        Assert.assertNull(new SerieService().findByID(4L));
    }
    
    @Test
    public void findByID(){
        Assert.assertNotNull(new SerieService().findByID(5L));
    }
}
