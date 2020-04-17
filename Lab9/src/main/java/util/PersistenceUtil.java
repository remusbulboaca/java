package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class PersistenceUtil {
    private static final String DB_PU = "MusicAlbumsPU";
    public static final boolean DEBUG = true;
    public static final PersistenceUtil singleton = new PersistenceUtil();
    private EntityManagerFactory emf;

    private PersistenceUtil() {
    }

    public static PersistenceUtil getInstance() {
        return singleton;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(DB_PU);
        }
        if (DEBUG) {
            System.out.println("Factory created on" + new Date());
        }
        return emf;
    }

    public void closeEmf() {
        if (emf.isOpen() || emf != null) {
            emf.close();
        }
        emf = null;
        if (DEBUG) {
            System.out.println("EMF closed at:" + new Date());
        }
    }
}
