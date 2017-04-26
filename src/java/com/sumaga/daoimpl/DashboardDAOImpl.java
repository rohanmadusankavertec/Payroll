/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.daoimpl;

import com.sumaga.dao.DashboardDAO;
import com.sumaga.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
public class DashboardDAOImpl implements DashboardDAO {

    public int getEmployees() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT COUNT(s.id) FROM Employee s Where s.isValid=:isValid ");
                query.setParameter("isValid", true);
                int cuList = Integer.parseInt(query.uniqueResult() + "");
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0;
    }

    public Double getAdvance() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT SUM(s.amount) FROM Advance s Where s.isValid=:isValid");
                query.setParameter("isValid", true);
                double cuList =0.0;
                if(query.uniqueResult()!=null){
                cuList =Double.parseDouble(query.uniqueResult() + "");
                
                }
                
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0.0;
    }

    public Double getSalaries() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT SUM(s.salaryPayable) FROM Salary s");
                double cuList = Double.parseDouble(query.uniqueResult() + "");
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0.0;
    }

    public Double getPayed() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT SUM(s.paid) FROM Salary s");
                double cuList = Double.parseDouble(query.uniqueResult() + "");
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0.0;
    }

    public Double getoutstanding() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT SUM(s.due) FROM Salary s");
                double cuList = Double.parseDouble(query.uniqueResult() + "");
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0.0;
    }
    public int getUser() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT COUNT(s.sysuserId) FROM SysUser s WHERE s.isActive=:isValid");
                query.setParameter("isValid", true);
                int cuList = Integer.parseInt(query.uniqueResult()+"");
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0;
    }
    public int getHoliday() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT COUNT(s.id) FROM HollyDay s ");
                int cuList = Integer.parseInt(query.uniqueResult()+"");
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0;
    }
    public int getLoans() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        if (session != null) {
            try {
                Query query = session.createQuery("SELECT COUNT(s.id) FROM Loan s WHERE s.balance>'0'");
                int cuList = Integer.parseInt(query.uniqueResult()+"");
                return cuList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return 0;
    }
}
