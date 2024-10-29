package ru.shalagin.springBoot.dao;

import ru.shalagin.springBoot.model.User;

import java.util.List;

public interface UserDao {
    public User getById(Long id);

    public List<User> getAll();

    public void save (User user);

    public void update(User user);

    public void delete(Long id);
}
