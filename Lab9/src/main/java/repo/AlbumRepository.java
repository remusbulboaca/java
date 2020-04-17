package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    public void create(Album album) {
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        emf.close();
    }

    public List<Album> findByName(String name) {
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Album.findByName");
        q.setParameter(1, name);
        List a = q.getResultList();
        return a;

    }

    public Album findById(Integer id) {
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Album album = em.find(Album.class, id);
        return album;

    }

    public List<Album> findByArtist(Artist artist) {
        Integer artist_id = artist.getId();
        EntityManagerFactory emf = PersistenceUtil.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Album.findByArtist");
        q.setParameter(1, artist_id);
        List<Album> a = q.getResultList();

        return a;

    }
}
