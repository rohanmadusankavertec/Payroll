/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.dao;

import java.util.List;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
public interface ReportDAO {

    public abstract List<Object[]> invoiceItemToReport(int invoiceId);

    public abstract Object[] invoiceHeaderToReport(int invoiceId);

    public abstract List<Object[]> dailyInvoiceReport(String selectDate);

    public abstract List<Object[]> periodicallyInvoiceReport(String[] daeArr);

    public abstract List<Object[]> periodicallyOutstanding();

    public abstract List<Object[]> branchWiseProduct(int branchId);

    public abstract List<Object[]> branchWiseProductMaster(int branchId);

    public abstract List<Object[]> releaseProductBranchWise(String[] date, int branchId);

    public abstract List<Object[]> releaseProductPeriodicalyyVehicle(String[] date);

    public abstract List<Object[]> releaseProductPeriodicalyySP(String[] date, int user_id);

    public abstract int getLastInvoiceId();

}
