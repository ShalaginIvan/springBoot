package ru.shalagin.springBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.shalagin.springBoot.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        User userDelete = getById(id);
        entityManager.remove(entityManager.contains(userDelete) ? userDelete : entityManager.merge(userDelete));
    }
}
