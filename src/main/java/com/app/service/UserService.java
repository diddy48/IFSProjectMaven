/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Dipendenti;
import com.app.model.User;
import java.util.List;

/**
 *
 * @author roman
 */
public interface UserService {

    User findByUserName(String username);
    Dipendenti findByUser(User user);
}
