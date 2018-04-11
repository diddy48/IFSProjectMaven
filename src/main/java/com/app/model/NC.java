/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.objects.Priorita;
import com.app.objects.RepartoProdotto;
import com.app.objects.Tipo;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author roman
 */
@Entity
@Table(name = "NC")
public class NC implements Serializable {

    private int numeroNC;
    private String titolo;
    private String descrizione;
    private Date dataA;
    private Date dataC;
    private Priorita priorita;
    private Integer codiceProdotto;
    private Float costoNC;
    private RepartoProdotto repartoP;
    private String aContenimento;
    private String cause;
    private String aCorrettiva;
    private String aPreventiva;
    private String intesaComp;
    private Tipo tipo;
    private String cliente;
    private Dipendenti richiedente;
    private Dipendenti teamLeader;
    private Set<Appartenere> membri = new HashSet();
    private Set<Responsabilita> responsabili = new HashSet();

    public NC() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumeroNC")
    public int getNumeroNC() {
        return numeroNC;
    }

    public void setNumeroNC(int numeroNC) {
        this.numeroNC = numeroNC;
    }

    @Column(name = "Titolo", nullable = false, length = 30)
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Column(name = "Descrizione", nullable = false, length = 300)
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Column(name = "DataApertura", nullable = false)
    public Date getDataA() {
        return dataA;
    }

    public void setDataA(Date dataA) {
        this.dataA = dataA;
    }

    @Column(name = "DataChiusura")
    public Date getDataC() {
        return dataC;
    }

    public void setDataC(Date DataC) {
        this.dataC = DataC;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Priorita", nullable = false)
    public Priorita getPriorita() {
        return priorita;
    }

    public void setPriorita(Priorita priorita) {
        this.priorita = priorita;
    }

    @Column(name = "CodiceProdotto", nullable = false, length = 6)
    public Integer getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(Integer codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    @Column(name = "CostoNC")
    public Float getCostoNC() {
        return costoNC;
    }

    public void setCostoNC(Float costoNC) {
        this.costoNC = costoNC;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "RepartoProdotto", nullable = false)
    public RepartoProdotto getRepartoP() {
        return repartoP;
    }

    public void setRepartoP(RepartoProdotto repartoP) {
        this.repartoP = repartoP;
    }

    @Column(name = "AContenimento", length = 300)
    public String getaContenimento() {
        return aContenimento;
    }

    public void setaContenimento(String aContenimento) {
        this.aContenimento = aContenimento;
    }

    @Column(name = "Cause", length = 300)
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Column(name = "ACorrettiva", length = 300)
    public String getaCorrettiva() {
        return aCorrettiva;
    }

    public void setaCorrettiva(String aCorrettiva) {
        this.aCorrettiva = aCorrettiva;
    }

    @Column(name = "APreventiva", length = 300)
    public String getaPreventiva() {
        return aPreventiva;
    }

    public void setaPreventiva(String aPreventiva) {
        this.aPreventiva = aPreventiva;
    }

    @Column(name = "IntesaComprensione", length = 300)
    public String getIntesaComp() {
        return intesaComp;
    }

    public void setIntesaComp(String intesaComp) {
        this.intesaComp = intesaComp;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo", nullable = false)
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Column(name = "Cliente", length = 40)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Richiedente")
    public Dipendenti getRichiedente() {
        return richiedente;
    }

    public void setRichiedente(Dipendenti richiedente) {
        this.richiedente = richiedente;
    }

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TeamLeader", nullable = false)
    public Dipendenti getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Dipendenti teamLeader) {
        this.teamLeader = teamLeader;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pkAppartenere.nc", cascade = CascadeType.ALL)
    public Set<Appartenere> getMembri() {
        return membri;
    }

    public void setMembri(Set<Appartenere> membri) {
        this.membri = membri;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pkResponsabilita.nc", cascade = CascadeType.ALL)
    public Set<Responsabilita> getResponsabili() {
        return responsabili;
    }

    public void setResponsabili(Set<Responsabilita> responsabili) {
        this.responsabili = responsabili;
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
        final NC other = (NC) obj;
        if (this.numeroNC != other.numeroNC) {
            return false;
        }
        if (this.codiceProdotto != other.codiceProdotto) {
            return false;
        }
        if (Float.floatToIntBits(this.costoNC) != Float.floatToIntBits(other.costoNC)) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.aContenimento, other.aContenimento)) {
            return false;
        }
        if (!Objects.equals(this.cause, other.cause)) {
            return false;
        }
        if (!Objects.equals(this.aCorrettiva, other.aCorrettiva)) {
            return false;
        }
        if (!Objects.equals(this.aPreventiva, other.aPreventiva)) {
            return false;
        }
        if (!Objects.equals(this.intesaComp, other.intesaComp)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.dataA, other.dataA)) {
            return false;
        }
        if (!Objects.equals(this.dataC, other.dataC)) {
            return false;
        }
        if (this.priorita != other.priorita) {
            return false;
        }
        if (this.repartoP != other.repartoP) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.richiedente, other.richiedente)) {
            return false;
        }
        if (!Objects.equals(this.teamLeader, other.teamLeader)) {
            return false;
        }
        if (!Objects.equals(this.membri, other.membri)) {
            return false;
        }
        if (!Objects.equals(this.responsabili, other.responsabili)) {
            return false;
        }
        return true;
    }

}
