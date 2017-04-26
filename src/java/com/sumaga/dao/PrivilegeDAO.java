/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.dao;

import com.sumaga.hibe.model.Priviledge;
import com.sumaga.hibe.model.PrivilegeItem;
import com.sumaga.hibe.model.UserGroup;
import com.sumaga.hibe.model.UserGroupPriviledge;
import com.sumaga.hibe.model.UserGroupPrivilegeItem;
import java.util.List;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
public interface PrivilegeDAO {

    public abstract List<Priviledge> loadAllPrivileges();

    public abstract List<PrivilegeItem> loadAllPrivilegeItems();

    public abstract List<UserGroup> loadAllUserGroup();

    public abstract List<UserGroupPriviledge> loadAllUserGroupPrivilege(int groupId);

    public abstract List<Object[]> loadAllUserGroupPrivilegeItem(int groupId);

    public abstract String savePrivilege(Priviledge priviledge);

    public abstract String updatePrivilege(Priviledge priviledge);

    public abstract List<Object[]> loadNotInAllPrivileges(int ugId);

    public abstract List<Object[]> loadNotInAllPrivilegeItems(int ugId);

    public abstract String saveUGPrivilege(UserGroupPriviledge ugp);

    public abstract String saveUGPrivilegeItem(UserGroupPrivilegeItem ugp);

    public abstract String savePrivilegeItem(PrivilegeItem pi);

    public abstract String removeUGPrivilege(int ugp);

    public abstract String removeUGPrivilegeItem(int ugp);

    public abstract String updatePrivilegeItem(PrivilegeItem privilegeItem);

    public abstract PrivilegeItem ViewPrivilegeItem(PrivilegeItem privilegeItem);
}
