/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.util.Objects;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author FSEVERI\romano3927
 */
@Entity
@Table(name = "Appartenere")
@AssociationOverrides({
    @AssociationOverride(name = "pkAppartenere.membro",
        joinColumns =@JoinColumn(name = "Matricola")),
    @AssociationOverride(name = "pkAppartenere.nc",
        joinColumns =@JoinColumn(name = "NumeroNC")) })
public class Appartenere {
    
    private PKAppartenere pkAppartenere = new PKAppartenere();
    private String ruolo;

    public Appartenere() {
    }
    
    @EmbeddedId
    public PKAppartenere getPkAppartenere() {
        return pkAppartenere;
    }

    public void setPkAppartenere(PKAppartenere pkAppartenere) {
        this.pkAppartenere = pkAppartenere;
    }

    @Column(name="Ruolo",length=50)
    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    
    @Transient
    public Dipendenti getMembro() {
        return getPkAppartenere().getMembro();
    }

    public void setMembro(Dipendenti dip) {
        getPkAppartenere().setMembro(dip);
    }

    @Transient
    public NC getNc() {
        return getPkAppartenere().getNc();
    }

    public void setNc(NC nc) {
        getPkAppartenere().setNc(nc);
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
        final Appartenere other = (Appartenere) obj;
        if (!Objects.equals(this.ruolo, other.ruolo)) {
            return false;
        }
        if (!Objects.equals(this.pkAppartenere, other.pkAppartenere)) {
            return false;
        }
        return true;
    }

}
