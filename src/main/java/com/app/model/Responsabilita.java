/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author FSEVERI\romano3927
 */
@Entity
@Table(name = "Responsabilita")
@AssociationOverrides({
    @AssociationOverride(name = "pkResponsabilita.responsabile",
            joinColumns = {
                @JoinColumn(name = "Matricola")})
    ,
    @AssociationOverride(name = "pkResponsabilita.nc",
            joinColumns = {
                @JoinColumn(name = "NumeroNC")})})
public class Responsabilita implements Serializable {

    private PKResponsabilita pkResponsabilita = new PKResponsabilita();
    private String repartoLavorativo;

    public Responsabilita() {
    }

    @EmbeddedId
    public PKResponsabilita getPkResponsabilita() {
        return pkResponsabilita;
    }

    public void setPkResponsabilita(PKResponsabilita pkResponsabilita) {
        this.pkResponsabilita = pkResponsabilita;
    }

    @Column(name = "RepartoLavorativo", length = 40)
    public String getRepartoLavorativo() {
        return repartoLavorativo;
    }

    public void setRepartoLavorativo(String repartoLavorativo) {
        this.repartoLavorativo = repartoLavorativo;
    }

    @Transient
    public Dipendenti getResponsabile() {
        return getPkResponsabilita().getResponsabile();
    }

    public void setResponsabile(Dipendenti dip) {
        getPkResponsabilita().setResponsabile(dip);
    }

    @Transient
    public NC getNc() {
        return getPkResponsabilita().getNc();
    }

    public void setNc(NC nc) {
        getPkResponsabilita().setNc(nc);
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
        final Responsabilita other = (Responsabilita) obj;
        if (!Objects.equals(this.repartoLavorativo, other.repartoLavorativo)) {
            return false;
        }
        if (!Objects.equals(this.pkResponsabilita, other.pkResponsabilita)) {
            return false;
        }
        return true;
    }

}
