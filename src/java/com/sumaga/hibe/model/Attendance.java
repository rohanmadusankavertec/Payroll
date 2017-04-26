/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sumaga.hibe.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
@Entity
@Table(name = "attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
    @NamedQuery(name = "Attendance.findById", query = "SELECT a FROM Attendance a WHERE a.id = :id"),
    @NamedQuery(name = "Attendance.findByIntime", query = "SELECT a FROM Attendance a WHERE a.intime = :intime"),
    @NamedQuery(name = "Attendance.findByOuttime", query = "SELECT a FROM Attendance a WHERE a.outtime = :outtime"),
    @NamedQuery(name = "Attendance.findByDate", query = "SELECT a FROM Attendance a WHERE a.date = :date")})
public class Attendance implements Serializable {
    @Column(name = "marked_date")
    @Temporal(TemporalType.DATE)
    private Date markedDate;
    @Column(name = "is_valid")
    private Boolean isValid;
    @JoinColumn(name = "marked_by", referencedColumnName = "sysuser_id")
    @ManyToOne(optional = false)
    private SysUser markedBy;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "intime")
    @Temporal(TemporalType.TIME)
    private Date intime;
    @Column(name = "outtime")
    @Temporal(TemporalType.TIME)
    private Date outtime;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public Attendance() {
    }

    public Attendance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sumaga.hibe.model.Attendance[ id=" + id + " ]";
    }

    public Date getMarkedDate() {
        return markedDate;
    }

    public void setMarkedDate(Date markedDate) {
        this.markedDate = markedDate;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public SysUser getMarkedBy() {
        return markedBy;
    }

    public void setMarkedBy(SysUser markedBy) {
        this.markedBy = markedBy;
    }
    
}
