package repo;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import entity.Album;
import entity.Artist;

import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;


public class ArtistRepository {
    public void create(Artist artist) {
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        emf.close();
    }

    public List<Artist> findByName(String name) {
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Artist.findByName");
        q.setParameter(1, name);
        List a = q.getResultList();
        return a;

    }

    public Artist findById(Integer id) {
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Artist artist = em.find(Artist.class, id);
        return artist;
    }


}
