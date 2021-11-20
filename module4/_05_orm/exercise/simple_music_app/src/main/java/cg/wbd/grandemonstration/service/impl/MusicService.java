package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.service.IMusicService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class MusicService implements IMusicService {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }

    @Override
    public List<Music> findAll() {
        List<Music> musicList = entityManager.createQuery("select s from Music s", Music.class).getResultList();
        return musicList;
    }

    @Override
    public Music findById(Integer id) {
        return entityManager.find(Music.class,id);
    }

    @Override
    public void update(Music music) {

    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public void addMusic(Music music) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(music);
        entityTransaction.commit();
    }


}
