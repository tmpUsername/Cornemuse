/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Genre;
import streaming.entity.Pays;

/**
 *
 * @author admin
 */
public class PaysDAO {
     public List<Pays> lister(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT p FROM Pays p ORDER BY p.nom").getResultList();
    }

    public Pays findByID(Long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.find(Pays.class, id);
    }
    
    public void ajouter(Pays p) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        em.persist(p);
        
        em.getTransaction().commit();
        
    }
    
    public void supprimer(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Pays p WHERE p.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public void modifier(Pays p){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
}
