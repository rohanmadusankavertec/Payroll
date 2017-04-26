/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sumaga.hibe.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
@Entity
@Table(name = "adtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adtype.findAll", query = "SELECT a FROM Adtype a"),
    @NamedQuery(name = "Adtype.findById", query = "SELECT a FROM Adtype a WHERE a.id = :id"),
    @NamedQuery(name = "Adtype.findByName", query = "SELECT a FROM Adtype a WHERE a.name = :name")})
public class Adtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adtypeId")
    private Collection<AllowanceDeduction> allowanceDeductionCollection;
    

    public Adtype() {
    }

    public Adtype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adtype)) {
            return false;
        }
        Adtype other = (Adtype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sumaga.hibe.model.Adtype[ id=" + id + " ]";
    }

   
    @XmlTransient
    public Collection<AllowanceDeduction> getAllowanceDeductionCollection() {
        return allowanceDeductionCollection;
    }

    public void setAllowanceDeductionCollection(Collection<AllowanceDeduction> allowanceDeductionCollection) {
        this.allowanceDeductionCollection = allowanceDeductionCollection;
    }

    
    
}
