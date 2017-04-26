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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "designation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Designation.findAll", query = "SELECT d FROM Designation d"),
    @NamedQuery(name = "Designation.findById", query = "SELECT d FROM Designation d WHERE d.id = :id"),
    @NamedQuery(name = "Designation.findByName", query = "SELECT d FROM Designation d WHERE d.name = :name"),
    @NamedQuery(name = "Designation.findByIsValid", query = "SELECT d FROM Designation d WHERE d.isValid = :isValid")})
public class Designation implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationId")
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "is_valid")
    private Boolean isValid;
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Department departmentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designationId")
    private Collection<Employee> employeeCollection;

    public Designation() {
    }

    public Designation(Integer id) {
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

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
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
        if (!(object instanceof Designation)) {
            return false;
        }
        Designation other = (Designation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sumaga.hibe.model.Designation[ id=" + id + " ]";
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }


    
    
}
