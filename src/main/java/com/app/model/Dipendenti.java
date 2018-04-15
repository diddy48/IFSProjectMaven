/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author romano3927
 */
@Entity
@Table(name = "Dipendenti")
public class Dipendenti implements Serializable {

    private int matricola;
    private String cf;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private com.app.model.User username;
    private Set<NC> ncLeader = new HashSet();
    private Set<NC> ncRichiede = new HashSet();
    private Set<Appartenere> ncAppartiene = new HashSet();
    private Set<Responsabilita> ncResponsabile = new HashSet();

    public Dipendenti() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matricola")
    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    @Column(name = "CF", nullable = false, length = 16)
    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    @Column(name = "Nome", nullable = false, length = 30)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "Cognome", nullable = false, length = 30)
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Column(name = "DataNascita", nullable = false)
    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    /*@Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }*/

    @OneToOne(cascade = CascadeType.ALL)//(fetch = FetchType.EAGER, mappedBy = "usernameDip", cascade = CascadeType.ALL)
    @JoinColumn(name = "Username")
    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @OneToMany(fetch = EAGER, mappedBy = "teamLeader")
    public Set<NC> getNcLeader() {
        return ncLeader;
    }

    public void setNcLeader(Set<NC> ncLeader) {
        this.ncLeader = ncLeader;
    }

    @OneToMany(fetch = EAGER, mappedBy = "richiedente")
    public Set<NC> getNcRichiede() {
        return ncRichiede;
    }

    public void setNcRichiede(Set<NC> ncRichiede) {
        this.ncRichiede = ncRichiede;
    }

    @OneToMany(fetch = EAGER, mappedBy = "pkAppartenere.membro", cascade = CascadeType.ALL)
    public Set<Appartenere> getNcAppartiene() {
        return ncAppartiene;
    }

    public void setNcAppartiene(Set<Appartenere> ncAppartiene) {
        this.ncAppartiene = ncAppartiene;
    }

    @OneToMany(fetch = EAGER, mappedBy = "pkResponsabilita.responsabile", cascade = CascadeType.ALL)
    public Set<Responsabilita> getNcResponsabile() {
        return ncResponsabile;
    }

    public void setNcResponsabile(Set<Responsabilita> ncResponsabile) {
        this.ncResponsabile = ncResponsabile;
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
        final Dipendenti other = (Dipendenti) obj;
        if (this.matricola != other.matricola) {
            return false;
        }
        if (!Objects.equals(this.cf, other.cf)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.dataNascita, other.dataNascita)) {
            return false;
        }
        if (!Objects.equals(this.ncLeader, other.ncLeader)) {
            return false;
        }
        if (!Objects.equals(this.ncRichiede, other.ncRichiede)) {
            return false;
        }
        if (!Objects.equals(this.ncAppartiene, other.ncAppartiene)) {
            return false;
        }
        if (!Objects.equals(this.ncResponsabile, other.ncResponsabile)) {
            return false;
        }
        return true;
    }
}
