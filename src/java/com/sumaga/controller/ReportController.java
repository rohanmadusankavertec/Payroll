/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.controller;

import com.sumaga.daoimpl.AttendanceDAOImpl;
import com.sumaga.daoimpl.BankDAOImpl;
import com.sumaga.daoimpl.DashboardDAOImpl;
import com.sumaga.daoimpl.EmployeeDAOImpl;
import com.sumaga.daoimpl.SalaryDAOImpl;
import com.sumaga.hibe.model.Advance;
import com.sumaga.hibe.model.AllowanceDeduction;
import com.sumaga.hibe.model.Attendance;
import com.sumaga.hibe.model.BankAccounts;
import com.sumaga.hibe.model.Employee;
import com.sumaga.hibe.model.HollyDay;
import com.sumaga.hibe.model.Leaves;
import com.sumaga.hibe.model.Loan;
import com.sumaga.hibe.model.Salary;
import com.sumaga.hibe.model.SalaryPayment;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
@WebServlet(name = "ReportController", urlPatterns = {"/ReportController"})
public class ReportController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final EmployeeDAOImpl EmployeeDAOImpl = new EmployeeDAOImpl();
    private final AttendanceDAOImpl AttendanceDAOImpl = new AttendanceDAOImpl();
    private final BankDAOImpl bankDAOImpl = new BankDAOImpl();
    private final SalaryDAOImpl salaryDAOImpl = new SalaryDAOImpl();
    private final DashboardDAOImpl dashboardDAOImpl = new DashboardDAOImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            RequestDispatcher requestDispatcher;
            switch (action) {
                //Open Search employee Page
                case "SearchEmployee": {
                    List<Employee> e = EmployeeDAOImpl.getEmployees();
                    request.setAttribute("employee", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/SearchEmployee.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View Employee Profile
                case "ViewProfile": {
                    String id = request.getParameter("employee");
                    Employee e = EmployeeDAOImpl.getEmployee(Integer.parseInt(id));
                    System.out.println(e.getImage());
                     String path = getServletContext().getRealPath(e.getImage());
                     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>?"+path);
                    request.setAttribute("employee", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/EmployeeProfile.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                // View Employee Report
                case "Employees": {
                    List<Employee> e = EmployeeDAOImpl.getEmployees();
                    request.setAttribute("employee", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/EmployeeReport.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                // Open Leaves Search Page
                case "Leaves": {
                    List<Employee> e = EmployeeDAOImpl.getEmployees();
                    request.setAttribute("employee", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/SearchLeaves.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                // Open Leaves Report
                case "LeaveReport": {
                    try {
                        String type = request.getParameter("type");
                        String employee = request.getParameter("emp");
                        String from = request.getParameter("from");
                        String to = request.getParameter("to");

                        List<Leaves> l = null;

                        if (type.equals("0")) {
                            l = AttendanceDAOImpl.getLeave();
                        } else if (type.equals("1")) {
                            l = AttendanceDAOImpl.getLeaveReportByEmployee(Integer.parseInt(employee));
                        } else if (type.equals("2")) {
                            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

                            l = AttendanceDAOImpl.getLeaveReportByDateRange(DateFormat.parse(from), DateFormat.parse(to));

                        } else if (type.equals("3")) {
                            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            l = AttendanceDAOImpl.getLeaveReportByDate(DateFormat.parse(from));
                        }

                        request.setAttribute("leaves", l);
                        requestDispatcher = request.getRequestDispatcher("app/Report/LeaveReport.jsp");
                        requestDispatcher.forward(request, response);
                        break;
                    } catch (ParseException ex) {
                        Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                // Open Search Attendance Page
                case "Attendance": {
                    List<Employee> e = EmployeeDAOImpl.getEmployees();
                    request.setAttribute("employee", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/SearchAttendance.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                // View Attendance Report
                case "AttendanceReport": {
                    try {
                        String type = request.getParameter("type");
                        String employee = request.getParameter("emp");
                        String from = request.getParameter("from");
                        String to = request.getParameter("to");

                        List<Attendance> l = null;

                        if (type.equals("0")) {
                            l = AttendanceDAOImpl.getAttendance();
                        } else if (type.equals("1")) {
                            l = AttendanceDAOImpl.getattendanceByEmployee(Integer.parseInt(employee));
                        } else if (type.equals("2")) {
                            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

                            l = AttendanceDAOImpl.getattendanceByDateRange(DateFormat.parse(from), DateFormat.parse(to));

                        } else if (type.equals("3")) {
                            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            l = AttendanceDAOImpl.getattendanceByDate(DateFormat.parse(from));
                        }

                        request.setAttribute("leaves", l);
                        requestDispatcher = request.getRequestDispatcher("app/Report/AttendanceReport.jsp");
                        requestDispatcher.forward(request, response);
                        break;
                    } catch (ParseException ex) {
                        Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //View Bank Account Report
                case "Bank": {
                    List<BankAccounts> e = bankDAOImpl.loadAllBankAccount();
                    request.setAttribute("bankaccounts", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/BankAccounts.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View Allowance And deduction Report
                case "Allowance": {
                    List<AllowanceDeduction> e = salaryDAOImpl.getAllowanceDeduction();
                    request.setAttribute("allowance", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/AllowanceDeduction.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View Staff Loan Report
                case "staffloans": {
                    List<Loan> loan = salaryDAOImpl.getLoans();
                    request.setAttribute("loan", loan);
                    requestDispatcher = request.getRequestDispatcher("app/Report/StaffLoans.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View holiday Report
                case "holiday": {
                    List<HollyDay> hd = salaryDAOImpl.getHollyDays();
                    request.setAttribute("holiday", hd);
                    requestDispatcher = request.getRequestDispatcher("app/Report/Holidays.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View Advance Payment Report
                case "advanse": {
                    List<Advance> ad = salaryDAOImpl.getAdvance();
                    request.setAttribute("advance", ad);
                    requestDispatcher = request.getRequestDispatcher("app/Report/AdvancePayments.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View Salary Report
                case "salary": {
                    List<Salary> ad = salaryDAOImpl.getSalary();
                    request.setAttribute("salary", ad);
                    requestDispatcher = request.getRequestDispatcher("app/Report/Salary.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View Salary Payment Report
                case "salarypayment": {
                    List<SalaryPayment> ad = salaryDAOImpl.getSalaryPayments();
                    request.setAttribute("sp", ad);
                    requestDispatcher = request.getRequestDispatcher("app/Report/SalaryPayment.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View EPF Payable REport
                case "epf": {
                    List<Salary> ad = salaryDAOImpl.getSalary();
                    request.setAttribute("salary", ad);
                    requestDispatcher = request.getRequestDispatcher("app/Report/EPFPayable.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //View ETF Payable Report
                case "etf": {
                    List<Salary> ad = salaryDAOImpl.getSalary();
                    request.setAttribute("salary", ad);
                    requestDispatcher = request.getRequestDispatcher("app/Report/ETFPayable.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                // View PaySlip Report
                case "payslip": {
                    List<Employee> e = EmployeeDAOImpl.getEmployees();
                    request.setAttribute("employee", e);
                    requestDispatcher = request.getRequestDispatcher("app/Report/SearchPayslip.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                // Get Salary period Json Object
                case "getSalaryperiod": {
                    String id = request.getParameter("id");
                    List<Salary> des = salaryDAOImpl.getSalaryByEmployee(Integer.parseInt(id));
                    JSONObject jOB = new JSONObject();
                    JSONArray jar1 = new JSONArray();
                    JSONObject job1 = null;
                    for (Salary d : des) {
                        job1 = new JSONObject();
                        job1.put("id", d.getId());
                        String from = d.getFromdate().toString().replace("-", "/");
                        String to = d.getTodate().toString().replace("-", "/");
                        job1.put("from", from);
                        job1.put("to", to);
                        jar1.add(job1);
                    }
                    jOB.put("des", jar1);
                    response.getWriter().write(jOB.toString());
                    break;
                }
                //View payslip Report
                case "Viewpayslip": {
                    String salary = request.getParameter("salary");
                    Salary s = salaryDAOImpl.getSalaryByID(Integer.parseInt(salary));
                    request.setAttribute("salary", s);
                    requestDispatcher = request.getRequestDispatcher("app/Report/PaySlip.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //Get details for dashboard components
                case "dashboard": {
                    JSONObject jOB = new JSONObject();
                    JSONArray jar1 = new JSONArray();
                    JSONObject job1 = new JSONObject();
                    job1.put("employee", dashboardDAOImpl.getEmployees());
                    job1.put("advance", dashboardDAOImpl.getAdvance());
                    double salaries = dashboardDAOImpl.getSalaries();
                    double payments = dashboardDAOImpl.getPayed();
                    job1.put("salary", salaries);
                    job1.put("payment", payments);
                    job1.put("outstanding", salaries - payments);
                    job1.put("loan", dashboardDAOImpl.getLoans());
                    job1.put("holiday", dashboardDAOImpl.getHoliday());
                    job1.put("users", dashboardDAOImpl.getUser());
                    jar1.add(job1);
                    jOB.put("des", jar1);
                    response.getWriter().write(jOB.toString());
                    break;
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
