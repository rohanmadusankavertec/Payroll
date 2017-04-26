/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.hibe.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "sys_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUser.findAll", query = "SELECT s FROM SysUser s"),
    @NamedQuery(name = "SysUser.findBySysuserId", query = "SELECT s FROM SysUser s WHERE s.sysuserId = :sysuserId"),
    @NamedQuery(name = "SysUser.findByUsername", query = "SELECT s FROM SysUser s WHERE s.username = :username"),
    @NamedQuery(name = "SysUser.findByPassword", query = "SELECT s FROM SysUser s WHERE s.password = :password"),
    @NamedQuery(name = "SysUser.findByIsActive", query = "SELECT s FROM SysUser s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "SysUser.findByFirstName", query = "SELECT s FROM SysUser s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "SysUser.findByLastName", query = "SELECT s FROM SysUser s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "SysUser.findByEmailAdd", query = "SELECT s FROM SysUser s WHERE s.emailAdd = :emailAdd"),
    @NamedQuery(name = "SysUser.findByContactNo", query = "SELECT s FROM SysUser s WHERE s.contactNo = :contactNo"),
    @NamedQuery(name = "SysUser.findByNicNo", query = "SELECT s FROM SysUser s WHERE s.nicNo = :nicNo"),
    @NamedQuery(name = "SysUser.findByDob", query = "SELECT s FROM SysUser s WHERE s.dob = :dob"),
    @NamedQuery(name = "SysUser.findByAddedDate", query = "SELECT s FROM SysUser s WHERE s.addedDate = :addedDate"),
    @NamedQuery(name = "SysUser.findByAddedBy", query = "SELECT s FROM SysUser s WHERE s.addedBy = :addedBy"),
    @NamedQuery(name = "SysUser.findByLastUpdatedDate", query = "SELECT s FROM SysUser s WHERE s.lastUpdatedDate = :lastUpdatedDate"),
    @NamedQuery(name = "SysUser.findByLastUpdatedBy", query = "SELECT s FROM SysUser s WHERE s.lastUpdatedBy = :lastUpdatedBy")})
public class SysUser implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sysUserSysuserId")
    private Collection<Loan> loanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addedBy")
    private Collection<BankAccounts> bankAccountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lastUpdatedBy")
    private Collection<BankAccounts> bankAccountsCollection1;
    @Column(name = "last_updated_date")
    @Temporal(TemporalType.DATE)
    private Date lastUpdatedDate;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "markedBy")
    private Collection<Attendance> attendanceCollection;
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sysuser_id")
    private Integer sysuserId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_add")
    private String emailAdd;
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @Column(name = "nic_no")
    private String nicNo;
    @Column(name = "dob")
    private String dob;
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @Column(name = "added_by")
    private Integer addedBy;
    @Column(name = "last_updated_by")
    private Integer lastUpdatedBy;
    @JoinColumn(name = "user_group_id", referencedColumnName = "user_group_id")
    @ManyToOne(optional = false)
    private UserGroup userGroupId;
    private transient String loginStatus;

    public SysUser() {
    }

    public SysUser(Integer sysuserId) {
        this.sysuserId = sysuserId;
    }

    public SysUser(Integer sysuserId, String password) {
        this.sysuserId = sysuserId;
        this.password = password;
    }
    

    public SysUser(String username, String password, boolean isActive, String firstName, String lastName, String emailAdd, String contactNo, String nicNo, String dob, Date addedDate, Integer addedBy, Date lastUpdatedDate, Integer lastUpdatedBy, UserGroup userGroupId) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdd = emailAdd;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
        this.dob = dob;
        this.addedDate = addedDate;
        this.addedBy = addedBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.userGroupId = userGroupId;
    }
//public SysUser(String username, String password, boolean isActive, String firstName, String lastName, String emailAdd, String contactNo, String nicNo, String dob, Date addedDate, Integer addedBy, Date lastUpdatedDate, Integer lastUpdatedBy, UserGroup userGroupId) {
//        this.username = username;
//        this.password = password;
//        this.isActive = isActive;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.emailAdd = emailAdd;
//        this.contactNo = contactNo;
//        this.nicNo = nicNo;
//        this.dob = dob;
//        this.addedDate = addedDate;
//        this.addedBy = addedBy;
//        this.lastUpdatedDate = lastUpdatedDate;
//        this.lastUpdatedBy = lastUpdatedBy;
//        this.userGroupId = userGroupId;
//    }
    public SysUser(Integer sysuserId, String firstName, String lastName, String emailAdd, String contactNo, String nicNo, String dob, Date lastUpdatedDate, Integer lastUpdatedBy) {
        this.sysuserId = sysuserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdd = emailAdd;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
        this.dob = dob;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
    }
    public SysUser(Integer sysuserId, String firstName, String lastName, String emailAdd, String contactNo, String nicNo, String dob, Date lastUpdatedDate, Integer lastUpdatedBy,UserGroup ug) {
        this.sysuserId = sysuserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdd = emailAdd;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
        this.dob = dob;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.userGroupId=ug;
    }
    

    public SysUser(Integer sysuserId, String username, String password, boolean isActive, String nicNo) {
        this.sysuserId = sysuserId;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.nicNo = nicNo;
    }

    public Integer getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(Integer sysuserId) {
        this.sysuserId = sysuserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    
    public UserGroup getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(UserGroup userGroupId) {
        this.userGroupId = userGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysuserId != null ? sysuserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUser)) {
            return false;
        }
        SysUser other = (SysUser) object;
        if ((this.sysuserId == null && other.sysuserId != null) || (this.sysuserId != null && !this.sysuserId.equals(other.sysuserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sumaga.hibe.model.SysUser[ sysuserId=" + sysuserId + " ]";
    }

    /**
     * @return the loginStatus
     */
    public String getLoginStatus() {
        return loginStatus;
    }

    /**
     * @param loginStatus the loginStatus to set
     */
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


    @XmlTransient
    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
    }

    @XmlTransient
    public Collection<BankAccounts> getBankAccountsCollection() {
        return bankAccountsCollection;
    }

    public void setBankAccountsCollection(Collection<BankAccounts> bankAccountsCollection) {
        this.bankAccountsCollection = bankAccountsCollection;
    }

    @XmlTransient
    public Collection<BankAccounts> getBankAccountsCollection1() {
        return bankAccountsCollection1;
    }

    public void setBankAccountsCollection1(Collection<BankAccounts> bankAccountsCollection1) {
        this.bankAccountsCollection1 = bankAccountsCollection1;
    }

    @XmlTransient
    public Collection<Loan> getLoanCollection() {
        return loanCollection;
    }

    public void setLoanCollection(Collection<Loan> loanCollection) {
        this.loanCollection = loanCollection;
    }


    

}
