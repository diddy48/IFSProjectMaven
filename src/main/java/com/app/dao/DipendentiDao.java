/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.Dipendenti;
import java.util.List;

/**
 *
 * @author mary
 */
public interface DipendentiDao {
    Dipendenti findById(int id);
    Dipendenti findByUsername(String username);
    Dipendenti findDipendenti(String mail,String password);
    void saveDipendenti(Dipendenti dip);
    void deleteDipendenti(int id);
    List<Dipendenti> findAll();
}
