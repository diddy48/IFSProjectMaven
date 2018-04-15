package com.app.dao;

import com.app.model.Dipendenti;
import com.app.model.User;

public interface UserDao {

	User findByUserName(String username);
        Dipendenti findByUser(User user);

}