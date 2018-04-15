/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.dao.UserDao;
import com.app.model.Dipendenti;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roman
 */
@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public User findByUserName(String username) {
        return dao.findByUserName(username);
    }

    @Override
    public Dipendenti findByUser(User user) {
        return dao.findByUser(user);
    }
}
