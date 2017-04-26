/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.dao;

import com.sumaga.hibe.model.PrivilegeItem;
import com.sumaga.hibe.model.SysUser;
import com.sumaga.hibe.model.UserGroup;
import com.sumaga.hibe.model.UserGroupPrivilegeItem;
import java.util.List;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
public interface UserDAO {

    public abstract SysUser userlogin(SysUser sysUser);

    public abstract String registerUser(SysUser sysUser);

    public abstract String updateUser(SysUser sysUser);

    public abstract String saveUGPI(UserGroupPrivilegeItem ugpi);

    public abstract String checkemail(String email);

    public abstract String checkUsername(String username);

    public abstract List<SysUser> getListofUsers();

    public abstract List<PrivilegeItem> allDefPriv();

    public abstract String removeUser(int userId);

    public abstract String updatePassword(SysUser su);

    public abstract UserGroup createUserGroup(UserGroup ug);

    public abstract SysUser viewUser(int userId);

}
