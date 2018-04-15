package com.app.dao;

import com.app.model.Dipendenti;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Dipendenti findByUser(User user) {
        return (Dipendenti) getSession().createCriteria(Dipendenti.class).add(Restrictions.eq("username", user.getUsername())).uniqueResult();
    }

}
