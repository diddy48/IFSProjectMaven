/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;
 
import java.util.List;
 
import com.app.model.Dipendenti;
 
public interface DipendentiService {
    Dipendenti findById(int id);
    Dipendenti findByUsername(String username);
    void saveDipedenti(Dipendenti dip);
    void deleteDipendenti(int id);
    Dipendenti findDipendenti(String mail,String password);
    /*void updateDipedenti(Dipendenti dip);*/
    List<Dipendenti> findAll(); 
}