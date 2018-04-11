/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author roman
 */
@Embeddable
public class PKAppartenere implements Serializable{

    //@JoinColumn(name="Matricola", nullable=false) //length = 6
    private Dipendenti membro;

    //@JoinColumn(name="NumeroNC", nullable=false)//length = 5
    private NC nc;

    public PKAppartenere() {
    }

    @ManyToOne(fetch= LAZY, cascade = CascadeType.ALL)
    public Dipendenti getMembro() {
        return membro;
    }

    public void setMembro(Dipendenti membro) {
        this.membro = membro;
    }

    @ManyToOne(fetch= LAZY,cascade = CascadeType.ALL)
    public NC getNc() {
        return nc;
    }

    public void setNc(NC nc) {
        this.nc = nc;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PKAppartenere other = (PKAppartenere) obj;
        if (!Objects.equals(this.membro, other.membro)) {
            return false;
        }
        if (!Objects.equals(this.nc, other.nc)) {
            return false;
        }
        return true;
    }

}
