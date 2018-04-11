/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.NC;
import java.util.List;

/**
 *
 * @author roman
 */
public interface NCService {
    NC findById(int id);
    void saveNC(NC nc);
    void deleteNC(int id);/*
    void updateDipedenti(NC dip);*/
    List<NC> findNCbyFase(String fase);
    List<NC> findNCResponsabileById(int id);
    List<NC> findNCAppartenereById(int id);
    List<NC> findAll(); 
}
