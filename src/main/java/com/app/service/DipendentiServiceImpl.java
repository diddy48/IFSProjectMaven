/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Dipendenti;
import com.app.dao.DipendentiDao;

@Service("DipendentiService")//forse minuscolo dip
@Transactional
public class DipendentiServiceImpl implements DipendentiService {

    @Autowired
    private DipendentiDao dao;

    public Dipendenti findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Dipendenti findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public void saveDipedenti(Dipendenti dip) {
        dao.saveDipendenti(dip);
    }

    /*
    @Override
    public void updateDipedenti(Dipendenti dip) {
        Dipedenti entity = dao.findById(dip.getId());
        if(entity!=null){
            entity.setCategoria(dip.getCategoria());
            entity.setDescrizione(dip.getDescrizione());
        }
    }

     */
    @Override
    public void deleteDipendenti(int id) {
        dao.deleteDipendenti(id);
    }

    @Override
    public List<Dipendenti> findAll() {
        return dao.findAll();
    }

    @Override
    public Dipendenti findDipendenti(String mail, String password) {
        return dao.findDipendenti(mail, password);
    }

}
